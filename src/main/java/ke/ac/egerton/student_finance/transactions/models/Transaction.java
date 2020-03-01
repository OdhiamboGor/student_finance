package ke.ac.egerton.student_finance.transactions.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "SFINVHD")
public class Transaction extends AuditableEntity {

    @Id
    @GeneratedValue(generator = "SFINVHD")
    @GenericGenerator(name = "SFINVHD", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;
    @Column(name = "BATCHNO")
    private Long batchNo;
    @Column(name = "ENTRYNO")
    private Long entryNo;
    @Column(name = "DOCNO")
    private String docNo;
    @Column(name = "STUDENTNO")
    private String studentNo;
    @Column(name = "STUDACCOUNTNO")
    private String studentAccountNo;
    @Column(name = "YEARCODE")
    private String yearCode;
    @Column(name = "PERIODCODE")
    private String periodCode;
    @Column(name = "ACADEMICYEAR")
    private String academicYear;
    @Column(name = "SEMSESSIONCODE")
    private String semSessionCode;
    @Column(name = "SECTIONCODE")
    private String sectionCode;
    @Column(name = "FYCODE")
    private Long financialYearCode;
    @Column(name = "FYPERIOD")
    private Long financialYearPeriod;
    @Column(name = "ACCSETCODE")
    private String accountSetCode;
    @Column(name = "DOCTYPE")
    private String documentType;
    @Column(name = "DOCTYPEDESC")
    private String docTypeDesc;
    @Column(name = "DOCDATE")
    private Date documentDate;
    @Column(name = "DOCDESCRIPTION")
    private String docDescription;
    @Column(name = "HMCUR")
    private String homeCurrency;
    @Column(name = "HMAMT")
    private String homeAmount;
    @Column(name = "SRCCUR")
    private String srcCurrency;
    @Column(name = "SRCAMT")
    private String srcAmount;
    @Column(name = "AMOUNT")
    private BigDecimal amount;
    @Column(name = "EXCHRATE")
    private BigDecimal exchangeRate;
    @Column(name = "TPCODE")
    private String tpCode;
    @Column(name = "RCNO")
    private String receiptNo;
    @Column(name = "POSTED")
    private Boolean poseted;
    @Column(name = "POSTEDON")
    private Date postedOn;
    @Column(name = "UPDATED")
    private Boolean updated;

    public Transaction() {
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
        return "Transaction{" +
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
