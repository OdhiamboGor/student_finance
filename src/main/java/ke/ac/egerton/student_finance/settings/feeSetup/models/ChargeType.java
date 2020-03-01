package ke.ac.egerton.student_finance.settings.feeSetup.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "SFTCFG")
public class ChargeType extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "SFTCFG")
    @GenericGenerator(name = "SFTCFG", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @Column(name = "SETUPDESC")
    private String description;

    public ChargeType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
