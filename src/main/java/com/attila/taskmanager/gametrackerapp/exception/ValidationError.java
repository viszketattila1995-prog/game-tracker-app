package com.attila.taskmanager.gametrackerapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationError {

    @AllArgsConstructor
    @Getter
    public static class FieldErrorDTO {

        private String fieldError;
        private String message;
    }

    private final List<FieldErrorDTO> fieldErrors = new ArrayList<>();

    public void addFieldError(String path, String message) {
        FieldErrorDTO error = new FieldErrorDTO(path, message);
        fieldErrors.add(error);
    }
}
