package az.coftea.service;

import az.coftea.dto.request.EmployeeRequest;
import az.coftea.dto.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponse> getAll();
    EmployeeResponse getById(int employeeId);
    EmployeeResponse insert(EmployeeRequest request);
    EmployeeResponse deactivate(int employeeId);
    EmployeeResponse update(int employeeId,EmployeeRequest request);
    String login(String username,String password);
}
