package ke.ac.egerton.student_finance.settings.feeSetup.repositories;

import ke.ac.egerton.models.dao.academic.filters.AbstractFilter;
import ke.ac.egerton.student_finance.filters.ChargeItemFilter;
import ke.ac.egerton.student_finance.settings.feeSetup.models.ChargeItem;

import java.util.Map;

public class ChargeItemRepositoryImpl extends AbstractFilter<ChargeItemFilter, ChargeItem> {

    public ChargeItemRepositoryImpl(){
        super(ChargeItem.class);
    }
    public String getFetchQuery(){
        return "SELECT c FROM ChargeItem c";
    }
    public String getObjectAlias(){return "c";}

    @Override
    protected StringBuilder buildConstraints(ChargeItemFilter filter, Map<String, Object> parameters) {

        StringBuilder queryBuilder = new StringBuilder();

        if (hasValue(filter.getCode())) {
            addFilter(queryBuilder, "UPPER(c.code) LIKE UPPER(:code)");
            parameters.put("code", "%" + filter.getCode()+ "%");
        }
        if(hasValue(filter.getName())){
            addFilter(queryBuilder, "UPPER(c.name) LIKE UPPER(:name)");
            parameters.put("name", "%" + filter.getName()+"%");
        }
        return queryBuilder;
    }
}
