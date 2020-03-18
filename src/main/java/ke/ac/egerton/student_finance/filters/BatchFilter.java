package ke.ac.egerton.student_finance.filters;


import java.math.BigDecimal;
import java.util.Date;

public class BatchFilter {
    private String batchNo;
    private String batchDescription;
    private Date batchDate;
    private BigDecimal amount;
    private Long status;
    private Long entryNo;
    private Boolean posted;
    private Date postDate;
    private String code;
    private String staffId;

    public BatchFilter() {
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
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

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    @Override
    public String toString() {
        return "BatchFilter{" +
                "batchNo=" + batchNo +
                ", batchDescription='" + batchDescription + '\'' +
                ", batchDate=" + batchDate +
                ", amount=" + amount +
                ", status=" + status +
                ", entryNo=" + entryNo +
                ", posted=" + posted +
                ", postDate=" + postDate +
                ", code='" + code + '\'' +
                ", staffId='" + staffId + '\'' +
                '}';
    }
}
