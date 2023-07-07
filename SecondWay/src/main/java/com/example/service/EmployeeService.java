package com.example.service;

import com.example.dto.request.EmployeeRequest;
import com.example.dto.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponse> getAll();
    EmployeeResponse getById(int employeeId);
    EmployeeResponse insert(EmployeeRequest request);
    EmployeeResponse deactivate(int employeeId);
    EmployeeResponse update(int employeeId,EmployeeRequest request);
    String login(String username,String password);
}
