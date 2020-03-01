package ke.ac.egerton.student_finance.invoicing.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import ke.ac.egerton.models.academic.*;
import ke.ac.egerton.student_finance.invoicing.controllers.validation.InvoiceDetails;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "SFINVC")
public class Invoice extends AuditableEntity {

    @Id
    @GeneratedValue(generator = "SFINVC")
    @GenericGenerator(name = "SFINVC", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @Column(name = "STUDENTNUMBER")
    private String studentNumber;

    @Column(name = "SEGCODE")
    private String segCode;

    @Column(name = "SEGDESC")
    private String segDescription;

    @Column(name = "STUDACCOUNTNO")
    private String studentAccountNumber;

    @Column(name = "ACCEXIST")
    private Boolean accountExist;

    @Column(name = "ACADEMICYEAR")
    private String academicYear;

    @Column(name = "SEMSESSIONCODE")
    private String semesterCode;

    @Column(name = "AMOUNT")
    private int amount;

    @Column(name = "DOCNO")
    private String docNumber;

    @Column(name = "DOCDESC")
    private String documentDescription;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "DOCCATCODE")
    private String documentCategoryCode;

    @Column(name = "DOCTYPE")
    private String documentType;

    @Column(name = "DOCDATEF")
    private Date documentDate;

    @Column(name = "DOCDATEUF")
    private Integer documentDateUF;

    @Column(name = "DOCDATEUSR")
    private Date documentDateUSR;

    @Column(name = "TRMCODE")
    private String trmCode;

    @Column(name = "APPROVED")
    private Boolean approved;

    @Column(name = "POSTED")
    private Boolean posted;

    @Column(name = "ITMSD")
    private BigDecimal itemised;

    @Column(name = "ACCSETCODE")
    private String accSetCode;

    @Column(name = "DRACCT")
    private String drAcct;

    @Column(name = "ACCTGLCTRL")
    private String acctGlCtrl;

    @Column(name = "REVACCT")
    private String revAccount;

    @Column(name = "REVACCTGL")
    private String revAccTgl;

    @Column(name = "SECTIONCODE")
    private String sectionCode;

    @Column(name = "CATEGORYCODE")
    private String categoryCode;

    @Column(name = "STUDYMETHODCODE")
    private String studyMethodCode;

    @Column(name = "PRCODE")
    private String programmeCode;

    @Column(name = "CHTCODE")
    private String chtCode;

    @Column(name = "ACADLEVELCODE")
    private String academicLevelCode;

    @Column(name = "CAMPUSCODE")
    private String campusCode;

    @Column(name = "DEPARTMENTCODE")
    private String departmentCode;

    @Column(name = "HMCUR")
    private String homeCurrency;

    @Column(name = "HMAMT")
    private BigDecimal homeAmount;

    @Column(name = "SRCCUR")
    private String srcCurrency;

    @Column(name = "SRCAMT")
    private BigDecimal srcAmount;

    @Column(name = "EXCHRATE")
    private BigDecimal exchangeRate;

    @Column(name = "FYCODE")
    private Integer financialYearCode;

    @Column(name = "FYPERIOD")
    private Integer financialPeriod;

    @Column(name = "STRCODE")
    private String stringCode;

    @Column(name = "ACCSETSTRCODE")
    private String accSetStrCode;

    @Column(name = "REF")
    private String reference;

    @Column(name = "EXPD")
    private Boolean expired;

    @Column(name = "YEARCODE")
    private String yearCode;

    @Column(name = "PERIODCODE")
    private String periodCode;

    @Column(name = "IDNO")
    private Long idNo;

    @Column(name = "BATCHNO")
    private Long batchNo;

