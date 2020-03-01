package ke.ac.egerton.student_finance.settings.bankSetup.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import ke.ac.egerton.student_finance.settings.accountsSetup.models.AccountSet;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "SFAPIBANKS")
public class BankApi extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "SFAPIBANKS")
    @GenericGenerator(name = "SFAPIBANKS", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @Column(name = "BANKCODE")
    private String code;

    @Column(name = "BANKNAME")
    private String name;

    @Column(name = "APIKEY")
    private String key;

    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    @ManyToOne
    @JoinColumn(name = "ACCSETCODE", referencedColumnName = "ACCSETCODE")
    private AccountSet accountSet;

    public BankApi() {
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountSet getAccountSet() {
        return accountSet;
    }

    public void setAccountSet(AccountSet accountSet) {
        this.accountSet = accountSet;
    }

    @Override
    public String toString() {
        return "BankApi{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", accountSet=" + accountSet +
                '}';
    }
}