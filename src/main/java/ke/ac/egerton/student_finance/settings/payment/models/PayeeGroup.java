package ke.ac.egerton.student_finance.settings.payment.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "ACPAYEES")
public class PayeeGroup extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "ACPAYEES")
    @GenericGenerator(name = "ACPAYEES", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @NotBlank(message = "This field cannot be empty")
    @Column(name = "GRPCODE")
    private String code;

    @NotBlank(message = "This field cannot be empty")
    @Column(name = "GRPNAME")
    private String name;

    @Column(name = "ISSTUDENT")
    private Boolean student;

    @Column(name = "ISALUMNI")
    private Boolean alumni;

    @Column(name = "ACCSTS")
    private Boolean accountSets;

    public PayeeGroup() {
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

    public Boolean getStudent() {
        return student;
    }

    public void setStudent(Boolean student) {
        this.student = student;
    }

    public Boolean getAlumni() {
        return alumni;
    }

    public void setAlumni(Boolean alumni) {
        this.alumni = alumni;
    }

    public Boolean getAccountSets() {
        return accountSets;
    }

    public void setAccountSets(Boolean accountSets) {
        this.accountSets = accountSets;
    }

    @Override
    public String toString() {
        return "PayeeGroup{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", student=" + student +
                ", alumni=" + alumni +
                ", accountSets=" + accountSets +
                '}';
    }
}
