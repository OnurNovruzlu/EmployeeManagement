package com.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employeemovement")
@Entity
public class EmployeeMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ETERDATE")
    @NotNull(message = "EmployeeMovement enterDate field cannot be null")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enterDate;

    @Column(name = "EXITDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date exitDate;

    @Column(name = "IDUSERINSERT")
    @NotNull(message = "EmployeeMovement idUserInsert field cannot be null")
    private Integer idUserInsert;

    @Column(name = "INSERTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date insertDate;

    @Column(name = "ISACTIVE",columnDefinition = "TINYINT(1) default '1'")
    private Short isActive = 1;

    @ManyToOne
    @JoinColumn(name = "IDEMPLOYEE",referencedColumnName = "ID")
    @NotNull(message = "EmployeeMovement idEmployee field cannot be null")
    private Employee idEmployee;

    @ManyToOne
    @JoinColumn(name = "IDWORKPERIOD",referencedColumnName = "ID")
    @NotNull(message = "EmployeeMovement idWorkPeriod field cannot be null")
    private WorkPeriod idWorkPeriod;

}
