package io.itch._tymon1.Lab3.controller.api;

import io.itch._tymon1.Lab3.dto.GetColoniesResponse;
import io.itch._tymon1.Lab3.dto.GetColonyResponse;
import io.itch._tymon1.Lab3.dto.PatchColonyRequest;
import io.itch._tymon1.Lab3.dto.PutColonyRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface ColonyController {

    @GetMapping("api/colonies")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetColoniesResponse getColonies();

    @GetMapping("/api/empires/{empireId}/colonies")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetColoniesResponse getEmpireColonies(
            @PathVariable("empireId")
            UUID userId
    );

    @GetMapping("/api/colonies/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetColonyResponse getColony(
            @PathVariable("id")
            UUID id
    );

    @GetMapping("/api/empires/{empireId}/colonies/{colonyId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetColonyResponse getEmpireColony(
            @PathVariable("empireId")
            UUID empireId,
            @PathVariable("colonyId")
            UUID colonyId
    );

    @PutMapping("/api/colonies/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putColony(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutColonyRequest request
    );

    @DeleteMapping("/api/colonies/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteColony(
            @PathVariable("id")
            UUID id
    );

    @PatchMapping("/api/colonies/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void patchColony(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PatchColonyRequest request
    );
}
