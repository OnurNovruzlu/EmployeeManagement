package com.example.exception;

import jakarta.persistence.PersistenceException;

public class EmployeeNotFoundException extends PersistenceException {

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
