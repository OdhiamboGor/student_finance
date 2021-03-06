package ke.ac.egerton.student_finance.settings.payment.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "SFPMTTYPES")
public class MiscReceiptType extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "SFPMTTYPES")
    @GenericGenerator(name = "SFPMTTYPES", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @NotBlank(message = "This field cannot be empty")
    @Column(name = "PMTTYPECODE")
    private String code;

    @NotBlank(message = "This field cannot be empty")
    @Column(name = "PMTTYPEDESC")
    private String name;

    @NotBlank(message = "This field cannot be empty")
    @Column(name = "PMODE")
    private String mode;

    public MiscReceiptType() {
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

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "MiscReceiptTypes{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", mode='" + mode + '\'' +
                '}';
    }
}
