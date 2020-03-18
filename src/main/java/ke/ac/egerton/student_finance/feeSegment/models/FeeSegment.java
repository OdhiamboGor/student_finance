package ke.ac.egerton.student_finance.feeSegment.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "SFFSEG")
public class FeeSegment extends AuditableEntity {

    @Id
    @GeneratedValue(generator = "SFFSEG")
    @GenericGenerator(name = "SFFSEG", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @Column(name = "SEGCODE")
    private String code;

    @Column(name = "SEGDESC")
    private String description;

    public FeeSegment() {
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }


    @Override
    public String toString() {
        return "FeeSegment{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
