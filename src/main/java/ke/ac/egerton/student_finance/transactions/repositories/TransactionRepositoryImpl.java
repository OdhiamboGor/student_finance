package ke.ac.egerton.student_finance.transactions.repositories;

import ke.ac.egerton.models.dao.academic.filters.AbstractFilter;
import ke.ac.egerton.student_finance.filters.ThirdPartyFilter;
import ke.ac.egerton.student_finance.filters.TransactionFilter;
import ke.ac.egerton.student_finance.settings.thirdParty.models.ThirdParty;
import ke.ac.egerton.student_finance.settings.thirdParty.repository.ThirdPartyRepository;
import ke.ac.egerton.student_finance.settings.thirdParty.repository.ThirdPartyRepositoryImpl;
import ke.ac.egerton.student_finance.transactions.models.Transaction;

import java.util.Map;

public class TransactionRepositoryImpl extends AbstractFilter<TransactionFilter, Transaction> {

    public TransactionRepositoryImpl(){super(Transaction.class);
    }
    public String getFetchQuery() {
        return "SELECT t FROM Transaction t";
    }

    public String getObjectAlias() {
        return "t";
    }

    @Override
    protected StringBuilder buildConstraints(TransactionFilter filter, Map<String, Object> parameters) {
        StringBuilder queryBuilder = new StringBuilder();

        if (hasValue(filter.getDocNo())) {
            addFilter(queryBuilder, "(UPPER(t.docNo) LIKE UPPER(:docNo)");
            parameters.put("docNo", "%" + filter.getDocNo() + "%");
        }

       /* if (hasValue(filter.getProgrammeCode())) {
            addFilter(queryBuilder, "UPPER(s.programme.code) = UPPER(:programmeCode)");
            parameters.put("programmeCode", filter.getProgrammeCode());
        }*/

        if (filter.getYearCode() != null) {
            addFilter(queryBuilder, "t.yearCode = :yearCode");
            parameters.put("yearCode", filter.getYearCode());
        }

        /*if (hasValue(filter.getCampusCode())) {
            addFilter(queryBuilder, "UPPER(s.studyCenter.code) LIKE UPPER(:campusCode)");
            parameters.put("campusCode", "%" + filter.getCampusCode() + "%");
        }

        if (hasValue(filter.getDepartmentCode())) {
            addFilter(queryBuilder, "UPPER(s.programme.department.code) = UPPER(:departmentCode)");
            parameters.put("departmentCode", filter.getDepartmentCode());
        }

        if (hasValue(filter.getFacultyCode())) {
            addFilter(queryBuilder, "UPPER(s.programme.department.faculty.code) = UPPER(:facultyCode)");
            parameters.put("facultyCode", filter.getFacultyCode());
        }

        if (hasValue(filter.getProgrammeCode())) {
            addFilter(queryBuilder, "UPPER(s.programme.studyLevel.code) = UPPER(:studyLevelCode)");
            parameters.put("studyLevelCode", filter.getStudyLevelCode());
        }
*/
        return queryBuilder;
    }
    }
