package ke.ac.egerton.student_finance.settings.coreSetup.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "SFINSTCNT")
public class Installment extends AuditableEntity {

    @Id
    @GeneratedValue(generator = "SFINSTCNT")
    @GenericGenerator(name = "SFINSTCNT", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @NotNull(message = "This field cannot be null")
    @Column(name = "MININST")
    private Integer minimum;

    @NotNull(message = "This field cannot be null")
    @Column(name = "MAXINST")
    private Integer maximum;

    public Installment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMinimum() {
        return minimum;
    }

    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }

    @Override
    public String toString() {
        return "Installment{" +
                "id=" + id +
                ", minimum=" + minimum +
                ", maximum=" + maximum +
                '}';
    }
}
