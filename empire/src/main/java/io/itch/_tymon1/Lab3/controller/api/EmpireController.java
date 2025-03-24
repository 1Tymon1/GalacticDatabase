package io.itch._tymon1.Lab3.controller.api;

import io.itch._tymon1.Lab3.dto.GetEmpireResponse;
import io.itch._tymon1.Lab3.dto.GetEmpiresResponse;
import io.itch._tymon1.Lab3.dto.PatchEmpireRequest;
import io.itch._tymon1.Lab3.dto.PutEmpireRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface EmpireController {
    @GetMapping("api/empires")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetEmpiresResponse getEmpires();

    @GetMapping("/api/empires/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetEmpireResponse getEmpire(
            @PathVariable("id")
            UUID id
    );

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
            PutEmpireRequest request
    );

    @PatchMapping("/api/empires/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void patchEmpire(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PatchEmpireRequest request
    );

}
