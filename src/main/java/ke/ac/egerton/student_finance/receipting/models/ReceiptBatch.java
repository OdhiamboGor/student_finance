package ke.ac.egerton.student_finance.receipting.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import ke.ac.egerton.models.Staff;
import ke.ac.egerton.student_finance.settings.accountsSetup.models.AccountSet;
import ke.ac.egerton.student_finance.settings.receipts.models.ReceiptingCriteria;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SFRCBATCH")
public class ReceiptBatch extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "SFRCBATCH")
    @GenericGenerator(name = "SFRCBATCH", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @Column(name = "BATCHID")
    private String batchId;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    private Staff staff;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "BATCHDATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date batchDate;

    @Column(name = "BATCHEEND")
    private Long batchEnd;

    @Column(name = "BATCHDESC")
    private String batchDescription;

    @Column(name = "STATUS")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "ACCSETCODE", referencedColumnName = "ACCSETCODE")
    private AccountSet accountSet;

    @Column(name = "RDPOST")
    private Boolean post;


    @ManyToOne
    @JoinColumn(name = "MODECODE", referencedColumnName = "MODECODE")
    private ReceiptingCriteria receiptingCriteria;

    @Column(name = "LOCCODE")
    private String location;

    public ReceiptBatch() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return String.valueOf(id);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Date getBatchDate() {
        return batchDate;
    }

    public void setBatchDate(Date batchDate) {
        this.batchDate = batchDate;
    }

    public Long getBatchEnd() {
        return batchEnd;
    }

    public void setBatchEnd(Long batchEnd) {
        this.batchEnd = batchEnd;
    }

    public String getBatchDescription() {
        return batchDescription;
    }

    public void setBatchDescription(String batchDescription) {
        this.batchDescription = batchDescription;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public AccountSet getAccountSet() {
        return accountSet;
    }

    public void setAccountSet(AccountSet accountSet) {
        this.accountSet = accountSet;
    }

    public Boolean getPost() {
        return post;
    }

    public void setPost(Boolean post) {
        this.post = post;
    }

    public ReceiptingCriteria getReceiptingCriteria() {
        return receiptingCriteria;
    }

    public void setReceiptingCriteria(ReceiptingCriteria receiptingCriteria) {
        this.receiptingCriteria = receiptingCriteria;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "ReceiptBatch{" +
                "id=" + id +
                ", batchId='" + batchId + '\'' +
                ", staff=" + staff +
                ", username='" + username + '\'' +
                ", batchDate=" + batchDate +
                ", batchEnd=" + batchEnd +
                ", batchDescription='" + batchDescription + '\'' +
                ", status=" + status +
                ", accountSet=" + accountSet +
                ", post=" + post +
                ", receiptingCriteria=" + receiptingCriteria +
                ", location='" + location + '\'' +
                '}';
    }
}
