package ke.ac.egerton.student_finance.invoicing.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "SFOBL")
public class VerifyDocuments extends AuditableEntity {

  /*
    @GeneratedValue(generator = "SFOBL")
    @GenericGenerator(name = "SFOBL", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;
*/
    @Column(name="BATCHNO")
    @NotNull
    private Long batchNo;
    @Column(name="BATCHDESC")
    @NotNull
    private String batchDescription;
    @Column(name="ENTRY")
    @NotNull
    private Integer entryNo;
    @Column(name="IDCUST")
    @NotNull
    private String customerId;
    @Column(name="SOURCE")
    @NotNull
    private String source;
    @Column(name="ENTRYDATE")
    @NotNull
    private Date entryDate;
    @Column(name="ENTRYTOTAL")
    @NotNull
    private BigDecimal entryTotal;
    @Id
    @Column(name="DOCNO")
    @NotNull
    private String documentNumber;
    @Column(name="DOCTYPE")
    @NotNull
    private String documentType;
    @Column(name="REFERENCE")
    @NotNull
    private String reference;
    @Column(name="GLPOST")
    private Integer glPost;
    @Column(name="SECTIONCODE")
    private String sectionCode;
    @Column(name="DRACCT")
    private String drAccount;
    @Column(name="BKACCT")
    private String bkAccount;
    @Column(name="BANKCODE")
    private String bankCode;
    @Column(name="HMCUR")
    private String homeCurrency;
    @Column(name="HMAMT")
    private BigDecimal homeAmount;
    @Column(name="SRCCUR")
    private String sourceCurrency;
    @Column(name="SRCAMT")
    private BigDecimal sourceAmount;
    @Column(name="EXCHRATE")
    private BigDecimal exchangeRate;
    @Column(name="FYCODE")
    private Integer financialYearCode;
    @Column(name="FYPERIOD")
    private Integer getFinancialYearPeriod;
    @Column(name="ACCSETCODE")
    private String accountSetCode;
    @Column(name="CATEGORYCODE")
    private String categoryCode;
    @Column(name="STUDYMETHODCODE")
    private String studyMethodCode;
    @Column(name="PRCODE")
    private String programmeCode;
    @Column(name="CHTCODE")
    private String chtCode;
    @Column(name="ACADLEVELCODE")
    private String academicLevelCode;
    @Column(name="CAMPUSCODE")
    private String campusCode;
    @Column(name="DEPARTMENTCODE")
    private String departmentCode;
    @Column(name="SEQ")
    private Long sequence;
    @Column(name="ACCTGLCTRL")
    private String accountGLControl;
    @Column(name="STRCODE")
    private String strCode;
    @Column(name="STUDENTNUMBER")
    @NotNull
    private String studentNumber;
    @Column(name="DOCSTATUS")
    private Boolean documentStatus;
    @Column(name="ACCTEXISTS")
    private Boolean accountExist;
    @Column(name="UPDATED")
    private Boolean updated;

    public VerifyDocuments() {
    }

  /*  public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/

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

    public Integer getEntryNo() {
        return entryNo;
    }

    public void setEntryNo(Integer entryNo) {
        this.entryNo = entryNo;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public BigDecimal getEntryTotal() {
        return entryTotal;
    }

    public void setEntryTotal(BigDecimal entryTotal) {
        this.entryTotal = entryTotal;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getGlPost() {
        return glPost;
    }

    public void setGlPost(Integer glPost) {
        this.glPost = glPost;
    }

    public String getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(String sectionCode) {
        this.sectionCode = sectionCode;
    }

    public String getDrAccount() {
        return drAccount;
    }

    public void setDrAccount(String drAccount) {
        this.drAccount = drAccount;
    }

    public String getBkAccount() {
        return bkAccount;
    }

    public void setBkAccount(String bkAccount) {
        this.bkAccount = bkAccount;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
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

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public BigDecimal getSourceAmount() {
        return sourceAmount;
    }

    public void setSourceAmount(BigDecimal sourceAmount) {
        this.sourceAmount = sourceAmount;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Integer getFinancialYearCode() {
        return financialYearCode;
    }

    public void setFinancialYearCode(Integer financialYearCode) {
        this.financialYearCode = financialYearCode;
    }

    public Integer getGetFinancialYearPeriod() {
        return getFinancialYearPeriod;
    }

    public void setGetFinancialYearPeriod(Integer getFinancialYearPeriod) {
        this.getFinancialYearPeriod = getFinancialYearPeriod;
    }

    public String getAccountSetCode() {
        return accountSetCode;
    }

    public void setAccountSetCode(String accountSetCode) {
        this.accountSetCode = accountSetCode;
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

    public String getProgrammeCode() {
        return programmeCode;
    }

    public void setProgrammeCode(String programmeCode) {
        this.programmeCode = programmeCode;
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

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    public String getAccountGLControl() {
        return accountGLControl;
    }

    public void setAccountGLControl(String accountGLControl) {
        this.accountGLControl = accountGLControl;
    }

    public String getStrCode() {
        return strCode;
    }

    public void setStrCode(String strCode) {
        this.strCode = strCode;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Boolean getDocumentStatus() {
        return documentStatus;
    }

    public void setDocumentStatus(Boolean documentStatus) {
        this.documentStatus = documentStatus;
    }

    public Boolean getAccountExist() {
        return accountExist;
    }

    public void setAccountExist(Boolean accountExist) {
        this.accountExist = accountExist;
    }

    public Boolean getUpdated() {
        return updated;
    }

    public void setUpdated(Boolean updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "VerifyDocuments{" +
              /*  "id=" + id +*/
                ", batchNo=" + batchNo +
                ", batchDescription='" + batchDescription + '\'' +
                ", entryNo=" + entryNo +
                ", customerId='" + customerId + '\'' +
                ", source='" + source + '\'' +
                ", entryDate=" + entryDate +
                ", entryTotal=" + entryTotal +
                ", documentNumber='" + documentNumber + '\'' +
                ", documentType='" + documentType + '\'' +
                ", reference='" + reference + '\'' +
                ", glPost=" + glPost +
                ", sectionCode='" + sectionCode + '\'' +
                ", drAccount='" + drAccount + '\'' +
                ", bkAccount='" + bkAccount + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", homeCurrency='" + homeCurrency + '\'' +
                ", homeAmount=" + homeAmount +
                ", sourceCurrency='" + sourceCurrency + '\'' +
                ", sourceAmount=" + sourceAmount +
                ", exchangeRate=" + exchangeRate +
                ", financialYearCode=" + financialYearCode +
                ", getFinancialYearPeriod=" + getFinancialYearPeriod +
                ", accountSetCode='" + accountSetCode + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", studyMethodCode='" + studyMethodCode + '\'' +
                ", programmeCode='" + programmeCode + '\'' +
                ", chtCode='" + chtCode + '\'' +
                ", academicLevelCode='" + academicLevelCode + '\'' +
                ", campusCode='" + campusCode + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                ", sequence=" + sequence +
                ", accountGLControl='" + accountGLControl + '\'' +
                ", strCode='" + strCode + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", documentStatus=" + documentStatus +
                ", accountExist=" + accountExist +
                ", updated=" + updated +
                '}';
    }
}
