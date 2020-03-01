package ke.ac.egerton.student_finance.settings.accountsSetup.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "SFACCOUNTS")
public class GlAccount extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "SFACCOUNTS")
    @GenericGenerator(name = "SFACCOUNTS", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @Column(name = "ACCOUNTNO")
    private String number;

    @Column(name = "ACCOUNTDESC")
    private String name;

    @Column(name = "ACTIVE")
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "STRCODE", referencedColumnName = "STRCODE")
    private AccountStructure accountStructure;

    @Column(name = "ACCTYPE")
    private String accountType;

    @ManyToOne
    @JoinColumn(name = "ACCGRPCODE", referencedColumnName = "ACCGRPCODE")
    private AccountGroup accountGroup;

    public GlAccount() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public AccountStructure getAccountStructure() {
        return accountStructure;
    }

    public void setAccountStructure(AccountStructure accountStructure) {
        this.accountStructure = accountStructure;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public AccountGroup getAccountGroup() {
        return accountGroup;
    }

    public void setAccountGroup(AccountGroup accountGroup) {
        this.accountGroup = accountGroup;
    }

    @Override
    public String toString() {
        return "GlAccount{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", accountStructure=" + accountStructure +
                ", accountType='" + accountType + '\'' +
                ", accountGroup=" + accountGroup +
                '}';
    }
}
