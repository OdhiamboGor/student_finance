package ke.ac.egerton.student_finance.settings.thirdParty.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import ke.ac.egerton.student_finance.settings.feeSetup.models.ChargeItem;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;

@Entity
@Table(name = "SFTPS")
public class ThirdParty extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "SFTPS")
    @GenericGenerator(name = "SFTPS", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "TPCATCODE", referencedColumnName = "TPCATCODE")
    private Category category;

    @Column(name = "TPCODE")
    private String code;

    @Column(name = "TPDESC")
    private String name;

    @Column(name = "TPPAYEE")
    private String payee;

    @ManyToOne
    @JoinColumn(name = "SEGCODE", referencedColumnName = "SEGCODE")
    private ChargeItem chargeItem;

    @Column(name = "ACCOUNTNO")
    private String account;

    public ThirdParty() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public ChargeItem getChargeItem() {
        return chargeItem;
    }

    public void setChargeItem(ChargeItem chargeItem) {
        this.chargeItem = chargeItem;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "ThirdParty{" +
                "id=" + id +
                ", category=" + category +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", payee='" + payee + '\'' +
                ", chargeItem=" + chargeItem +
                ", account='" + account + '\'' +
                '}';
    }
}
