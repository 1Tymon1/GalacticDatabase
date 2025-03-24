package io.itch._tymon1.Lab3.controller.impl;

import io.itch._tymon1.Lab3.Empire;
import io.itch._tymon1.Lab3.dto.PutEmpireRequest;
import io.itch._tymon1.Lab3.service.impl.EmpireService;
import io.itch._tymon1.Lab3.controller.api.EmpireController;
import io.itch._tymon1.Lab3.dto.GetEmpireResponse;
import io.itch._tymon1.Lab3.dto.GetEmpiresResponse;
import io.itch._tymon1.Lab3.function.EmpireToResponseFunction;
import io.itch._tymon1.Lab3.function.EmpiresToResponseFunction;
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

    @Autowired
    public EmpireDefaultController(
            EmpireService service,
            EmpireToResponseFunction empireToResponse,
            EmpiresToResponseFunction empiresToResponse
    ) {
        this.service = service;
        this.empireToResponse = empireToResponse;
        this.empiresToResponse = empiresToResponse;
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
    public void putEmpire(UUID id, UUID request) {
        service.save(Empire.builder().id(request).build());
    }

}
