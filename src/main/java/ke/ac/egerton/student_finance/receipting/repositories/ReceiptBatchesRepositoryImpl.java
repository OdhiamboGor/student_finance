package ke.ac.egerton.student_finance.receipting.repositories;

import ke.ac.egerton.models.dao.academic.filters.AbstractFilter;
import ke.ac.egerton.student_finance.filters.ReceiptBatchFilter;
import ke.ac.egerton.student_finance.receipting.models.ReceiptBatch;

import java.util.Map;

public class ReceiptBatchesRepositoryImpl extends AbstractFilter<ReceiptBatchFilter, ReceiptBatch> {

    public ReceiptBatchesRepositoryImpl(){
        super(ReceiptBatch.class);
    }

    public String getFetchQuery() {
        return "SELECT b FROM ReceiptBatch b";
    }

    public String getObjectAlias() {
        return "b";
    }

    @Override
    protected StringBuilder buildConstraints(ReceiptBatchFilter filter, Map<String, Object> parameters) {

        StringBuilder queryBuilder = new StringBuilder();
        if (hasValue(filter.getBatchId())) {
            addFilter(queryBuilder, "UPPER(b.batchId) LIKE UPPER(:batchId)");
            parameters.put("batchId", "%" + filter.getBatchId()+ "%");
        }
        if(hasValue(filter.getBatchDescription())){
            addFilter(queryBuilder, "UPPER(b.batchDescription) LIKE UPPER(:batchDescription)");
            parameters.put("batchDescription", "%" + filter.getBatchDescription()+"%");
        }
        if(hasValue(filter.getUsername())){
            addFilter(queryBuilder, "UPPER(b.username) LIKE UPPER(:username)");
            parameters.put("username", "%" + filter.getUsername()+"%");
        }
        return queryBuilder;
    }
}
