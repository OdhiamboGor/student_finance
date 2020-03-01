package ke.ac.egerton.student_finance.settings.receipts.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "SFRCMODE")
public class ReceiptingCriteria extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "SFRCMODE")
    @GenericGenerator(name = "SFRCMODE", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @NotBlank(message = "This field cannot be empty")
    @Column(name = "SYSMODE")
    private String sysCode;

    @NotBlank(message = "This field cannot be empty")
    @Column(name = "MODECODE")
    private String code;

    @NotBlank(message = "This field cannot be empty")
    @Column(name = "MODEDESC")
    private String name;

    @Column(name = "ISDEFAULT")
    private Boolean defaultValue;

    public ReceiptingCriteria() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
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

    public Boolean getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Boolean defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public String toString() {
        return "ReceiptingCriteria{" +
                "id=" + id +
                ", sysCode='" + sysCode + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", defaultValue=" + defaultValue +
                '}';
    }
}