    public Invoice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InvoiceDetails toInvoiceDetails(){
        InvoiceDetails invoiceDetails = new InvoiceDetails();
        invoiceDetails.setId(this.id);
        invoiceDetails.setDocNumber(this.docNumber);
        invoiceDetails.setStudentNumber(this.studentNumber);
        invoiceDetails.setAmount(this.amount);
        invoiceDetails.setStatus(this.status);
        invoiceDetails.setApproved(this.status != null && this.status.equals("approved"));
        return invoiceDetails;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getSegCode() {
        return segCode;
    }

    public void setSegCode(String segCode) {
        this.segCode = segCode;
    }

    public String getSegDescription() {
        return segDescription;
    }

    public void setSegDescription(String segDescription) {
        this.segDescription = segDescription;
    }

    public String getStudentAccountNumber() {
        return studentAccountNumber;
    }

    public void setStudentAccountNumber(String studentAccountNumber) {
        this.studentAccountNumber = studentAccountNumber;
    }

    public Boolean getAccountExist() {
        return accountExist;
    }

    public void setAccountExist(Boolean accountExist) {
        this.accountExist = accountExist;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getSemesterCode() {
        return semesterCode;
    }

    public void setSemesterCode(String semesterCode) {
        this.semesterCode = semesterCode;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public String getDocumentDescription() {
        return documentDescription;
    }

    public void setDocumentDescription(String documentDescription) {
        this.documentDescription = documentDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDocumentCategoryCode() {
        return documentCategoryCode;
    }

    public void setDocumentCategoryCode(String documentCategoryCode) {
        this.documentCategoryCode = documentCategoryCode;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public Date getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(Date documentDate) {
        this.documentDate = documentDate;
    }

    public Integer getDocumentDateUF() {
        return documentDateUF;
    }

    public void setDocumentDateUF(Integer documentDateUF) {
        this.documentDateUF = documentDateUF;
    }

    public Date getDocumentDateUSR() {
        return documentDateUSR;
    }

    public void setDocumentDateUSR(Date documentDateUSR) {
        this.documentDateUSR = documentDateUSR;
    }

    public String getTrmCode() {
        return trmCode;
    }

    public void setTrmCode(String trmCode) {
        this.trmCode = trmCode;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Boolean getPosted() {
        return posted;
    }

    public void setPosted(Boolean posted) {
        this.posted = posted;
    }

    public BigDecimal getItemised() {
        return itemised;
    }

    public void setItemised(BigDecimal itemised) {
        this.itemised = itemised;
    }

    public String getAccSetCode() {
        return accSetCode;
    }

    public void setAccSetCode(String accSetCode) {
        this.accSetCode = accSetCode;
    }

    public String getDrAcct() {
        return drAcct;
    }

    public void setDrAcct(String drAcct) {
        this.drAcct = drAcct;
    }

    public String getAcctGlCtrl() {
        return acctGlCtrl;
    }

    public void setAcctGlCtrl(String acctGlCtrl) {
        this.acctGlCtrl = acctGlCtrl;
    }

    public String getRevAccount() {
        return revAccount;
    }

    public void setRevAccount(String revAccount) {
        this.revAccount = revAccount;
    }

    public String getRevAccTgl() {
        return revAccTgl;
    }

    public void setRevAccTgl(String revAccTgl) {
        this.revAccTgl = revAccTgl;
    }

    public String getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(String sectionCode) {
        this.sectionCode = sectionCode;
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

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public int getFinancialYearCode() {
        return financialYearCode;
    }

    public void setFinancialYearCode(int financialYearCode) {
        this.financialYearCode = financialYearCode;
    }

    public void setFinancialYearCode(Integer financialYearCode) {
        this.financialYearCode = financialYearCode;
    }

    public Integer getFinancialPeriod() {
        return financialPeriod;
    }

    public void setFinancialPeriod(Integer financialPeriod) {
        this.financialPeriod = financialPeriod;
    }

    public String getStringCode() {
        return stringCode;
    }

    public void setStringCode(String stringCode) {
        this.stringCode = stringCode;
    }

    public String getAccSetStrCode() {
        return accSetStrCode;
    }

    public void setAccSetStrCode(String accSetStrCode) {
        this.accSetStrCode = accSetStrCode;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Boolean getExpired() {
        return expired;
    }

    public void setExpired(Boolean expired) {
        this.expired = expired;
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

    public Long getIdNo() {
        return idNo;
    }

    public void setIdNo(Long idNo) {
        this.idNo = idNo;
    }

    public Long getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(Long batchNo) {
        this.batchNo = batchNo;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", studentNumber='" + studentNumber + '\'' +
                ", segCode='" + segCode + '\'' +
                ", segDescription='" + segDescription + '\'' +
                ", studentAccountNumber='" + studentAccountNumber + '\'' +
                ", accountExist=" + accountExist +
                ", academicYear='" + academicYear + '\'' +
                ", semesterCode='" + semesterCode + '\'' +
                ", amount=" + amount +
                ", docNumber='" + docNumber + '\'' +
                ", documentDescription='" + documentDescription + '\'' +
                ", status='" + status + '\'' +
                ", documentCategoryCode='" + documentCategoryCode + '\'' +
                ", documentType='" + documentType + '\'' +
                ", documentDate=" + documentDate +
                ", documentDateUF=" + documentDateUF +
                ", documentDateUSR=" + documentDateUSR +
                ", trmCode='" + trmCode + '\'' +
                ", approved=" + approved +
                ", posted=" + posted +
                ", itemised=" + itemised +
                ", accSetCode='" + accSetCode + '\'' +
                ", drAcct='" + drAcct + '\'' +
                ", acctGlCtrl='" + acctGlCtrl + '\'' +
                ", revAccount='" + revAccount + '\'' +
                ", revAccTgl='" + revAccTgl + '\'' +
                ", sectionCode='" + sectionCode + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", studyMethodCode='" + studyMethodCode + '\'' +
                ", programmeCode='" + programmeCode + '\'' +
                ", chtCode='" + chtCode + '\'' +
                ", academicLevelCode='" + academicLevelCode + '\'' +
                ", campusCode='" + campusCode + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                ", homeCurrency='" + homeCurrency + '\'' +
                ", homeAmount=" + homeAmount +
                ", srcCurrency='" + srcCurrency + '\'' +
                ", srcAmount=" + srcAmount +
                ", exchangeRate=" + exchangeRate +
                ", financialYearCode=" + financialYearCode +
                ", financialPeriod=" + financialPeriod +
                ", stringCode='" + stringCode + '\'' +
                ", accSetStrCode='" + accSetStrCode + '\'' +
                ", reference='" + reference + '\'' +
                ", expired=" + expired +
                ", yearCode='" + yearCode + '\'' +
                ", periodCode='" + periodCode + '\'' +
                ", idNo=" + idNo +
                ", batchNo=" + batchNo +
                '}';
    }
}


