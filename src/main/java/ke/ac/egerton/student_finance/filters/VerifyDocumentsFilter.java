package ke.ac.egerton.student_finance.filters;

public class VerifyDocumentsFilter {

    private String batchDescription;
    private Integer entryNo;
    private String customerId;
    private String documentNumber;
    private String documentType;
    private String reference;
    private String programmeCode;
    private String departmentCode;
    private String studentNumber;

    public VerifyDocumentsFilter() {
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
        return "VerifyDocumentsFilter{" +
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
