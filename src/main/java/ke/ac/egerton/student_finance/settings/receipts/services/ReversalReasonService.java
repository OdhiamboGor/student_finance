package ke.ac.egerton.student_finance.settings.receipts.services;

import ke.ac.egerton.student_finance.settings.receipts.models.ReversalReason;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReversalReasonService {

    ReversalReason saveReversalReason(ReversalReason reversalReason);

    ReversalReason updateReversalReason(ReversalReason reversalReason);

    List<ReversalReason> getAllReversalReason();

    ReversalReason getReversalReasonById(long id);

    ReversalReason getReversalReasonByCode(String code);

    void deleteReversalReason(long id);

    void deleteReversalReason(ReversalReason reversalReason);
}
