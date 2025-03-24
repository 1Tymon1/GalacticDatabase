package io.itch._tymon1.Lab3.controller.api;

import io.itch._tymon1.Lab3.dto.GetEmpireResponse;
import io.itch._tymon1.Lab3.dto.GetEmpiresResponse;
import io.itch._tymon1.Lab3.dto.PutColonyRequest;
import io.itch._tymon1.Lab3.dto.PutEmpireRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface EmpireController {

    @DeleteMapping("/api/empires/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteEmpire(
            @PathVariable("id")
            UUID id
    );

    @PutMapping("/api/empires/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putEmpire(
            @PathVariable("id")
            UUID id,
            @RequestBody
            UUID uuid
    );
}
