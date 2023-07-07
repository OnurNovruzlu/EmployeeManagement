package com.example.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
// This is just example
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
    private int id;
    private String address;
    private String city;
    private Date exitDate;
    private String email;
    private Date enterDate;
    private String idCardNumber;
    private int idUserInsert;
    private Date insertDate;
    private short isActive;
    private String mobileNumber;
    private String name;
    private String password;
    private String phoneNumber;
    private String surname;
    private String username;
    private Integer idSection;
    private Integer idLanguage;
    private int idPosition;
    private BigDecimal salary;
    private boolean passwordSet;
    private boolean rReport;
    private Integer idIntG;
    private String codeIntG;
    private Integer idSalaryBonus;
}
