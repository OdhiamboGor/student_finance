package ke.ac.egerton.student_finance.settings.payment.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "SFPYMOD")
public class PaymentMode extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "SFPYMOD")
    @GenericGenerator(name = "SFPYMOD", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @NotBlank(message = "This field cannot be empty")
    @Column(name = "SYSCODE")
    private String sysCode;

    @NotBlank(message = "This field cannot be empty")
    @Column(name = "MODECODE")
    private String code;

    @NotBlank(message = "This field cannot be empty")
    @Column(name = "MODEDESC")
    private String name;

    @Column(name = "DEFDOCNO")
    private String reference;

    @Column(name = "DEFSEG")
    private String segment;

    @Column(name = "DEFBANK")
    private String bank;

    @Column(name = "DEFACCT")
    private String account;

    @NotBlank(message = "This field cannot be empty")
    @Column(name = "LBLDNO")
    private String label;

    @NotBlank(message = "This field cannot be empty")
    @Column(name = "LBLDDATE")
    private String labelDate;

    public PaymentMode() {
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

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabelDate() {
        return labelDate;
    }

    public void setLabelDate(String labelDate) {
        this.labelDate = labelDate;
    }

    @Override
    public String toString() {
        return "PaymentMode{" +
                "id=" + id +
                ", sysCode='" + sysCode + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", reference='" + reference + '\'' +
                ", segment='" + segment + '\'' +
                ", bank='" + bank + '\'' +
                ", account='" + account + '\'' +
                ", label='" + label + '\'' +
                ", labelDate='" + labelDate + '\'' +
                '}';
    }
}
