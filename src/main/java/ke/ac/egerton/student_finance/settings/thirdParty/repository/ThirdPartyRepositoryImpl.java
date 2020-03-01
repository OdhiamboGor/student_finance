package ke.ac.egerton.student_finance.settings.thirdParty.repository;

import ke.ac.egerton.models.Student;
import ke.ac.egerton.models.dao.StudentFilter;
import ke.ac.egerton.models.dao.academic.filters.AbstractFilter;
import ke.ac.egerton.student_finance.filters.ThirdPartyFilter;
import ke.ac.egerton.student_finance.settings.thirdParty.models.ThirdParty;

import java.util.Map;

public class ThirdPartyRepositoryImpl extends AbstractFilter <ThirdPartyFilter, ThirdParty>{

    public ThirdPartyRepositoryImpl() {
        super(ThirdParty.class);
    }
    public String getFetchQuery(){
        return "SELECT t FROM ThirdParty t";
    }
    public String getObjectAlias(){
        return "t";
    }
    @Override
    protected StringBuilder buildConstraints(ThirdPartyFilter filter, Map<String, Object> parameters) {
        StringBuilder queryBuilder = new StringBuilder();
        if (hasValue(filter.getCode())){
            addFilter(queryBuilder, "(UPPER(t.code) LIKE UPPER(:code))");


    }
        return queryBuilder;
}


        }
