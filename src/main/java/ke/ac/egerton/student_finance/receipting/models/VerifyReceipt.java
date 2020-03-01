package ke.ac.egerton.student_finance.receipting.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "SFRCHEADER")
public class VerifyReceipt extends AuditableEntity {

    @Id
    @GeneratedValue(generator = "SFRCHEADER")
    @GenericGenerator(name = "SFRCHEADER", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;
    @Column(name = "BATCHID")
    private String batchId;
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
    @Column(name = "STUDENTEXIST")
    private Boolean studentExist;
    @Column(name = "ACADEMICYEAR")
    private String academicYear;
    @Column(name = "SEMSESSIONCODE")
    private String session;
    @Column(name = "YEARCODE")
    private  String year;
    @Column(name = "PERIOD")
    private  String period;
    @Column(name = "RCDATEF")
    private Date receiptDate;
    @Column(name = "RCDATEUF")
    private Long receiptDateUF;
    @Column(name = "RCAMOUNT")
    private BigDecimal amount;
    @Column(name = "RCAMOUNTWORDS")
    private  String rcAmountWords;
    @Column(name = "RCAMOUNTORIG")
    private BigDecimal rcAmountRg;
    @Column(name = "BALANCE")
    private BigDecimal balance;
    @Column(name = "POSTED")
    private Boolean posted;
    @Column(name = "POSTDATE")
    private Date postedDate;
    @Column(name = "CBAR")
    private  String cBar;
    @Column(name = "PAYMODE")
    private  String paymentMode;
    @Column(name = "PAYMODESC")
    private  String paymentModeDescription;
    @Column(name = "DEPOSITNO")
    private  String depositNo;
    @Column(name = "DEPOSITDATE")
    private Date depositDate;
    @Column(name = "CHECKNO")
    private  String checkNo;
    @Column(name = "DOCNO")
    private  String docNo;
    @Column(name = "CONSTITUENCY")
    private  String constituency;
    @Column(name = "LOCATION")
    private  String location;
    @Column(name = "USERNAME")
    private  String username;
    @Column(name = "CANCELLED")
    private  Long cancelled;
    @Column(name = "CANCELBY")
    private  String cancelledBy;
    @Column(name = "CANCELDATE")
    private Date cancelledDate;
    @Column(name = "REASON")
    private  String reason;
    @Column(name = "DATEBANKED")
    private Date dateBanked;
    @Column(name = "BANKNAME")
    private  String bankName;
    @Column(name = "SOURCEBANK")
    private  String sourceBank;
    @Column(name = "SOURCEBANKNAME")
    private  String sourceBankName;
    @Column(name = "SOURCEBANKCODE")
    private  String sourceBankCode;
    @Column(name = "PREPAYMENT")
    private BigDecimal prepayment;
    @Column(name = "VERIFIED")
    private Boolean verified;
    @Column(name = "VERIFIEDBY")
    private  String verifiedBy;
    @Column(name = "VERIFYDATE")
    private Date verifyDate;
    @Column(name = "BANKED")
    private  String banked;
    @Column(name = "RCSTATUS")
    private  String receiptStatus;
    @Column(name = "PRINTED")
    private Long printed;
    @Column(name = "PROCSD")
    private Long processed;
    @Column(name = "APPTO")
    private  String appto;
    @Column(name = "TPCODE")
    private  String tpCode;
    @Column(name = "CLAIMEDBY")
    private  String claimedBy;
    @Column(name = "REFUNDED")
    private  String refunded;
    @Column(name = "BKACCT")
    private  String bankAccount;
    @Column(name = "SECTIONCODE")
    private  String sectionCode;
    @Column(name = "HMCUR")
    private  String homeCurrency;
    @Column(name = "HMAMT")
    private BigDecimal homeAmount;
    @Column(name = "SRCCUR")
    private  String srCurrency;
    @Column(name = "SRCAMT")
    private BigDecimal srcAmount;
    @Column(name = "EXCHRATE")
    private BigDecimal exchangeRate;
    @Column(name = "FYCODE")
    private Long financialCode;
    @Column(name = "FYPERIOD")
    private Long financialPeriod;
    @Column(name = "ALLOCATED")
    private Long allocated;
    @Column(name = "ALLAMOUNT")
    private BigDecimal allocatedAmount;
    @Column(name = "ACCSETCODE")
    private String accessCode;
    @Column(name = "CATEGORYCODE")
    private String categoryCode;
    @Column(name = "STUDYMETHODCODE")
    private String studyMethodCode;
    @Column(name = "PRCODE")
    private String prCode;
    @Column(name = "CHTCODE")
    private String chtCode;
    @Column(name = "ACADLEVELCODE")
    private String academicLevelCode;
    @Column(name = "CAMPUSCODE")
    private String campusCode;
    @Column(name = "DEPARTMENTCODE")
    private String departmentCode;
    @Column(name = "ACCSETCTRL")
    private String accsetControl;
    @Column(name = "ACCTGLCTRL")
    private String 	accountGlControl;
    @Column(name = "STRCODE")
    private String strCode;
    @Column(name = "EXPD")
    private Long expired;
    @Column(name = "CMT")
    private String cmt;
    @Column(name = "TRANSFERREDTO")
    private String 	transferedTo;
    @Column(name = "MODECODE")
    private String modeCode;
    @Column(name = "ACCTEXISTS")
    private Boolean accountExists;
    @Column(name = "REVERSED")
    private Boolean reversed;

    public VerifyReceipt() {
    }

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

    public Boolean getStudentExist() {
        return studentExist;
    }

    public void setStudentExist(Boolean studentExist) {
        this.studentExist = studentExist;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getRcAmountWords() {
        return rcAmountWords;
    }

    public void setRcAmountWords(String rcAmountWords) {
        this.rcAmountWords = rcAmountWords;
    }

    public BigDecimal getRcAmountRg() {
        return rcAmountRg;
    }

    public void setRcAmountRg(BigDecimal rcAmountRg) {
        this.rcAmountRg = rcAmountRg;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Boolean getPosted() {
        return posted;
    }

    public void setPosted(Boolean posted) {
        this.posted = posted;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public String getcBar() {
        return cBar;
    }

    public void setcBar(String cBar) {
        this.cBar = cBar;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getPaymentModeDescription() {
        return paymentModeDescription;
    }

    public void setPaymentModeDescription(String paymentModeDescription) {
        this.paymentModeDescription = paymentModeDescription;
    }

    public String getDepositNo() {
        return depositNo;
    }

    public void setDepositNo(String depositNo) {
        this.depositNo = depositNo;
    }

    public Date getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(Date depositDate) {
        this.depositDate = depositDate;
    }

    public String getCheckNo() {
        return checkNo;
    }

    public void setCheckNo(String checkNo) {
        this.checkNo = checkNo;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public String getConstituency() {
        return constituency;
    }

    public void setConstituency(String constituency) {
        this.constituency = constituency;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getCancelled() {
        return cancelled;
    }

    public void setCancelled(Long cancelled) {
        this.cancelled = cancelled;
    }

    public String getCancelledBy() {
        return cancelledBy;
    }

    public void setCancelledBy(String cancelledBy) {
        this.cancelledBy = cancelledBy;
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

    public Date getDateBanked() {
        return dateBanked;
    }

    public void setDateBanked(Date dateBanked) {
        this.dateBanked = dateBanked;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSourceBank() {
        return sourceBank;
    }

    public void setSourceBank(String sourceBank) {
        this.sourceBank = sourceBank;
    }

    public String getSourceBankName() {
        return sourceBankName;
    }

    public void setSourceBankName(String sourceBankName) {
        this.sourceBankName = sourceBankName;
    }

    public String getSourceBankCode() {
        return sourceBankCode;
    }

    public void setSourceBankCode(String sourceBankCode) {
        this.sourceBankCode = sourceBankCode;
    }

    public BigDecimal getPrepayment() {
        return prepayment;
    }

    public void setPrepayment(BigDecimal prepayment) {
        this.prepayment = prepayment;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public String getVerifiedBy() {
        return verifiedBy;
    }

    public void setVerifiedBy(String verifiedBy) {
        this.verifiedBy = verifiedBy;
    }

    public Date getVerifyDate() {
        return verifyDate;
    }

    public void setVerifyDate(Date verifyDate) {
        this.verifyDate = verifyDate;
    }

    public String getBanked() {
        return banked;
    }

    public void setBanked(String banked) {
        this.banked = banked;
    }

    public String getReceiptStatus() {
        return receiptStatus;
    }

    public void setReceiptStatus(String receiptStatus) {
        this.receiptStatus = receiptStatus;
    }

    public Long getPrinted() {
        return printed;
    }

    public void setPrinted(Long printed) {
        this.printed = printed;
    }

    public Long getProcessed() {
        return processed;
    }

    public void setProcessed(Long processed) {
        this.processed = processed;
    }

    public String getAppto() {
        return appto;
    }

    public void setAppto(String appto) {
        this.appto = appto;
    }

    public String getTpCode() {
        return tpCode;
    }

    public void setTpCode(String tpCode) {
        this.tpCode = tpCode;
    }

    public String getClaimedBy() {
        return claimedBy;
    }

    public void setClaimedBy(String claimedBy) {
        this.claimedBy = claimedBy;
    }

    public String getRefunded() {
        return refunded;
    }

    public void setRefunded(String refunded) {
        this.refunded = refunded;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(String sectionCode) {
        this.sectionCode = sectionCode;
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

    public String getSrCurrency() {
        return srCurrency;
    }

    public void setSrCurrency(String srCurrency) {
        this.srCurrency = srCurrency;
    }

    public BigDecimal getSrcAmount() {
        return srcAmount;
    }

    public void setSrcAmount(BigDecimal srcAmount) {
        this.srcAmount = srcAmount;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Long getFinancialCode() {
        return financialCode;
    }

    public void setFinancialCode(Long financialCode) {
        this.financialCode = financialCode;
    }

    public Long getFinancialPeriod() {
        return financialPeriod;
    }

    public void setFinancialPeriod(Long financialPeriod) {
        this.financialPeriod = financialPeriod;
    }

    public Long getAllocated() {
        return allocated;
    }

    public void setAllocated(Long allocated) {
        this.allocated = allocated;
    }

    public BigDecimal getAllocatedAmount() {
        return allocatedAmount;
    }

    public void setAllocatedAmount(BigDecimal allocatedAmount) {
        this.allocatedAmount = allocatedAmount;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getStudyMethodCode() {
        return studyMethodCode;
    }

    public void setStudyMethodCode(String studyMethodCode) {
        this.studyMethodCode = studyMethodCode;
    }

    public String getPrCode() {
        return prCode;
    }

    public void setPrCode(String prCode) {
        this.prCode = prCode;
    }

    public String getChtCode() {
        return chtCode;
    }

    public void setChtCode(String chtCode) {
        this.chtCode = chtCode;
    }

    public String getAcademicLevelCode() {
        return academicLevelCode;
    }

    public void setAcademicLevelCode(String academicLevelCode) {
        this.academicLevelCode = academicLevelCode;
    }

    public String getCampusCode() {
        return campusCode;
    }

    public void setCampusCode(String campusCode) {
        this.campusCode = campusCode;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getAccsetControl() {
        return accsetControl;
    }

    public void setAccsetControl(String accsetControl) {
        this.accsetControl = accsetControl;
    }

    public String getAccountGlControl() {
        return accountGlControl;
    }

    public void setAccountGlControl(String accountGlControl) {
        this.accountGlControl = accountGlControl;
    }

    public String getStrCode() {
        return strCode;
    }

    public void setStrCode(String strCode) {
        this.strCode = strCode;
    }

    public Long getExpired() {
        return expired;
    }

    public void setExpired(Long expired) {
        this.expired = expired;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public String getTransferedTo() {
        return transferedTo;
    }

    public void setTransferedTo(String transferedTo) {
        this.transferedTo = transferedTo;
    }

    public String getModeCode() {
        return modeCode;
    }

    public void setModeCode(String modeCode) {
        this.modeCode = modeCode;
    }

    public Boolean getAccountExists() {
        return accountExists;
    }

    public void setAccountExists(Boolean accountExists) {
        this.accountExists = accountExists;
    }

    public Boolean getReversed() {
        return reversed;
    }

    public void setReversed(Boolean reversed) {
        this.reversed = reversed;
    }

    @Override
    public String toString() {
        return "VerifyReceipt{" +
                "id=" + id +
                ", batchId=" + batchId +
                ", receiptNumber='" + receiptNumber + '\'' +
                ", customerId='" + customerId + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", fullName='" + fullName + '\'' +
                ", receiptType='" + receiptType + '\'' +
                ", studentExist=" + studentExist +
                ", academicYear='" + academicYear + '\'' +
                ", session='" + session + '\'' +
                ", year='" + year + '\'' +
                ", period='" + period + '\'' +
                ", receiptDate=" + receiptDate +
                ", receiptDateUF=" + receiptDateUF +
                ", amount=" + amount +
                ", rcAmountWords='" + rcAmountWords + '\'' +
                ", rcAmountRg=" + rcAmountRg +
                ", balance=" + balance +
                ", posted=" + posted +
                ", postedDate=" + postedDate +
                ", cBar='" + cBar + '\'' +
                ", paymentMode='" + paymentMode + '\'' +
                ", paymentModeDescription='" + paymentModeDescription + '\'' +
                ", depositNo='" + depositNo + '\'' +
                ", depositDate=" + depositDate +
                ", checkNo='" + checkNo + '\'' +
                ", docNo='" + docNo + '\'' +
                ", constituency='" + constituency + '\'' +
                ", location='" + location + '\'' +
                ", username='" + username + '\'' +
                ", cancelled=" + cancelled +
                ", cancelledBy='" + cancelledBy + '\'' +
                ", cancelledDate=" + cancelledDate +
                ", reason='" + reason + '\'' +
                ", dateBanked=" + dateBanked +
                ", bankName='" + bankName + '\'' +
                ", sourceBank='" + sourceBank + '\'' +
                ", sourceBankName='" + sourceBankName + '\'' +
                ", sourceBankCode='" + sourceBankCode + '\'' +
                ", prepayment=" + prepayment +
                ", verified=" + verified +
                ", verifiedBy='" + verifiedBy + '\'' +
                ", verifyDate=" + verifyDate +
                ", banked='" + banked + '\'' +
                ", receiptStatus='" + receiptStatus + '\'' +
                ", printed=" + printed +
                ", processed=" + processed +
                ", appto='" + appto + '\'' +
                ", tpCode='" + tpCode + '\'' +
                ", claimedBy='" + claimedBy + '\'' +
                ", refunded='" + refunded + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", sectionCode='" + sectionCode + '\'' +
                ", homeCurrency='" + homeCurrency + '\'' +
                ", homeAmount=" + homeAmount +
                ", srCurrency='" + srCurrency + '\'' +
                ", srcAmount=" + srcAmount +
                ", exchangeRate=" + exchangeRate +
                ", financialCode=" + financialCode +
                ", financialPeriod=" + financialPeriod +
                ", allocated=" + allocated +
                ", allocatedAmount=" + allocatedAmount +
                ", accessCode='" + accessCode + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", studyMethodCode='" + studyMethodCode + '\'' +
                ", prCode='" + prCode + '\'' +
                ", chtCode='" + chtCode + '\'' +
                ", academicLevelCode='" + academicLevelCode + '\'' +
                ", campusCode='" + campusCode + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                ", accsetControl='" + accsetControl + '\'' +
                ", accountGlControl='" + accountGlControl + '\'' +
                ", strCode='" + strCode + '\'' +
                ", expired=" + expired +
                ", cmt='" + cmt + '\'' +
                ", transferedTo='" + transferedTo + '\'' +
                ", modeCode='" + modeCode + '\'' +
                ", accountExists=" + accountExists +
                ", reversed=" + reversed +
                '}';
    }
}
