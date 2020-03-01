package ke.ac.egerton.student_finance.settings.thirdParty.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "SFTPCATS")
public class Category extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "SFTPCATS", strategy = GenerationType.AUTO)
    @GenericGenerator(name = "SFTPCATS", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    public Long id;

    @NotBlank(message = "This field cannot be empty")
    @Column(name = "TPCATCODE")
    public String code;

    @NotBlank(message = "This field cannot be empty")
    @Column(name = "TPCATDESC")
    public String name;

    public Category() {
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
        return "Category{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
