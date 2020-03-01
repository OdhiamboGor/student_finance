package ke.ac.egerton.student_finance.settings.feeSetup.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "SFFSTRS")
public class FeeType extends AuditableEntity {

    @Id
    @GeneratedValue(generator = "SFFSTRS")
    @GenericGenerator(name = "SFFSTRS", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @Column(name = "FEETYPE")
    private String type;

    @Column(name = "SEGCODE")
    private String code;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "COMMENTS")
    private String comments;

    public FeeType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "FeeType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", code='" + code + '\'' +
                ", amount=" + amount +
                ", comments='" + comments + '\'' +
                '}';
    }
}
