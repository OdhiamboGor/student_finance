package ke.ac.egerton.student_finance.settings.coreSetup.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import ke.ac.egerton.models.academic.StudentCategory;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "SFTRMS")
public class FeePaymentPlan extends AuditableEntity {

    @Id
    @GeneratedValue(generator = "SFTRMS")
    @GenericGenerator(name = "SFTRMS", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    public Long id;

    @Column(name = "TRMCODE")
    public String code;

    @Column(name = "TRMDESC")
    public String name;

    @Column(name = "ISDEFAULT")
    public Boolean defaultPlan;

    @Column(name = "ALLOWEDMIN")
    public BigDecimal minimum;

    @OneToOne
    @JoinColumn(name = "CATEGORYCODE", referencedColumnName = "CATEGORYCODE")
    public StudentCategory category;


    public FeePaymentPlan() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDefaultPlan() {
        return defaultPlan;
    }

    public void setDefaultPlan(Boolean defaultPlan) {
        this.defaultPlan = defaultPlan;
    }

    public BigDecimal getMinimum() {
        return minimum;
    }

    public void setMinimum(BigDecimal minimum) {
        this.minimum = minimum;
    }

    public StudentCategory getCategory() {
        return category;
    }

    public void setCategory(StudentCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "FeePaymentPlan{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", defaultPlan=" + defaultPlan +
                ", minimum=" + minimum +
                ", category=" + category +
                '}';
    }
}
