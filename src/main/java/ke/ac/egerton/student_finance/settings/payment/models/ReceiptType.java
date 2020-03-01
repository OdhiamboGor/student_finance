package ke.ac.egerton.student_finance.settings.payment.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import ke.ac.egerton.student_finance.settings.accountsSetup.models.AccountSet;
import ke.ac.egerton.student_finance.settings.feeSetup.models.ChargeItem;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "ACRECTYPES")
public class ReceiptType extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "ACRECTYPES")
    @GenericGenerator(name = "ACRECTYPES", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @Column(name = "RECCODE")
    private String code;

    @Column(name = "RECDESC")
    private String name;

    @ManyToOne
    @JoinColumn(name = "GRPCODE", referencedColumnName = "GRPCODE")
    private PayeeGroup payeeGroup;

    @ManyToOne
    @JoinColumn(name = "SEGCODE", referencedColumnName = "SEGCODE")
    private ChargeItem chargeItem;

    @ManyToOne
    @JoinColumn(name = "ACCSETCODE", referencedColumnName = "ACCSETCODE")
    private AccountSet accountSet;

    public ReceiptType() {
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

    public PayeeGroup getPayeeGroup() {
        return payeeGroup;
    }

    public void setPayeeGroup(PayeeGroup payeeGroup) {
        this.payeeGroup = payeeGroup;
    }

    public ChargeItem getChargeItem() {
        return chargeItem;
    }

    public void setChargeItem(ChargeItem chargeItem) {
        this.chargeItem = chargeItem;
    }

    public AccountSet getAccountSet() {
        return accountSet;
    }

    public void setAccountSet(AccountSet accountSet) {
        this.accountSet = accountSet;
    }

    @Override
    public String toString() {
        return "ReceiptType{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", payeeGroup=" + payeeGroup +
                ", chargeItem=" + chargeItem +
                ", accountSet=" + accountSet +
                '}';
    }
}
