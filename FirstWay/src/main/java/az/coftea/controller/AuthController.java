package az.coftea.controller;

import az.coftea.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final EmployeeService employeeService;

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestParam(required = false)String username,@RequestParam String password){
        return employeeService.login(username,password);
    }
}