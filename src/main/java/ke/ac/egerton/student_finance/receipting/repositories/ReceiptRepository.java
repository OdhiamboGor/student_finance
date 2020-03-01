package ke.ac.egerton.student_finance.receipting.repositories;

import ke.ac.egerton.student_finance.receipting.models.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

    Receipt findByReceiptNumber(String receiptNumber);




}
