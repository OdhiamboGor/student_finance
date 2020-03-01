package ke.ac.egerton.student_finance.settings.accountsSetup.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "SFACCST")
public class AccountSet extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "SFACCST")
    @GenericGenerator(name = "SFACCST", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @Column(name = "ACCSETCODE")
    private String code;

    @Column(name = "ACCSETDESC")
    private String name;

    @Column(name = "DRACCT")
    private String account;

    @Column(name = "SYSTYPE")
    private String systemType;

    @ManyToOne
    @JoinColumn(name = "STRCODE", referencedColumnName = "STRCODE")
    private AccountStructure accountStructure;

    @Column(name = "HASACCSEG")
    private Boolean accountSegment;

    @Column(name = "ISDEFAULT")
    private Boolean defaultAccount;

    public AccountSet() {
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    public AccountStructure getAccountStructure() {
        return accountStructure;
    }

    public void setAccountStructure(AccountStructure accountStructure) {
        this.accountStructure = accountStructure;
    }

    public Boolean getAccountSegment() {
        return accountSegment;
    }

    public void setAccountSegment(Boolean accountSegment) {
        this.accountSegment = accountSegment;
    }

    public Boolean getDefaultAccount() {
        return defaultAccount;
    }

    public void setDefaultAccount(Boolean defaultAccount) {
        this.defaultAccount = defaultAccount;
    }

    @Override
    public String toString() {
        return "AccountSet{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", systemType='" + systemType + '\'' +
                ", accountStructure=" + accountStructure +
                ", accountSegment=" + accountSegment +
                ", defaultAccount=" + defaultAccount +
                '}';
    }
}
