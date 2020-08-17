package ke.ac.egerton.student_finance.invoicing.controllers.validation;

import java.math.BigDecimal;
import java.util.Date;

public class InvoiceDetails {

    private Long id;
    private String studentNumber;
    private String segCode;
    private String segDescription;
    private String studentAccountNumber;
    private Boolean accountExist;
    private String academicYear;
    private String semesterCode;
    private int amount;
    private String docNumber;
    private String documentDescription;
    private String status;
    private String documentCategoryCode;
    private String documentType;
    private Date documentDate;
    private Integer documentDateUF;
    private Date documentDateUSR;
    private String trmCode;
    private boolean approved = false;
    private Boolean posted;
    private BigDecimal itemised;
    private String accSetCode;
    private String drAcct;
    private String acctGlCtrl;
    private String revAccount;
    private String revAccTgl;
    private String sectionCode;
    private String categoryCode;
    private String studyMethodCode;
    private String programmeCode;
    private String chtCode;
    private String academicLevelCode;
    private String campusCode;
    private String departmentCode;
    private String homeCurrency;
    private BigDecimal homeAmount;
    private String srcCurrency;
    private BigDecimal srcAmount;
    private BigDecimal exchangeRate;
    private Integer financialYearCode;
    private Integer financialPeriod;
    private String stringCode;
    private String accSetStrCode;
    private String reference;
    private Boolean expired;
    private String yearCode;
    private String periodCode;
    private Long idNo;
    private Long batchNo;

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
