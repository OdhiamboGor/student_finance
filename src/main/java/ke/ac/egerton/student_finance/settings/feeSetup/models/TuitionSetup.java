package ke.ac.egerton.student_finance.settings.feeSetup.models;

import ke.ac.egerton.academic.units.UnitType;
import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import ke.ac.egerton.models.academic.StudentCategory;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "SFTFCF")
public class TuitionSetup extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "SFTFCF")
    @GenericGenerator(name = "SFTFCF", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CATEGORYCODE", referencedColumnName = "CATEGORYCODE")
    private StudentCategory studentCategory;

    @ManyToOne
    @JoinColumn(name = "UTYPECODE", referencedColumnName = "UTYPECODE")
    private UnitType unitType;

    @Column(name = "REGSTSCODE")
    private String registrationCode;

    @Column(name = "SEGCODE")
    private String segmentCode;

    @Column(name = "FCTCODE")
    private String feeCode;

    @Column(name = "AMOUNTDEF")
    private BigDecimal amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudentCategory getStudentCategory() {
        return studentCategory;
    }

    public void setStudentCategory(StudentCategory studentCategory) {
        this.studentCategory = studentCategory;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

    public String getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }

    public String getSegmentCode() {
        return segmentCode;
    }

    public void setSegmentCode(String segmentCode) {
        this.segmentCode = segmentCode;
    }

    public String getFeeCode() {
        return feeCode;
    }

    public void setFeeCode(String feeCode) {
        this.feeCode = feeCode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
