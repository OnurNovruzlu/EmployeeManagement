package az.coftea.entity;

import jakarta.persistence.*;
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
@Table(name = "salarybonuspercent")
public class SalaryBonusPercent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    @Size(max = 45,message = "The maximum size of salary bonus name is 45")
    @NotNull(message = "SalaryBonus name field cannot be null")
    private String name;

    @Column(name = "COEFFICIENT")
    @NotNull(message = "SalaryBonus coefficient field cannot be null")
    private String coefficient;

    @Column(name = "INSERTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date insertDate;

    @Column(name = "ISACTIVE",columnDefinition = "TINYINT(1)")
    private short isActive = 1;

}
