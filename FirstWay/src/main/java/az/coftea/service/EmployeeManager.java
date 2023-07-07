package az.coftea.service;

import az.coftea.dto.request.EmployeeRequest;
import az.coftea.dto.response.EmployeeResponse;
import az.coftea.dto.mapper.MapperService;
import az.coftea.entity.*;
import az.coftea.exception.InvalidInputException;
import az.coftea.repository.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService{

    private EmployeeRepository employeeRepository;
    private LanguageRepository languageRepository;
    private SalaryBonusPercentRepository salaryBonusPercentRepository;
    private SectionRepository sectionRepository;
    private MapperService mapperService;
    private PositionRepository positionRepository;


    @Override
    public List<EmployeeResponse> getAll() {
        List<Employee> employees =  employeeRepository.findAll();
        return employees.stream().map(employee->mapperService.forResponse()
                        .map(employee, EmployeeResponse.class)).toList();
    }

    @Override
    public EmployeeResponse getById(int employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()->new EntityNotFoundException("Employee not found with this id: "+employeeId));
        return mapperService.forResponse().map(employee,EmployeeResponse.class);
    }

    @Transactional
    @Override
    public EmployeeResponse insert(EmployeeRequest request) {
        Employee employee = mapperService.forRequest().map(request,Employee.class);

        if(!String.valueOf(request.getIdLanguage()).isEmpty() && request.getIdLanguage()>0) {
            Language language = languageRepository.findById(request.getIdLanguage()).orElseThrow(()->new EntityNotFoundException("Language not found"));
            employee.setIdLanguage(language);
        }else employee.setIdLanguage(null);

        if(!String.valueOf(request.getIdSalaryBonus()).isEmpty() && request.getIdSalaryBonus()>0){
            SalaryBonusPercent percent = salaryBonusPercentRepository.findById(request.getIdSalaryBonus()).orElseThrow(()->new EntityNotFoundException("SalaryBonus not found"));
            employee.setIdSalaryBonus(percent);
        }else employee.setIdSalaryBonus(null);

        if(!String.valueOf(request.getIdSection()).isEmpty() && request.getIdSection()>0) {
            Section section = sectionRepository.findById(request.getIdSection()).orElseThrow(() -> new EntityNotFoundException("Section not found"));
            employee.setIdSection(section);
        }employee.setIdSection(null);

        employeeRepository.save(employee);

        return mapperService.forResponse().map(employee, EmployeeResponse.class);

    }

    @Transactional
    @Override
    public EmployeeResponse deactivate(int employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()->new EntityNotFoundException("Employee not found with this id: "+employeeId));
        employee.setIsActive((short) 0);
        employeeRepository.save(employee);
        return mapperService.forResponse().map(employee, EmployeeResponse.class);
    }
    @Transactional
    @Override
    public EmployeeResponse update(int employeeId, EmployeeRequest request) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()->new EntityNotFoundException("Employee ot found"));

        if(!String.valueOf(request.getIdSection()).isEmpty() && request.getIdSection()>0){
            Section section = sectionRepository.findById(request.getIdSection()).orElseThrow(()->new EntityNotFoundException("Section not found"));
            employee.setIdSection(section);
        }else employee.setIdSection(null);

        if(!String.valueOf(request.getIdLanguage()).isEmpty() && request.getIdLanguage()>0){
            Language language = languageRepository.findById(request.getIdLanguage()).orElseThrow(()->new EntityNotFoundException("Language not found"));
            employee.setIdLanguage(language);
        }else employee.setIdLanguage(null);

        if(!String.valueOf(request.getIdSalaryBonus()).isEmpty() && request.getIdSalaryBonus()>0){
            SalaryBonusPercent percent = salaryBonusPercentRepository.findById(request.getIdSalaryBonus()).orElseThrow(()->new EntityNotFoundException("SalaryBonus not found"));
            employee.setIdSalaryBonus(percent);
        }else employee.setIdSalaryBonus(null);

        Position position = positionRepository.findById(request.getIdPosition()).orElseThrow(()->new EntityNotFoundException("Position not found"));
        employee.setIdPosition(position);

        employee.setAddress(request.getAddress());
        employee.setCity(request.getCity());
        employee.setCodeIntG(request.getCodeIntG());
        employee.setEnterDate(request.getEnterDate());
        employee.setExitDate(request.getExitDate());
        employee.setIdCardNumber(request.getIdCardNumber());
        employee.setIdIntG(request.getIdIntG());
        employee.setIdUserInsert(request.getIdUserInsert());
        employee.setMobileNumber(request.getMobileNumber());
        employee.setSalary(request.getSalary());
        employee.setPhoneNumber(request.getPhoneNumber());
        employee.setName(request.getName());
        employee.setUsername(request.getUsername());
        employee.setSurname(request.getSurname());
        employee.setEmail(request.getEmail());
        employee.setPassword(request.getPassword());

        employeeRepository.save(employee);
        return mapperService.forResponse().map(employee, EmployeeResponse.class);
    }

    @Override
    public String login(String username, String password) {
        Optional<Employee> employee = employeeRepository.login(username,password);
        if(employee.isPresent())return "Welcome " + employee.get().getName();
        else throw new InvalidInputException("Invalid username or password");
    }

}
