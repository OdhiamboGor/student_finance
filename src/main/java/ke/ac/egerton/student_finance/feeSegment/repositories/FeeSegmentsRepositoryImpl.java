package ke.ac.egerton.student_finance.feeSegment.repositories;

import ke.ac.egerton.models.dao.academic.filters.AbstractFilter;
import ke.ac.egerton.student_finance.feeSegment.models.FeeSegment;
import ke.ac.egerton.student_finance.filters.FeeSegmentFilter;


import java.util.Map;

public class FeeSegmentsRepositoryImpl extends AbstractFilter<FeeSegmentFilter, FeeSegment> {

    public FeeSegmentsRepositoryImpl(){
        super(FeeSegment.class);
    }
    public String getFetchQuery(){
        return "SELECT f FROM FeeSegment f";
    }
    public String getObjectAlias(){return "f";}


    @Override
    protected StringBuilder buildConstraints(FeeSegmentFilter filter, Map<String, Object> parameters) {

        StringBuilder queryBuilder = new StringBuilder();

        if (hasValue(filter.getCode())) {
            addFilter(queryBuilder, "UPPER(f.code) LIKE UPPER(:code)");
            parameters.put("code", "%" + filter.getCode()+ "%");
        }
        if(hasValue(filter.getDescription())){
            addFilter(queryBuilder, "UPPER(f.description) LIKE UPPER(:description)");
            parameters.put("description", "%" + filter.getDescription()+"%");
        }

        return queryBuilder;
    }
}
