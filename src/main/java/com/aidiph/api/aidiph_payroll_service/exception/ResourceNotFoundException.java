package com.aidiph.api.aidiph_payroll_service.exception;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String resourceType, Object resourceId) {
        super(String.format("%s not found with ID: %s", resourceType, resourceId));
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
