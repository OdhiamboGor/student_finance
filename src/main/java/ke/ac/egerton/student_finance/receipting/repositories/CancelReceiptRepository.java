package ke.ac.egerton.student_finance.receipting.repositories;

import ke.ac.egerton.student_finance.receipting.models.CancelReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CancelReceiptRepository extends JpaRepository<CancelReceipt, Long> {

    @Transactional
    @Modifying
    @Query("update Receipt r set r.receiptSstatus = :status where r.receiptNumber = :id")
    void updateReceiptStatus(@Param("status") String status, @Param("id") String id);
}
