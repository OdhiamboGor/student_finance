package ke.ac.egerton.student_finance.settings.bankSetup.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import ke.ac.egerton.student_finance.settings.currency.model.Currency;
import ke.ac.egerton.student_finance.settings.payment.models.PaymentGateway;
import ke.ac.egerton.student_finance.settings.payment.models.ReceiptType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "SFBANKS")
public class Bank  extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "SFBANKS")
    @GenericGenerator(name = "SFBANKS", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @Column(name = "BANKCODE")
    private String code;

    @Column(name = "BANKNAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "GATEWAY", referencedColumnName = "GTWCODE")
    private PaymentGateway gateway;

    @Column(name = "BKACCT")
    private String bankAccount;

    @Column(name = "GLACCOUNT")
    private String glAccount;

    @ManyToOne
    @JoinColumn(name = "CURRENCYCODE", referencedColumnName = "CURRENCYCODE")
    private Currency currency;

    @ManyToOne
    @JoinColumn(name = "RECCODE", referencedColumnName = "RECCODE")
    private ReceiptType receiptType;

    public Bank() {
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

    public PaymentGateway getGateway() {
        return gateway;
    }

    public void setGateway(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getGlAccount() {
        return glAccount;
    }

    public void setGlAccount(String glAccount) {
        this.glAccount = glAccount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public ReceiptType getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(ReceiptType receiptType) {
        this.receiptType = receiptType;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", gateway=" + gateway +
                ", bankAccount='" + bankAccount + '\'' +
                ", glAccount='" + glAccount + '\'' +
                ", currency=" + currency +
                ", receiptType=" + receiptType +
                '}';
    }

}
