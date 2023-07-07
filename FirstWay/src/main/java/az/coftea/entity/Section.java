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
@Table(name = "section")
@Entity
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "IDUSERINSERT")
    @NotNull(message = "Section idUserInsert field cannot be null")
    private Integer idUserInsert;

    @Column(name = "INSERTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date insertDate;

    @Column(name = "ISACTIVE",columnDefinition = "TINYINT(1)")
    private short isActive = 1;

    @Column(name = "NAME")
    @Size(max = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "IDRESTAURANT")
    private Restaurant idRestaurant;

    @Column(name = "PRINTERDESIGNTITLE")
    private String printerDesignTitle;

    @Column(name = "PRINTERDESIGNPHONE")
    private String printerDesignPhone;

    @Column(name = "PRINTERDESIGNMOBILE")
    private String printerDesignMobile;

    @Column(name = "PRINTERDESIGNTAMOBILE")
    private String printerDesignTaMobile;

    @Column(name = "PRINTERDESIGNMESSAGE")
    private String printerDesignMessage;

    @Column(name = "BACKUP",columnDefinition = "TINYINT")
    private short backup = 0;

    @Column(name = "REMOTEBACKUP",columnDefinition = "TINYINT")
    private short remoteBackup = 0;

    @Column(name = "CLR",columnDefinition = "TINYINT")
    private short clr = 0;

    @Column(name = "EXCELLEXPORT",columnDefinition = "TINYINT")
    private short excellExport = 0;

    @Column(name = "CLRINVANDWRHS",columnDefinition = "TINYINT")
    private short clrinvandwrhs = 0;

    @Column(name = "RREPORTPERC",columnDefinition = "SMALLINT")
    private Integer rReportPerc;

    @ManyToOne
    @JoinColumn(name = "IDLANGUAGE")
    private Language idLanguage;

    @Column(name = "IDPRINTSERVDEVICE")
    private Short idPrintServDevice;

    @Column(name = "IDTRIGGERPRINTSERVDEVICE")
    private Integer idTriggerPrintServDevice;

    @Column(name = "PRINTERSERVTYPE")
    private Integer printerServType;

    @Column(name = "PRINTERJOBCLR")
    private Short printerJobClr = 1;

    @Column(name = "AGENCY")
    private Short agency = 0;

    @Column(name = "AGENCYNATION")
    private Short agencyNation = 0;

    @ManyToOne
    @JoinColumn(name = "IDSALARYCONFIG")
    private SalaryConfig idSalaryConfig;

}