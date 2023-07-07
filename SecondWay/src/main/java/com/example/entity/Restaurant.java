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
@Table(name = "restaurant")
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "IDUSERINSERT")
    @NotNull(message = "Restaurant idUserInsert field cannot be null")
    private Integer idUserInsert;

    @Column(name = "INSERTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date insertDate;

    @Column(name = "ISACTIVE")
    private short isActive = 1;

    @Column(name = "NAME")
    @NotNull(message = "Restaurant name field cannot be null")
    @Size(max = 100)
    private String name;

    @Column(name = "INTEGRATION")
    private String integration;

    @Column(name = "CNAME")
    @Size(max = 45)
    private String cName;

    @Column(name = "CABOUT")
    private String cAbout;

    @Column(name = "CEMAIL")
    @Size(max = 45)
    private String cEmail;

    @Column(name = "CPHONENUMBER")
    @Size(max = 45)
    private String cPhoneNumber;

    @Column(name = "CMOBILENUMBER")
    @Size(max = 45)
    private String cMobileNumber;

    @Column(name = "CLOCATION")
    @Size(max = 45)
    private String cLocation;

    @Column(name = "CADDRESS")
    private String cAddress;

    @Lob
    @Column(name = "CLOGO")
    private byte[] cLogo;

    @Column(name = "CWEBSITE")
    @Size(max = 45)
    private String cWebsite;

    @Column(name = "STOREID")
    @Size(max = 45)
    private String storeId;

    @Column(name = "FTPUSERNAME")
    private String ftpUsername;

    @Column(name = "FTPPASSWORD")
    private String ftpPassword;

    @Column(name = "FTPHOST")
    private String ftpHost;

    @Column(name = "SHIFT")
    private int shift = 0;

    @Column(name = "MENUUPDATE")
    @NotEmpty(message = "Restaurant menuUpdate field cannot be empty")
    private int menuUpdate = 0;

    @Column(name = "PRICEUPDATE")
    @NotEmpty(message = "Restaurant priceUpdate field cannot be empty")
    private int priceUpdate = 0;

    @Column(name = "UPDATESTATUS")
    @NotEmpty(message = "Restaurant updateStatus field cannot be empty")
    private int updateStatus = 0;

    @Column(name = "BONUSUSERNAME")
    @Size(max = 150)
    private String bonusUsername;

    @Column(name = "BONUSTOKEN")
    private String bonusToken;

    @Column(name = "BONUSSECTIONID")
    private String bonusSectionId;

    @Column(name = "BONUSURL")
    @Size(max = 500)
    private String bonusUrl;

}