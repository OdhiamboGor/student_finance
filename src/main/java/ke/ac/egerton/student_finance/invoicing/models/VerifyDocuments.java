package ke.ac.egerton.student_finance.invoicing.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "SFRCDTLS")
public class VefiryDocuments extends AuditableEntity {

    @Id
    @GeneratedValue(generator = "SFRCDTLS")
    @GenericGenerator(name = "SFRCDTLS", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private  Long id;
    @Column(name = "BATCHID")
    private Long batchId;
    @Column(name = "RCNO")
    @NotNull
    private String rcNo;
    @Column(name = "IDCUST")
    @NotNull
    private String customerId;
    @Column(name = "AMOUNT")
    @NotNull
    private BigDecimal amount;
    @Column(name = "RCDATEF")
    @NotNull
    private Date receiptDate;
    @Column(name = "RCDATEUF")
    @NotNull
    private Integer receipDate;
    @Column(name = "SEGCODE")
    @NotNull
    private String segmentCode;
    @Column(name = "SEGDESC")
    private String segmentDescription;
    @Column(name = "REVACCT")
    private String revAccount;
    @Column(name = "CBAR")
    private String cBar;
    @Column(name = "ACADEMICYEAR")
    private String academicYear;
    @Column(name = "SEMSESSIONCODE")
    private String semesterSessionCode;
    @Column(name = "YEARCODE")
    private String yearCode;
    @Column(name = "PERIOD")
    private String period;
    @Column(name = "APPTO")
    private String appto;
    @Column(name = "RECFROM")
    private String receivedFrom;
    @Column(name = "ACCOUNT")
    private String account;
    @Column(name = "PREPAYMENT")
    private String prepayment;
    @Column(name = "POSTED")
    private Boolean posted;
    @Column(name = "RCSTATUS")
    private String status;
    @Column(name = "ACMMPOSTED")
    private Integer acmmPosted;
    @Column(name = "HMCUR")
    private String homeCurrency;
    @Column(name = "HMAMT")
    private BigDecimal homeAmount;
    @Column(name = "SRCCUR")
    private String srcCurrency;
    @Column(name = "SRCAMT")
    private BigDecimal srcAmount;
    @Column(name = "EXCHRATE")
    private BigDecimal exchangedRate;
    @Column(name = "REVACCTGL")
    private String reverseAccountGL;
    @Column(name = "STRCODE")
    private String stringCode;
    @Column(name = "ACCSETCODE")
    private String accountSetCode;
    @Column(name = "ACCSETCTRL")
    private String accontSetControl;
    @Column(name = "ACCTGLCTRL")
    private String accountGLControl;
    @Column(name = "ACCSETSTRCODE")
    private String accountSetStringCode;
    @Column(name = "ACCTEXISTS")
    private Boolean accountExists;
    @Column(name = "EXPD")
    private Boolean expired;

    public VefiryDocuments() {
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

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Integer getReceipDate() {
        return receipDate;
    }

    public void setReceipDate(Integer receipDate) {
        this.receipDate = receipDate;
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

    public String getRevAccount() {
        return revAccount;
    }

    public void setRevAccount(String revAccount) {
        this.revAccount = revAccount;
    }

    public String getcBar() {
        return cBar;
    }

    public void setcBar(String cBar) {
        this.cBar = cBar;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getSemesterSessionCode() {
        return semesterSessionCode;
    }

    public void setSemesterSessionCode(String semesterSessionCode) {
        this.semesterSessionCode = semesterSessionCode;
    }

    public String getYearCode() {
        return yearCode;
    }

    public void setYearCode(String yearCode) {
        this.yearCode = yearCode;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getAppto() {
        return appto;
    }

    public void setAppto(String appto) {
        this.appto = appto;
    }

    public String getReceivedFrom() {
        return receivedFrom;
    }

    public void setReceivedFrom(String receivedFrom) {
        this.receivedFrom = receivedFrom;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPrepayment() {
        return prepayment;
    }

    public void setPrepayment(String prepayment) {
        this.prepayment = prepayment;
    }

    public Boolean getPosted() {
        return posted;
    }

    public void setPosted(Boolean posted) {
        this.posted = posted;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAcmmPosted() {
        return acmmPosted;
    }

    public void setAcmmPosted(Integer acmmPosted) {
        this.acmmPosted = acmmPosted;
    }

    public String getHomeCurrency() {
        return homeCurrency;
    }

    public void setHomeCurrency(String homeCurrency) {
        this.homeCurrency = homeCurrency;
    }

    public BigDecimal getHomeAmount() {
        return homeAmount;
    }

    public void setHomeAmount(BigDecimal homeAmount) {
        this.homeAmount = homeAmount;
    }

    public String getSrcCurrency() {
        return srcCurrency;
    }

    public void setSrcCurrency(String srcCurrency) {
        this.srcCurrency = srcCurrency;
    }

    public BigDecimal getSrcAmount() {
        return srcAmount;
    }

    public void setSrcAmount(BigDecimal srcAmount) {
        this.srcAmount = srcAmount;
    }

    public BigDecimal getExchangedRate() {
        return exchangedRate;
    }

    public void setExchangedRate(BigDecimal exchangedRate) {
        this.exchangedRate = exchangedRate;
    }

    public String getReverseAccountGL() {
        return reverseAccountGL;
    }

    public void setReverseAccountGL(String reverseAccountGL) {
        this.reverseAccountGL = reverseAccountGL;
    }

    public String getStringCode() {
        return stringCode;
    }

    public void setStringCode(String stringCode) {
        this.stringCode = stringCode;
    }

    public String getAccountSetCode() {
        return accountSetCode;
    }

    public void setAccountSetCode(String accountSetCode) {
        this.accountSetCode = accountSetCode;
    }

    public String getAccontSetControl() {
        return accontSetControl;
    }

    public void setAccontSetControl(String accontSetControl) {
        this.accontSetControl = accontSetControl;
    }

    public String getAccountGLControl() {
        return accountGLControl;
    }

    public void setAccountGLControl(String accountGLControl) {
        this.accountGLControl = accountGLControl;
    }

    public String getAccountSetStringCode() {
        return accountSetStringCode;
    }

    public void setAccountSetStringCode(String accountSetStringCode) {
        this.accountSetStringCode = accountSetStringCode;
    }

    public Boolean getAccountExists() {
        return accountExists;
    }

    public void setAccountExists(Boolean accountExists) {
        this.accountExists = accountExists;
    }

    public Boolean getExpired() {
        return expired;
    }

    public void setExpired(Boolean expired) {
        this.expired = expired;
    }
}
