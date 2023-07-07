package az.coftea.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ADDRESS")
    @Size(max = 100)
    private String address;

    @Column(name = "CITY")
    @Size(max = 50)
    private String city;

    @Column(name = "EIXTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date exitDate;

    @Column(name = "EMAIL")
    @Size(max = 50)
    private String email;

    @Column(name = "ENTERDATE")
    @NotNull(message = "Employee enterDate field cannot be null")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enterDate;

    @Column(name = "IDCARDNUMBER")
    @Size(max = 20)
    private String idCardNumber;

    @Column(name = "IDUSERINSERT")
    @NotNull(message = "Employee idUserInsert field cannot be null")
    private Integer idUserInsert;

    @Column(name = "INSERTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date insertDate;

    @Column(name = "ISACTIVE",columnDefinition = "TINYINT DEFAULT '1'")
    private Short isActive = 1;

    @Column(name = "MOBILENUMBER")
    @Size(max = 20)
    private String mobileNumber;

    @Column(name = "NAME")
    @Size(max = 100)
    @NotNull(message = "Employee name field cannot be null")
    private String name;

    @Column(name = "PASSWORD")
    @Size(max = 50)
    private String password;

    @Column(name = "PHONENUMBER")
    @Size(max = 20)
    private String phoneNumber;

    @Column(name = "SURNAME")
    @Size(max = 100)
    private String surname;

    @Column(name = "USERNAME")
    @Size(max = 100)
    private String username;

    @ManyToOne
    @JoinColumn(name = "IDSECTION")
    private Section idSection;

    @ManyToOne
    @JoinColumn(name = "IDLANGUAGE")
    private Language idLanguage;

    @ManyToOne
    @JoinColumn(name = "IDPOSITION")
    @NotNull(message = "Employee idPosition field cannot be null")
    private Position idPosition;

    @Column(name = "SALARY",columnDefinition = "decimal(16,2) DEFAULT '0.00'")
    private BigDecimal salary;

    @Column(name = "PASSWORDSET",columnDefinition = "tinyint DEFAULT '1'")
    private short passwordSet = 1;

    @Column(name = "RREPORT",columnDefinition = "tinyint DEFAULT '0'")
    private short rReport = 0;

    @Column(name = "IDINTG")
    private Integer idIntG;

    @Column(name = "CODEINTG")
    @Size(max = 200)
    private String codeIntG;

    @ManyToOne
    @JoinColumn(name = "IDSALARYBONUS")
    private SalaryBonusPercent idSalaryBonus;

    @PrePersist
    public void prePersist(){
        if (password == null) passwordSet = 0;
    }

}