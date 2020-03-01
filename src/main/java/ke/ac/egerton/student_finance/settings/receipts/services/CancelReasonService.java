package ke.ac.egerton.student_finance.settings.receipts.services;

import ke.ac.egerton.student_finance.settings.receipts.models.CancelReason;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CancelReasonService {

    CancelReason saveCancelReason(CancelReason cancelReason);

    CancelReason updateCancelReason(CancelReason cancelReason);

    List<CancelReason> getAllCancelReason();

    CancelReason getCancelReasonById(long id);

    CancelReason getCancelReasonByCode(String code);

    void deleteCancelReason(long id);

    void deleteCancelReason(CancelReason cancelReason);
}
