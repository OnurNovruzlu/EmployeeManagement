package az.coftea.controller;

import az.coftea.dto.request.EmployeeRequest;
import az.coftea.dto.response.EmployeeResponse;
import az.coftea.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("employee")
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeResponse> getAll(){
        return employeeService.getAll();
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeResponse getById(@PathVariable("id")int employeeId){
        return employeeService.getById(employeeId);
    }

    @DeleteMapping("/deactivate/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeResponse deactivate(@PathVariable("id")int employeeId){
        return employeeService.deactivate(employeeId);
    }

    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeResponse insert(@RequestBody EmployeeRequest request){
        return employeeService.insert(request);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeResponse update(@PathVariable("id")int employeeId,@RequestBody EmployeeRequest request){
        return employeeService.update(employeeId,request);
    }

}
