package com.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "IDUSERINSERT")
    @NotNull(message = "Position idUserInsert field cannot be null")
    private Integer idUserInsert;

    @Column(name = "INSERTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date insertDate;

    @Column(name = "ISACTIVE",columnDefinition = "TINYINT(1) DEFAULT '1'")
    private short isActive = 1;

    @Column(name = "NAME")
    @Size(max = 100)
    @NotNull(message = "Position name field cannot be null")
    private String name;

    @Column(name = "TYPE")
    @NotEmpty(message = "Position type cannot be empty")
    private int type;

}