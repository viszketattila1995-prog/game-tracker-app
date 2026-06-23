package com.attila.taskmanager.gametrackerapp.exception;

public record ApiError(String errorCode, String error, String details) {
}
