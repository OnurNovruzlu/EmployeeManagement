package az.coftea.service;

import az.coftea.dto.mapper.MapperService;
import az.coftea.dto.request.EmployeeMovementRequest;
import az.coftea.dto.response.EmployeeMovementResponse;
import az.coftea.entity.Employee;
import az.coftea.entity.EmployeeMovement;
import az.coftea.entity.WorkPeriod;
import az.coftea.repository.EmployeeMovementRepository;
import az.coftea.repository.EmployeeRepository;
import az.coftea.repository.WorkPeriodRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeMovementManager implements EmployeeMovementService{

    private MapperService mapperService;
    private EmployeeMovementRepository employeeMovementRepository;
    private EmployeeRepository employeeRepository;
    private WorkPeriodRepository workPeriodRepository;

    @Override
    public List<EmployeeMovementResponse> getAll() {
        List<EmployeeMovement> list = employeeMovementRepository.findAll();
        return list.stream().map(employeeMovement->mapperService.forResponse()
                        .map(employeeMovement, EmployeeMovementResponse.class)).toList();
    }

    @Override
    public EmployeeMovementResponse getById(int empMovementId) {
        EmployeeMovement employeeMovement = employeeMovementRepository.findById(empMovementId)
        .orElseThrow(()->new EntityNotFoundException("EmployeeMovement not found with this id: "+empMovementId));
        return mapperService.forResponse().map(employeeMovement, EmployeeMovementResponse.class);
    }

    @Transactional
    @Override
    public void insert(EmployeeMovementRequest request) {
        EmployeeMovement employeeMovement = mapperService.forRequest().map(request,EmployeeMovement.class);
        employeeMovementRepository.save(employeeMovement);
    }

    @Transactional
    @Override
    public void deactivate(int empMovementId) {
        EmployeeMovement employeeMovement = employeeMovementRepository.findById(empMovementId)
        .orElseThrow(()->new EntityNotFoundException("EmployeeMovement not found with this id: "+empMovementId));
        employeeMovement.setIsActive((short) 0);
        employeeMovementRepository.save(employeeMovement);
    }

    @Transactional
    @Override
    public void update(int empMovementId, EmployeeMovementRequest request) {
        EmployeeMovement employeeMovement = employeeMovementRepository.findById(empMovementId)
        .orElseThrow(()->new EntityNotFoundException("EmployeeMovement not found with this id: "+empMovementId));

        WorkPeriod workPeriod = workPeriodRepository.findById(request.getIdWorkPeriod())
                        .orElseThrow(()->new EntityNotFoundException("WorkPeriod not found"));

        Employee employee = employeeRepository.findById(request.getIdEmployee())
                        .orElseThrow(()->new EntityNotFoundException("Employee not found"));

        employeeMovement.setEnterDate(request.getEnterDate());
        employeeMovement.setExitDate(request.getExitDate());
        employeeMovement.setIdUserInsert(request.getIdUserInsert());
        employeeMovement.setIdWorkPeriod(workPeriod);
        employeeMovement.setIdEmployee(employee);

        employeeMovementRepository.save(employeeMovement);
    }
}
