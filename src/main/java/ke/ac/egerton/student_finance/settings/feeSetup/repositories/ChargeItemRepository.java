package ke.ac.egerton.student_finance.settings.feeSetup.repositories;

import ke.ac.egerton.models.dao.academic.filters.Filterable;
import ke.ac.egerton.student_finance.filters.ChargeItemFilter;
import ke.ac.egerton.student_finance.filters.VerifyDocumentsFilter;
import ke.ac.egerton.student_finance.invoicing.models.VerifyDocuments;
import ke.ac.egerton.student_finance.settings.feeSetup.models.ChargeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChargeItemRepository extends JpaRepository<ChargeItem, Long>, Filterable<ChargeItemFilter, ChargeItem> {
    ChargeItem findByCode(String code);


}
