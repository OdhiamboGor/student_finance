package ke.ac.egerton.student_finance.quickDocuments.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import ke.ac.egerton.models.Staff;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="SFINVBT")
public class Batches extends AuditableEntity {

    @Id
    @GeneratedValue(generator = "SFINVBT")
    @GenericGenerator(name = "SFINVBT", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @Column(name = "BATCHNO")
    private Long batchNo;

    @Column(name = "BATCHDESC")
    private String batchDescription;

    @Column(name = "BATCHDATE")
    @Temporal (TemporalType.DATE)
    @DateTimeFormat (pattern = "yyyy-MM-dd")
    private Date batchDate;

    @Column(name = "AMOUNT" )
    private BigDecimal amount;

    @Column(name = "STATUS")
    private Long status;

    @Column(name = "ENTRYNO")
    private Long entryNo;

    @Column(name = "POSTED")
    private Boolean posted;

    @Column(name = "POSTEDON")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
    private Date postDate;

    @Column(name = "ACCSETCODE")
    private String code;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    private Staff staff;

    public Batches() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(Long batchNo) {
        this.batchNo = batchNo;
    }

    public String getBatchDescription() {
        return batchDescription;
    }

    public void setBatchDescription(String batchDescription) {
        this.batchDescription = batchDescription;
    }

    public Date getBatchDate() {
        return batchDate;
    }

    public void setBatchDate(Date batchDate) {
        this.batchDate = batchDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getEntryNo() {
        return entryNo;
    }

    public void setEntryNo(Long entryNo) {
        this.entryNo = entryNo;
    }

    public Boolean getPosted() {
        return posted;
    }

    public void setPosted(Boolean posted) {
        this.posted = posted;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "id=" + id +
                ", batchNo=" + batchNo +
                ", batchDescription='" + batchDescription + '\'' +
                ", batchDate=" + batchDate +
                ", amount=" + amount +
                ", status=" + status +
                ", entryNo=" + entryNo +
                ", posted=" + posted +
                ", postDate=" + postDate +
                ", code='" + code + '\'' +
                ", staff=" + staff +
                '}';
    }
}
