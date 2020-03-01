package ke.ac.egerton.student_finance.settings.accountsSetup.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "SFACCTGRPS")
public class AccountGroup extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "SFACCTGRPS")
    @GenericGenerator(name = "SFACCTGRPS", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @NotBlank(message = "This field cannot be empty")
    @Column(name = "ACCGRPCODE")
    private String code;

    @NotBlank(message = "This field cannot be empty")
    @Column(name = "ACCGRPDESC")
    private String name;

    public AccountGroup() {
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

    @Override
    public String toString() {
        return "AccountGroup{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
