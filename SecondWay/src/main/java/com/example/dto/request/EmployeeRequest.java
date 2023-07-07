package com.example.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
// This is just example
@Data
@AllArgsConstructor
public class EmployeeRequest {
    private String address;
    private String city;
    private Date exitDate;
    private String email;
    private Date enterDate;
    private String idCardNumber;
    private int idUserInsert;
    private String mobileNumber;
    private String name;
    private String password;
    private String phoneNumber;
    private String surname;
    private String username;
    private int idSection;
    private int idLanguage;
    private int idPosition;
    private BigDecimal salary;
    private Integer idIntG;
    private String codeIntG;
    private int idSalaryBonus;

    public EmployeeRequest(){
        this.salary = BigDecimal.valueOf(0.00);
    }
}
