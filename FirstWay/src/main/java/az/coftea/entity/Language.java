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
@Table(name = "language")
@Entity
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DESCRIPTION")
    @NotNull(message = "Language description field cannot be null")
    @Size(max = 20,message = "The maximum size of Language description field is 20")
    private String description;


    @Column(name = "IDUSERINSERT")
    @NotNull(message = "idUserInsert field cannot be null")
    private Integer idUserInsert;

    @Column(name = "INSERTDATE")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;

    @Column(name = "ISACTIVE",columnDefinition = "TINYINT(1) DEFAULT '1'")
    private short isActive = 1;

    @Column(name = "NAME")
    @NotNull(message = "Language name field cannot be null")
    @Size(max = 100)
    private String name;
}
