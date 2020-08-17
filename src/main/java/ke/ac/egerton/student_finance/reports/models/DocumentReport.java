package ke.ac.egerton.student_finance.reports.models;

import java.math.BigDecimal;

public class DocumentReport {

    private String rcNo;
    private String customerId;
    private BigDecimal amount;
    private String segmentCode;
    private String segmentDescription;
    private String semesterSessionCode;
    private String receivedFrom;


    public DocumentReport() {
    }

    public String getRcNo() {
        return rcNo;
    }

    public void setRcNo(String rcNo) {
        this.rcNo = rcNo;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getSegmentCode() {
        return segmentCode;
    }

    public void setSegmentCode(String segmentCode) {
        this.segmentCode = segmentCode;
    }

    public String getSegmentDescription() {
        return segmentDescription;
    }

    public void setSegmentDescription(String segmentDescription) {
        this.segmentDescription = segmentDescription;
    }

    public String getSemesterSessionCode() {
        return semesterSessionCode;
    }

    public void setSemesterSessionCode(String semesterSessionCode) {
        this.semesterSessionCode = semesterSessionCode;
    }

    public String getReceivedFrom() {
        return receivedFrom;
    }

    public void setReceivedFrom(String receivedFrom) {
        this.receivedFrom = receivedFrom;
    }
}
