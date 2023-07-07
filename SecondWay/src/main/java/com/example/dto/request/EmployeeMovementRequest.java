package com.example.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
// This is just example
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeMovementRequest {
    private Date enterDate;
    private Date exitDate;
    private Date insertDate;
    private int idUserInsert;
    private int idEmployee;
    private int idWorkPeriod;

}