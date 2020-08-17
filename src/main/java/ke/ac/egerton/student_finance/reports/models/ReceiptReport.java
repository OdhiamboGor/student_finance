package ke.ac.egerton.student_finance.reports.models;


import java.util.Date;

public class ReceiptReport {

    private String batchId;
    private String receiptNumber;
    private String customerId;
    private Long receiptAmount;
    private Date receiptDate;
    private Long receiptDateUF;
    private String SEGCode;
    private String SEGDescription;
    private  String REVAccount;
    private String CBar;
    private String academicYear;
    private String semesterSessionCode;
    private String yearCode;
    private String period;
    private String appto;
    private String receiptFrom;
    private String account;
    private String prepayment;
    private Long posted;
    private String receiptSstatus;
    private Long acmposted;
    private String homeCurrency;
    private Long homeAmount;
    private String srCurrency;
    private Long srcAmount;
    private Long exchangeRate;
    private String revacctgl;
    private String strCode;
    private String accountSetCode;
    private String accountSetControl;
    private String accountGLControl;
    private String accountSetControlCode;
    private Long accountExist;
    private Long expired;

    public ReceiptReport() {
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
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

    public Long getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(Long receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Long getReceiptDateUF() {
        return receiptDateUF;
    }

    public void setReceiptDateUF(Long receiptDateUF) {
        this.receiptDateUF = receiptDateUF;
    }

    public String getSEGCode() {
        return SEGCode;
    }

    public void setSEGCode(String SEGCode) {
        this.SEGCode = SEGCode;
    }

    public String getSEGDescription() {
        return SEGDescription;
    }

    public void setSEGDescription(String SEGDescription) {
        this.SEGDescription = SEGDescription;
    }

    public String getREVAccount() {
        return REVAccount;
    }

    public void setREVAccount(String REVAccount) {
        this.REVAccount = REVAccount;
    }

    public String getCBar() {
        return CBar;
    }

    public void setCBar(String CBar) {
        this.CBar = CBar;
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

    public String getReceiptFrom() {
        return receiptFrom;
    }

    public void setReceiptFrom(String receiptFrom) {
        this.receiptFrom = receiptFrom;
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

    public Long getPosted() {
        return posted;
    }

    public void setPosted(Long posted) {
        this.posted = posted;
    }

    public String getReceiptSstatus() {
        return receiptSstatus;
    }

    public void setReceiptSstatus(String receiptSstatus) {
        this.receiptSstatus = receiptSstatus;
    }

    public Long getAcmposted() {
        return acmposted;
    }

    public void setAcmposted(Long acmposted) {
        this.acmposted = acmposted;
    }

    public String getHomeCurrency() {
        return homeCurrency;
    }

    public void setHomeCurrency(String homeCurrency) {
        this.homeCurrency = homeCurrency;
    }

    public Long getHomeAmount() {
        return homeAmount;
    }

    public void setHomeAmount(Long homeAmount) {
        this.homeAmount = homeAmount;
    }

    public String getSrCurrency() {
        return srCurrency;
    }

    public void setSrCurrency(String srCurrency) {
        this.srCurrency = srCurrency;
    }

    public Long getSrcAmount() {
        return srcAmount;
    }

    public void setSrcAmount(Long srcAmount) {
        this.srcAmount = srcAmount;
    }

    public Long getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Long exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getRevacctgl() {
        return revacctgl;
    }

    public void setRevacctgl(String revacctgl) {
        this.revacctgl = revacctgl;
    }

    public String getStrCode() {
        return strCode;
    }

    public void setStrCode(String strCode) {
        this.strCode = strCode;
    }

    public String getAccountSetCode() {
        return accountSetCode;
    }

    public void setAccountSetCode(String accountSetCode) {
        this.accountSetCode = accountSetCode;
    }

    public String getAccountSetControl() {
        return accountSetControl;
    }

    public void setAccountSetControl(String accountSetControl) {
        this.accountSetControl = accountSetControl;
    }

    public String getAccountGLControl() {
        return accountGLControl;
    }

    public void setAccountGLControl(String accountGLControl) {
        this.accountGLControl = accountGLControl;
    }

    public String getAccountSetControlCode() {
        return accountSetControlCode;
    }

    public void setAccountSetControlCode(String accountSetControlCode) {
        this.accountSetControlCode = accountSetControlCode;
    }

    public Long getAccountExist() {
        return accountExist;
    }

    public void setAccountExist(Long accountExist) {
        this.accountExist = accountExist;
    }

    public Long getExpired() {
        return expired;
    }

    public void setExpired(Long expired) {
        this.expired = expired;
    }

    @Override
    public String toString() {
        return "ReceiptReport{" +
                "batchId='" + batchId + '\'' +
                ", receiptNumber='" + receiptNumber + '\'' +
                ", customerId='" + customerId + '\'' +
                ", receiptAmount=" + receiptAmount +
                ", receiptDate=" + receiptDate +
                ", receiptDateUF=" + receiptDateUF +
                ", SEGCode='" + SEGCode + '\'' +
                ", SEGDescription='" + SEGDescription + '\'' +
                ", REVAccount='" + REVAccount + '\'' +
                ", CBar='" + CBar + '\'' +
                ", academicYear='" + academicYear + '\'' +
                ", semesterSessionCode='" + semesterSessionCode + '\'' +
                ", yearCode='" + yearCode + '\'' +
                ", period='" + period + '\'' +
                ", appto='" + appto + '\'' +
                ", receiptFrom='" + receiptFrom + '\'' +
                ", account='" + account + '\'' +
                ", prepayment='" + prepayment + '\'' +
                ", posted=" + posted +
                ", receiptSstatus='" + receiptSstatus + '\'' +
                ", acmposted=" + acmposted +
                ", homeCurrency='" + homeCurrency + '\'' +
                ", homeAmount=" + homeAmount +
                ", srCurrency='" + srCurrency + '\'' +
                ", srcAmount=" + srcAmount +
                ", exchangeRate=" + exchangeRate +
                ", revacctgl='" + revacctgl + '\'' +
                ", strCode='" + strCode + '\'' +
                ", accountSetCode='" + accountSetCode + '\'' +
                ", accountSetControl='" + accountSetControl + '\'' +
                ", accountGLControl='" + accountGLControl + '\'' +
                ", accountSetControlCode='" + accountSetControlCode + '\'' +
                ", accountExist=" + accountExist +
                ", expired=" + expired +
                '}';
    }
}
