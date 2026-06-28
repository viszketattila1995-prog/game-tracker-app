package com.attila.taskmanager.gametrackerapp.exception;

public class PlatformWithIdNotExists extends RuntimeException {
    public PlatformWithIdNotExists(String message) {
        super(message);
    }
}
