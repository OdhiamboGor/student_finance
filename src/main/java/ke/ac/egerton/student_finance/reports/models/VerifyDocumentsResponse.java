package ke.ac.egerton.student_finance.reports.models;

import ke.ac.egerton.student_finance.invoicing.models.VerifyDocuments;
import org.springframework.util.Assert;

public class VerifyDocumentsResponse {
    private String batchDescription;
    private Integer entryNo;
    private String customerId;
    private String documentNumber;
    private String documentType;
    private String reference;
    private String programmeCode;
    private String departmentCode;
    private String studentNumber;

    public VerifyDocumentsResponse(VerifyDocuments verifyDocuments){
        Assert.notNull(verifyDocuments, "No Document cannot be null");
        batchDescription = verifyDocuments.getBatchDescription();
        entryNo = verifyDocuments.getEntryNo();
        customerId = verifyDocuments.getCustomerId();
        documentNumber = verifyDocuments.getDocumentNumber();
        documentType = verifyDocuments.getDocumentType();
        reference = verifyDocuments.getReference();
        programmeCode = verifyDocuments.getProgrammeCode();
        departmentCode = verifyDocuments.getDepartmentCode();
        studentNumber = verifyDocuments.getStudentNumber();
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

    public String getProgrammeCode() {
        return programmeCode;
    }

    public void setProgrammeCode(String programmeCode) {
        this.programmeCode = programmeCode;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    @Override
    public String toString() {
        return "VerifyDocumentsResponse{" +
                "batchDescription='" + batchDescription + '\'' +
                ", entryNo=" + entryNo +
                ", customerId='" + customerId + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", documentType='" + documentType + '\'' +
                ", reference='" + reference + '\'' +
                ", programmeCode='" + programmeCode + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                '}';
    }
}
