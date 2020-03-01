package ke.ac.egerton.student_finance.filters;


import java.math.BigDecimal;
import java.util.Date;

public class TransactionFilter {

    private Long id;
    private Long batchNo;
    private Long entryNo;
    private String docNo;
    private String studentNo;
    private String studentAccountNo;
    private String yearCode;
    private String periodCode;
    private String academicYear;
    private String semSessionCode;
    private String sectionCode;
    private Long financialYearCode;
    private Long financialYearPeriod;
    private String accountSetCode;
    private String documentType;
    private String docTypeDesc;
    private Date documentDate;
    private String docDescription;
    private String homeCurrency;
    private String homeAmount;
    private String srcCurrency;
    private String srcAmount;
    private BigDecimal amount;
    private BigDecimal exchangeRate;
    private String tpCode;
    private String receiptNo;
    private Boolean poseted;
    private Date postedOn;
    private Boolean updated;

    public TransactionFilter() {
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

    public Long getEntryNo() {
        return entryNo;
    }

    public void setEntryNo(Long entryNo) {
        this.entryNo = entryNo;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentAccountNo() {
        return studentAccountNo;
    }

    public void setStudentAccountNo(String studentAccountNo) {
        this.studentAccountNo = studentAccountNo;
    }

    public String getYearCode() {
        return yearCode;
    }

    public void setYearCode(String yearCode) {
        this.yearCode = yearCode;
    }

    public String getPeriodCode() {
        return periodCode;
    }

    public void setPeriodCode(String periodCode) {
        this.periodCode = periodCode;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getSemSessionCode() {
        return semSessionCode;
    }

    public void setSemSessionCode(String semSessionCode) {
        this.semSessionCode = semSessionCode;
    }

    public String getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(String sectionCode) {
        this.sectionCode = sectionCode;
    }

    public Long getFinancialYearCode() {
        return financialYearCode;
    }

    public void setFinancialYearCode(Long financialYearCode) {
        this.financialYearCode = financialYearCode;
    }

    public Long getFinancialYearPeriod() {
        return financialYearPeriod;
    }

    public void setFinancialYearPeriod(Long financialYearPeriod) {
        this.financialYearPeriod = financialYearPeriod;
    }

    public String getAccountSetCode() {
        return accountSetCode;
    }

    public void setAccountSetCode(String accountSetCode) {
        this.accountSetCode = accountSetCode;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocTypeDesc() {
        return docTypeDesc;
    }

    public void setDocTypeDesc(String docTypeDesc) {
        this.docTypeDesc = docTypeDesc;
    }

    public Date getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(Date documentDate) {
        this.documentDate = documentDate;
    }

    public String getDocDescription() {
        return docDescription;
    }

    public void setDocDescription(String docDescription) {
        this.docDescription = docDescription;
    }

    public String getHomeCurrency() {
        return homeCurrency;
    }

    public void setHomeCurrency(String homeCurrency) {
        this.homeCurrency = homeCurrency;
    }

    public String getHomeAmount() {
        return homeAmount;
    }

    public void setHomeAmount(String homeAmount) {
        this.homeAmount = homeAmount;
    }

    public String getSrcCurrency() {
        return srcCurrency;
    }

    public void setSrcCurrency(String srcCurrency) {
        this.srcCurrency = srcCurrency;
    }

    public String getSrcAmount() {
        return srcAmount;
    }

    public void setSrcAmount(String srcAmount) {
        this.srcAmount = srcAmount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getTpCode() {
        return tpCode;
    }

    public void setTpCode(String tpCode) {
        this.tpCode = tpCode;
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public Boolean getPoseted() {
        return poseted;
    }

    public void setPoseted(Boolean poseted) {
        this.poseted = poseted;
    }

    public Date getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(Date postedOn) {
        this.postedOn = postedOn;
    }

    public Boolean getUpdated() {
        return updated;
    }

    public void setUpdated(Boolean updated) {
        this.updated = updated;
    }


    @Override
    public String toString() {
        return "TransactionFilter{" +
                "id=" + id +
                ", batchNo=" + batchNo +
                ", entryNo=" + entryNo +
                ", docNo='" + docNo + '\'' +
                ", studentNo='" + studentNo + '\'' +
                ", studentAccountNo='" + studentAccountNo + '\'' +
                ", yearCode='" + yearCode + '\'' +
                ", periodCode='" + periodCode + '\'' +
                ", academicYear='" + academicYear + '\'' +
                ", semSessionCode='" + semSessionCode + '\'' +
                ", sectionCode='" + sectionCode + '\'' +
                ", financialYearCode=" + financialYearCode +
                ", financialYearPeriod=" + financialYearPeriod +
                ", accountSetCode='" + accountSetCode + '\'' +
                ", documentType='" + documentType + '\'' +
                ", docTypeDesc='" + docTypeDesc + '\'' +
                ", documentDate=" + documentDate +
                ", docDescription='" + docDescription + '\'' +
                ", homeCurrency='" + homeCurrency + '\'' +
                ", homeAmount='" + homeAmount + '\'' +
                ", srcCurrency='" + srcCurrency + '\'' +
                ", srcAmount='" + srcAmount + '\'' +
                ", amount=" + amount +
                ", exchangeRate=" + exchangeRate +
                ", tpCode='" + tpCode + '\'' +
                ", receiptNo='" + receiptNo + '\'' +
                ", poseted=" + poseted +
                ", postedOn=" + postedOn +
                ", updated=" + updated +
                '}';
    }
}
