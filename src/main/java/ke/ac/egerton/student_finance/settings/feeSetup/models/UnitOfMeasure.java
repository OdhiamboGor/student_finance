package ke.ac.egerton.student_finance.settings.feeSetup.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "SFUOM")
public class UnitOfMeasure extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "SFUOM")
    @GenericGenerator(name = "SFUOM", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @NotBlank(message = "This field cannot be empty")
    @Column(name = "UOMCODE")
    private String code;

    @Column(name = "UOMDESC")
    private String name;

    @Column(name = "UOMS")
    private String comments;

    @Column(name = "RECURR")
    private String recurrence;

    @Column(name = "ATU")
    private Boolean attachUnits;

    public UnitOfMeasure() {
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(String recurrence) {
        this.recurrence = recurrence;
    }

    public Boolean getAttachUnits() {
        return attachUnits;
    }

    public void setAttachUnits(Boolean attachUnits) {
        this.attachUnits = attachUnits;
    }
}
