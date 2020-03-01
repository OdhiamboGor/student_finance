package ke.ac.egerton.student_finance.receipting.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "SFRCHEADER")
public class CancelReceipt extends AuditableEntity {

    @Id
    @GeneratedValue(generator = "SFRCHEADER")
    @GenericGenerator(name = "SFRCHEADER", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @Column(name = "BATCHID")
    private Long batchId;

    @Column(name = "RCNO")
    private String receiptNumber;

    @Column(name = "IDCUST")
    private String customerId;

    @Column(name = "STUDENTNUMBER")
    private String studentNumber;

    @Column(name = "RECFROM")
    private String fullName;

    @Column(name = "RECTYPE")
    private String receiptType;

    @Column(name = "RCDATEF")
    private Date receiptDate;

    @Column(name = "RCDATEUF")
    private Long rcDateUF;

    @Column(name = "RCAMOUNT")
    private BigDecimal amount;

    @Column(name = "CANCELLED")
    private int cancelled;

    @Column(name = "CANCELBY")
    private String userId;

    @Column(name = "CANCELDATE")
    private Date cancelledDate;

    @Column(name = "REASON")
    private String reason;

    @Column(name = "RCSTATUS")
    private String status;

    @Column(name = "POSTED")
    private int posted;

    public CancelReceipt() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(String receiptType) {
        this.receiptType = receiptType;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Number getRcDateUF() {
        return rcDateUF;
    }

    public void setRcDateUF(Long rcDateUF) {
        this.rcDateUF = rcDateUF;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getCancelled() {
        return cancelled;
    }

    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCancelledDate() {
        return cancelledDate;
    }

    public void setCancelledDate(Date cancelledDate) {
        this.cancelledDate = cancelledDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPosted() {
        return posted;
    }

    public void setPosted(int posted) {
        this.posted = posted;
    }

    @Override
    public String toString() {
        return "CancelReceipt{" +
                "id=" + id +
                ", batchId='" + batchId + '\'' +
                ", receiptNumber='" + receiptNumber + '\'' +
                ", customerId='" + customerId + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", fullName='" + fullName + '\'' +
                ", receiptType='" + receiptType + '\'' +
                ", receiptDate=" + receiptDate +
                ", rcDateUF=" + rcDateUF +
                ", amount=" + amount +
                ", cancelled=" + cancelled +
                ", userId='" + userId + '\'' +
                ", cancelledDate=" + cancelledDate +
                ", reason='" + reason + '\'' +
                ", status='" + status + '\'' +
                ", posted=" + posted +
                '}';
    }
}
