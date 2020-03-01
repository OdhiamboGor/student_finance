package ke.ac.egerton.student_finance.settings.feeSetup.models;

import ke.ac.egerton.academic.admission.disciplinary.settings.AccountSets;
import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "SFFSEG")
public class ChargeItem extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "SFFSEG")
    @GenericGenerator(name = "SFFSEG", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @Column(name = "SEGCODE")
    private String code;

    @Column(name = "SEGDESC")
    private String name;

    @ManyToOne
    @JoinColumn(name = "UOMCODE", referencedColumnName = "UOMCODE")
    private UnitOfMeasure unitOfMeasure;

    @Column(name = "IST")
    private Boolean tuition;

    @Column(name = "GLACCOUNT")
    private String account;

    @Column(name = "GLSEGMAP")
    private String accountMap;

    @Column(name = "IPP")
    private Boolean payment;

    @Column(name = "AIF")
    private Boolean autoInsert;

    @Column(name = "AMOUNTDEF")
    private BigDecimal amount;

    @Column(name = "HASACCSEG")
    private Boolean hasSegment;

    @Column(name = "ISCH")
    private Boolean scholarship;

    @Column(name = "INV")
    private Boolean invoice;

    @ManyToOne
    @JoinColumn(name = "ACCSETCODE", referencedColumnName = "ACCSETCODE")
    private AccountSets accountSets;

    private Long priority;

    public ChargeItem() {
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

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Boolean getTuition() {
        return tuition;
    }

    public void setTuition(Boolean tuition) {
        this.tuition = tuition;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccountMap() {
        return accountMap;
    }

    public void setAccountMap(String accountMap) {
        this.accountMap = accountMap;
    }

    public Boolean getPayment() {
        return payment;
    }

    public void setPayment(Boolean payment) {
        this.payment = payment;
    }

    public Boolean getAutoInsert() {
        return autoInsert;
    }

    public void setAutoInsert(Boolean autoInsert) {
        this.autoInsert = autoInsert;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Boolean getHasSegment() {
        return hasSegment;
    }

    public void setHasSegment(Boolean hasSegment) {
        this.hasSegment = hasSegment;
    }

    public Boolean getScholarship() {
        return scholarship;
    }

    public void setScholarship(Boolean scholarship) {
        this.scholarship = scholarship;
    }

    public Boolean getInvoice() {
        return invoice;
    }

    public void setInvoice(Boolean invoice) {
        this.invoice = invoice;
    }

    public AccountSets getAccountSets() {
        return accountSets;
    }

    public void setAccountSets(AccountSets accountSets) {
        this.accountSets = accountSets;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "ChargeItem{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", unitOfMeasure=" + unitOfMeasure +
                ", tuition=" + tuition +
                ", account='" + account + '\'' +
                ", accountMap='" + accountMap + '\'' +
                ", payment=" + payment +
                ", autoInsert=" + autoInsert +
                ", amount=" + amount +
                ", hasSegment=" + hasSegment +
                ", scholarship=" + scholarship +
                ", invoice=" + invoice +
                ", accountSets=" + accountSets +
                ", priority=" + priority +
                '}';
    }
}
