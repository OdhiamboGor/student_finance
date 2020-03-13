package ke.ac.egerton.student_finance.invoicing.repositories;

import ke.ac.egerton.models.dao.academic.filters.AbstractFilter;
import ke.ac.egerton.student_finance.filters.VerifyDocumentsFilter;
import ke.ac.egerton.student_finance.invoicing.models.VerifyDocuments;

import java.util.Map;

public class VerifyDocumentsRepositoryImpl extends AbstractFilter<VerifyDocumentsFilter, VerifyDocuments> {

    public VerifyDocumentsRepositoryImpl(){
        super(VerifyDocuments.class);
    }
    public String getFetchQuery(){
        return "SELECT v FROM VerifyDocuments v";
    }
    public String getObjectAlias(){return "v";}

    @Override
    protected StringBuilder buildConstraints(VerifyDocumentsFilter filter, Map<String, Object> parameters) {
        StringBuilder queryBuilder = new StringBuilder();

        if (hasValue(filter.getCustomerId())) {
            addFilter(queryBuilder, "UPPER(v.customerId) LIKE UPPER(:customerId)");
            parameters.put("customerId", "%" + filter.getCustomerId()+ "%");
        }
        if(hasValue(filter.getBatchDescription())){
            addFilter(queryBuilder, "UPPER(v.batchDescription) LIKE UPPER(:batchDescription)");
            parameters.put("batchDescription", "%" + filter.getBatchDescription()+"%");
        }
        /*if (hasValue(filter.getEntryNo())){
            addFilter(queryBuilder, "UPPER(v.entryNo) LIKE UPPER(:entryNo)");
            parameters.put("entryNo", "%" + filter.getEntryNo()+ "%");
        }*/
        if (hasValue(filter.getDocumentNumber())){
            addFilter(queryBuilder, "UPPER(v.documentNumber) LIKE UPPER(:documentNumber)");
            parameters.put("documentNumber", "%" + filter.getDocumentNumber() + "%");
        }
        if (hasValue(filter.getDocumentType())){
            addFilter(queryBuilder, "UPPER(v.documentType) LIKE UPPER(:documentType)");
            parameters.put("documentType", "%" + filter.getDocumentType() + "%");
        }
        if (hasValue(filter.getReference())){
            addFilter(queryBuilder, "UPPER(v.reference) LIKE UPPER(:reference)");
            parameters.put("reference", "%" + filter.getReference() + "%");
        }
        if (hasValue(filter.getProgrammeCode())){
            addFilter(queryBuilder, "UPPER(v.programmeCode) LIKE UPPER(:programmeCode)");
            parameters.put("programmeCode", "%" + filter.getProgrammeCode() + "%");
        }
        if (hasValue(filter.getDepartmentCode())){
            addFilter(queryBuilder, "UPPER(v.departmentCode) LIKE UPPER(:departmentCode)");
            parameters.put("departmentCode", "%" + filter.getDepartmentCode() + "%");
        }
        if (hasValue(filter.getStudentNumber())){
            addFilter(queryBuilder, "UPPER(v.studentNumber) LIKE UPPER(:studentNumber)");
            parameters.put("studentNumber", "%" + filter.getStudentNumber() + "%");
        }
        return queryBuilder;
    }
}
