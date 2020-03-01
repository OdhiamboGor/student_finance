package ke.ac.egerton.student_finance.settings.bankSetup.controllers.validation;

import java.util.Date;

public class ReceiptBatchDetails {

    private Long id;
    private String batchId;
    private String staff;
    private Date batchDate;
    private Long batchEnd;
    private String batchDescription;
    private Boolean status;
    private String accountSet;
    private Boolean post;
    private String receiptingCriteria;
    private String location;

    public Long getId() {
        return id;
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

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
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

    public String getAccountSet() {
        return accountSet;
    }

    public void setAccountSet(String accountSet) {
        this.accountSet = accountSet;
    }

    public Boolean getPost() {
        return post;
    }

    public void setPost(Boolean post) {
        this.post = post;
    }

    public String getReceiptingCriteria() {
        return receiptingCriteria;
    }

    public void setReceiptingCriteria(String receiptingCriteria) {
        this.receiptingCriteria = receiptingCriteria;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
