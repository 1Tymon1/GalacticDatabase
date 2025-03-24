package io.itch._tymon1.Lab3.controller.impl;


import io.itch._tymon1.Lab3.service.impl.ColonyService;
import io.itch._tymon1.Lab3.service.impl.EmpireService;
import io.itch._tymon1.Lab3.controller.api.ColonyController;
import io.itch._tymon1.Lab3.dto.GetColoniesResponse;
import io.itch._tymon1.Lab3.dto.GetColonyResponse;
import io.itch._tymon1.Lab3.dto.PatchColonyRequest;
import io.itch._tymon1.Lab3.dto.PutColonyRequest;
import io.itch._tymon1.Lab3.function.ColoniesToResponseFunction;
import io.itch._tymon1.Lab3.function.ColonyToResponseFunction;
import io.itch._tymon1.Lab3.function.RequestToColonyFunction;
import io.itch._tymon1.Lab3.function.UpdateColonyWithRequestFunction;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class ColonyDefaultController implements ColonyController{

    private final ColonyService service;
    private final EmpireService empireService;

    private final ColonyToResponseFunction colonyToResponse;

    private final ColoniesToResponseFunction coloniesToResponse;

    private final RequestToColonyFunction requestToColony;

    private final UpdateColonyWithRequestFunction updateColonyWithRequest;


    @Autowired
    public ColonyDefaultController(
            ColonyService service,
            EmpireService empireService,
            ColonyToResponseFunction colonyToResponse,
            ColoniesToResponseFunction coloniesToResponse,
            RequestToColonyFunction requestToColony,
            UpdateColonyWithRequestFunction updateColonyWithRequest
    ) {
        this.service = service;
        this.empireService = empireService;
        this.colonyToResponse = colonyToResponse;
        this.coloniesToResponse = coloniesToResponse;
        this.requestToColony = requestToColony;
        this.updateColonyWithRequest = updateColonyWithRequest;
    }

    @Override
    public GetColoniesResponse getColonies() {
        return coloniesToResponse.apply(service.findAll());
    }

    @Override
    public GetColoniesResponse getEmpireColonies(UUID empireId) {
        if (empireService.findById(empireId).isPresent()) {
            return service.findByEmpire(empireService.findById(empireId).get())
                    .map(coloniesToResponse)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        } else
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public GetColonyResponse getColony(UUID id) {
        return service.findById(id)
                .map(colonyToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @Override
    public GetColonyResponse getEmpireColony(UUID empireId, UUID ColonyId) {
        return null;
    }

    @Override
    public void putColony(UUID id, PutColonyRequest request) {
        service.save(requestToColony.apply(id, request));
    }

    @Override
    public void deleteColony(UUID id) {
        service.findById(id)
                .ifPresentOrElse(colony -> service.deleteById(id),
                        () -> { throw new ResponseStatusException(HttpStatus.NOT_FOUND);});
    }

    @Override
    public void patchColony(UUID id, PatchColonyRequest request) {
        service.findById(id).ifPresentOrElse(colony -> service.save(updateColonyWithRequest.apply(colony, request)),
                () -> {throw  new ResponseStatusException(HttpStatus.NOT_FOUND);});

    }
}
