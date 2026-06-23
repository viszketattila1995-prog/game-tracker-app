package com.attila.taskmanager.gametrackerapp.exception;

public class PlatformWithNameAlreadyExists extends RuntimeException {
    public PlatformWithNameAlreadyExists(String message) {
        super(message);
    }
}
