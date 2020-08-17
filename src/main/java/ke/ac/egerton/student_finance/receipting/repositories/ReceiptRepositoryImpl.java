package ke.ac.egerton.student_finance.receipting.repositories;

import ke.ac.egerton.models.dao.academic.filters.AbstractFilter;
import ke.ac.egerton.student_finance.filters.ReceiptFilter;
import ke.ac.egerton.student_finance.receipting.models.Receipt;
import ke.ac.egerton.student_finance.receipting.models.ReceiptBatch;

import java.util.Map;


public class ReceiptRepositoryImpl extends AbstractFilter<ReceiptFilter, Receipt> {

    public ReceiptRepositoryImpl(){
        super(Receipt.class);
    }

    public String getFetchQuery() {
        return "SELECT r FROM Receipt r";
    }

    public String getObjectAlias() {
        return "r";
    }

    @Override
    protected StringBuilder buildConstraints(ReceiptFilter filter, Map<String, Object> parameters) {

        StringBuilder queryBuilder = new StringBuilder();

        if (hasValue(filter.getBatchId())) {
            addFilter(queryBuilder, "UPPER(r.batchId) LIKE UPPER(:batchId)");
            parameters.put("batchId", "%" + filter.getBatchId()+ "%");
        }
        if(hasValue(filter.getReceiptNumber())){
            addFilter(queryBuilder, "UPPER(r.receiptNumber) LIKE UPPER(:receiptNumber)");
            parameters.put("receiptNumber", "%" + filter.getReceiptNumber()+"%");
        }
        if(hasValue(filter.getCustomerId())){
            addFilter(queryBuilder, "UPPER(r.receiptFrom) LIKE UPPER(:receiptFrom)");
            parameters.put("receiptFrom", "%" + filter.getCustomerId()+"%");
        }
        return queryBuilder;
    }
}
