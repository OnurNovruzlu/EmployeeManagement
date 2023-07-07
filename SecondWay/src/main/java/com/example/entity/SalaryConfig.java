package com.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "salaryconfig")
@Entity
public class SalaryConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "WHOLESALEPERCENT")
    @NotNull(message = "SalaryConfig wholeSalePercent field cannot be empty")
    private Integer wholeSalePercent;

    @Column(name = "RETAILPERCENT")
    @NotNull(message = "SalaryConfig retailPercent field cannot be empty")
    private Integer retailPercent;

    @Column(name = "MINWORKINGHOUR")
    @NotNull(message = "SalaryConfig minWorkingHour field cannot be empty")
    private Integer minWorkingHour;

    @Column(name = "NAME")
    @Size(max = 100,message = "The maximum size of SalaryConfig name field is 100")
    private String name;

    @Column(name = "ISACTIVE",columnDefinition = "TINYINT(1)")
    private short isActive = 1;
}
