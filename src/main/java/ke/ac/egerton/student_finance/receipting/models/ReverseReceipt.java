package ke.ac.egerton.student_finance.receipting.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "SFRVSLOG")
public class ReverseReceipt extends AuditableEntity {

    @Id
    @GeneratedValue(generator = "SFRVSLOG")
    @GenericGenerator(name = "SFRVSLOG", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    public Long id;

    @Column(name = "RCNO")
    public String receiptNumber;

    @Column(name = "RVSRSNCODE")
    public String reverseReason;

    public ReverseReceipt() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getReverseReason() {
        return reverseReason;
    }

    public void setReverseReason(String reverseReason) {
        this.reverseReason = reverseReason;
    }

    @Override
    public String toString() {
        return "ReverseReceipt{" +
                "id=" + id +
                ", receiptNumber='" + receiptNumber + '\'' +
                ", reverseReason='" + reverseReason + '\'' +
                '}';
    }
}
