package ke.ac.egerton.student_finance.settings.feeSetup.repositories;

import ke.ac.egerton.student_finance.settings.feeSetup.models.ChargeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargeItemRepository extends JpaRepository<ChargeItem, Long> {
    ChargeItem findByCode(String code);
}
