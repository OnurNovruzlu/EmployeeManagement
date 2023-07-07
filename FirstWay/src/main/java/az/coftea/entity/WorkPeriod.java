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
@Table(name = "workperiod")
@Entity
public class WorkPeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ENDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "WorkPeriod endDate field cannot be null")
    private Date endDate;

    @Column(name = "ENDDESCRIPTION")
    @Size(max = 10)
    private String endDescription;

    @Column(name = "INSERTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date insertDate;

    @Column(name = "ISACTIVE",columnDefinition = "TINYINT(1) DEFAULT '1'")
    private short isActive = 1;

    @Column(name = "NAME")
    @NotNull(message = "WorkPeriod name field cannot be null")
    @Size(max = 100)
    private String name;

    @Column(name = "STARTDATE")
    @NotNull(message = "WorkPeriod startDate field cannot be null")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "STARTDESCRIPTION")
    @Size(max = 50)
    private String startDescription;

    @ManyToOne
    @JoinColumn(name = "IDSECTION")
    private Section idSection;

    @Column(name = "IDUSERINSERT")
    private Integer idUserInsert;

    @Column(name = "TRANSFER_AMOUNT")
    @NotNull(message = "WorkPeriod transferAmount field cannot be null ")
    private BigDecimal transferAmount;





}
