package com.attila.taskmanager.gametrackerapp.controller;

import com.attila.taskmanager.gametrackerapp.dto.request.PlatformCreateCommand;
import com.attila.taskmanager.gametrackerapp.service.PlatformService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

}
