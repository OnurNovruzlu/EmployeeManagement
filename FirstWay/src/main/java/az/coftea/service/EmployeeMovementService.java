package az.coftea.service;

import az.coftea.dto.request.EmployeeMovementRequest;
import az.coftea.dto.response.EmployeeMovementResponse;

import java.util.List;

public interface EmployeeMovementService {
    List<EmployeeMovementResponse> getAll();
    EmployeeMovementResponse getById(int empMovementId);
    void insert(EmployeeMovementRequest request);
    void deactivate(int empMovementId);
    void update(int empMovementId,EmployeeMovementRequest request);
}
