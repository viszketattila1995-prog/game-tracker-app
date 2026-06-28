package com.attila.taskmanager.gametrackerapp.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationError methodArgumentNotValid(MethodArgumentNotValidException exception) {
        ValidationError validationError = new ValidationError();
        exception.getBindingResult()
                .getFieldErrors()
                .forEach(error -> validationError.addFieldError(error.getField(), error.getDefaultMessage()));
        return validationError;
    }

    @ExceptionHandler(PlatformWithNameAlreadyExists.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiError handlePlatformAlreadyExistsException(PlatformWithNameAlreadyExists ex) {
        return new ApiError("PLATFORM_ALREADY_EXISTS", ex.getMessage(), "A platform with the same name already exists");
    }

    @ExceptionHandler(PlatformWithIdNotExists.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handlePlatformWithIdNotExistsException(PlatformWithIdNotExists ex) {
        return new ApiError("PLATFORM_WITH_ID_NOT_EXISTS", ex.getMessage(), "Platform with this id doesn't exists");
    }

    @ExceptionHandler(InvalidStatusException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleInvalidStatusException(InvalidStatusException ex) {
        return new ApiError("INVALID_STATUS", ex.getMessage(), "Status with this name doesn't exists");
    }
}
