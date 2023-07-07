package com.example.service;

import com.example.dto.request.EmployeeMovementRequest;
import com.example.dto.response.EmployeeMovementResponse;

import java.util.List;

public interface EmployeeMovementService {
    List<EmployeeMovementResponse> getAll();
    EmployeeMovementResponse getById(int empMovementId);
    void insert(EmployeeMovementRequest request);
    void delete(int empMovementId);
    void update(int empMovementId,EmployeeMovementRequest request);
}
