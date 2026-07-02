package com.attila.taskmanager.gametrackerapp.controller;

import com.attila.taskmanager.gametrackerapp.dto.request.PlatformCreateCommand;
import com.attila.taskmanager.gametrackerapp.dto.response.PlatformDropdownResponse;
import com.attila.taskmanager.gametrackerapp.dto.response.PlatformSummary;
import com.attila.taskmanager.gametrackerapp.service.PlatformService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/platform")
@RequiredArgsConstructor
public class PlatformController {

    private final PlatformService platformService;

    @PostMapping
    public ResponseEntity<Void> createPlatform(@Valid @RequestBody PlatformCreateCommand command) {
        Long platformId = platformService.createPlatform(command);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(platformId)
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<PlatformDropdownResponse>> getPlatforms() {
        List<PlatformDropdownResponse> response = platformService.getPlatforms();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/summary")
    public ResponseEntity<List<PlatformSummary>> platformSummary() {
        List<PlatformSummary> platformSummaries = platformService.platformSummary();

        return ResponseEntity.ok(platformSummaries);
    }

}
