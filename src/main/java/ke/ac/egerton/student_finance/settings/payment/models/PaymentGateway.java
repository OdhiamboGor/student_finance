package ke.ac.egerton.student_finance.settings.payment.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import ke.ac.egerton.student_finance.settings.currency.model.Currency;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "SFGATEWAYS")
public class PaymentGateway extends AuditableEntity {

    @Id
    @GeneratedValue(generator = "SFGATEWAYS")
    @GenericGenerator(name = "SFGATEWAYS", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @Column(name = "GTWCODE")
    private String code;

    @Column(name = "GTWNAME")
    private String name;

    @Column(name = "INSTRCTNS")
    private String instructions;

    @ManyToOne
    @JoinColumn(name = "MODECODE", referencedColumnName = "MODECODE")
    private PaymentMode paymentMode;

    @Column(name = "IPNOPT1")
    private String option1;

    @Column(name = "IPNOPT2")
    private String option2;

    @Column(name = "IPNOPT3")
    private String option3;

    @Column(name = "IPNOPT4")
    private String option4;

    @Column(name = "IPNOPT5")
    private String option5;

    @ManyToOne
    @JoinColumn(name = "CURRENCY", referencedColumnName = "CURRENCYCODE")
    private Currency currency;

    @Column(name = "ISMP")
    private Boolean mpesa;

    @Column(name = "ISPB")
    private Boolean payBill;

    @Column(name = "ISPP")
    private Boolean payPal;

    @Column(name = "ISBK")
    private Boolean bank;

    @Column(name = "TESTMODE")
    private Boolean test;

    public PaymentGateway() {
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

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getOption5() {
        return option5;
    }

    public void setOption5(String option5) {
        this.option5 = option5;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Boolean getMpesa() {
        return mpesa;
    }

    public void setMpesa(Boolean mpesa) {
        this.mpesa = mpesa;
    }

    public Boolean getPayBill() {
        return payBill;
    }

    public void setPayBill(Boolean payBill) {
        this.payBill = payBill;
    }

    public Boolean getPayPal() {
        return payPal;
    }

    public void setPayPal(Boolean payPal) {
        this.payPal = payPal;
    }

    public Boolean getBank() {
        return bank;
    }

    public void setBank(Boolean bank) {
        this.bank = bank;
    }

    public Boolean getTest() {
        return test;
    }

    public void setTest(Boolean test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "PaymentGateway{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", instructions='" + instructions + '\'' +
                ", paymentMode=" + paymentMode +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                ", option5='" + option5 + '\'' +
                ", currency='" + currency + '\'' +
                ", mpesa=" + mpesa +
                ", payBill=" + payBill +
                ", payPal=" + payPal +
                ", bank=" + bank +
                ", test=" + test +
                '}';
    }
}
