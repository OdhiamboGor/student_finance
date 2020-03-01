package ke.ac.egerton.student_finance.settings.thirdParty.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import ke.ac.egerton.models.academic.AcademicYear;
import ke.ac.egerton.models.academic.Session;
import ke.ac.egerton.models.academic.StudentCategory;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "SFTPLIMITS")
public class Limit extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "SFTPLIMITS")
    @GenericGenerator(name = "SFTPLIMITS", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CATEGORYCODE", referencedColumnName = "CATEGORYCODE")
    private StudentCategory studentCategory;

    @ManyToOne
    @JoinColumn(name = "TPCODE", referencedColumnName = "TPCODE")
    private ThirdParty thirdParty;

    @ManyToOne
    @JoinColumn(name = "ACADEMICYEAR", referencedColumnName = "ACADEMICYEAR")
    private AcademicYear academicYear;

    @ManyToOne
    @JoinColumn(name = "SEMSESSIONCODE", referencedColumnName = "SEMSESSIONCODE")
    private Session session;

    @Column(name = "MAXAMOUNT")
    private BigDecimal amount;

    public Limit() {
    }

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

    public ThirdParty getThirdParty() {
        return thirdParty;
    }

    public void setThirdParty(ThirdParty thirdParty) {
        this.thirdParty = thirdParty;
    }

    public AcademicYear getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(AcademicYear academicYear) {
        this.academicYear = academicYear;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Limit{" +
                "id=" + id +
                ", studentCategory=" + studentCategory +
                ", thirdParty=" + thirdParty +
                ", academicYear=" + academicYear +
                ", session=" + session +
                ", amount=" + amount +
                '}';
    }
}
