package ke.ac.egerton.student_finance.settings.receipts.services;

import ke.ac.egerton.student_finance.settings.receipts.models.ReversalReason;
import ke.ac.egerton.student_finance.settings.receipts.repositories.ReversalReasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReversalReasonServiceImpl implements ReversalReasonService {

    @Autowired
    ReversalReasonRepository reversalReasonRepository;

    @Override
    public ReversalReason saveReversalReason(ReversalReason reversalReason) {
        return reversalReasonRepository.save(reversalReason);
    }

    @Override
    public ReversalReason updateReversalReason(ReversalReason reversalReason) {
        return null;
    }

    @Override
    public List<ReversalReason> getAllReversalReason() {
        return this.reversalReasonRepository.findAll();
    }

    @Override
    public ReversalReason getReversalReasonById(long id) {
        return this.reversalReasonRepository.findOne(id);
    }

    @Override
    public ReversalReason getReversalReasonByCode(String code) {
        return null;
    }

    @Override
    public void deleteReversalReason(long id) {

    }

    @Override
    public void deleteReversalReason(ReversalReason reversalReason) {

    }
}
