package io.itch._tymon1.Lab3.controller.impl;

import io.itch._tymon1.Lab3.EmpireService;
import io.itch._tymon1.Lab3.controller.api.EmpireController;
import io.itch._tymon1.Lab3.dto.GetEmpireResponse;
import io.itch._tymon1.Lab3.dto.GetEmpiresResponse;
import io.itch._tymon1.Lab3.dto.PatchEmpireRequest;
import io.itch._tymon1.Lab3.dto.PutEmpireRequest;
import io.itch._tymon1.Lab3.event.repository.rest.EmpireEventRestRepository;
import io.itch._tymon1.Lab3.function.EmpireToResponseFunction;
import io.itch._tymon1.Lab3.function.EmpiresToResponseFunction;
import io.itch._tymon1.Lab3.function.RequestToEmpire;
import io.itch._tymon1.Lab3.function.UpdateEmpireWithRequest;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class EmpireDefaultController implements EmpireController {

    private final EmpireService service;

    private final EmpireToResponseFunction empireToResponse;

    private final EmpiresToResponseFunction empiresToResponse;

    private final RequestToEmpire requestToEmpire;

    private final UpdateEmpireWithRequest updateEmpireWithRequest;

    private final EmpireEventRestRepository empireEventRestRepository;


    @Autowired
    public EmpireDefaultController(
            EmpireService service,
            EmpireToResponseFunction empireToResponse,
            EmpiresToResponseFunction empiresToResponse,
            RequestToEmpire requestToEmpire, UpdateEmpireWithRequest updateEmpireWithRequest, EmpireEventRestRepository empireEventRestRepository
    ) {
        this.service = service;
        this.empireToResponse = empireToResponse;
        this.empiresToResponse = empiresToResponse;
        this.requestToEmpire = requestToEmpire;
        this.updateEmpireWithRequest = updateEmpireWithRequest;
        this.empireEventRestRepository = empireEventRestRepository;
    }

    @Override
    public GetEmpiresResponse getEmpires() {
        return empiresToResponse.apply(service.findAll());
    }

    @Override
    public GetEmpireResponse getEmpire(UUID id) {
        return service.findById(id)
                .map(empireToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteEmpire(UUID id) {
        service.findById(id)
                .ifPresentOrElse(
                        empire -> service.deleteById(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

    @Override
    public void putEmpire(UUID id, PutEmpireRequest request) {
        service.save(requestToEmpire.apply(id, request));
        empireEventRestRepository.put(id, id);
    }

    @Override
    public void patchEmpire(UUID id, PatchEmpireRequest request) {
        service.findById(id).ifPresentOrElse(colony -> service.save(updateEmpireWithRequest.apply(colony, request)),
                () -> {throw  new ResponseStatusException(HttpStatus.NOT_FOUND);});

    }

}
