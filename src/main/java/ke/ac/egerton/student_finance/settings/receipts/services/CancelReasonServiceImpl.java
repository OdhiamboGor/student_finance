package ke.ac.egerton.student_finance.settings.receipts.services;

import ke.ac.egerton.student_finance.settings.receipts.models.CancelReason;
import ke.ac.egerton.student_finance.settings.receipts.repositories.CancelReasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CancelReasonServiceImpl implements CancelReasonService{

    @Autowired
    CancelReasonRepository cancelReasonRepository;

    @Override
    public CancelReason saveCancelReason(CancelReason cancelReason) {
        return cancelReasonRepository.save(cancelReason);
    }

    @Override
    public CancelReason updateCancelReason(CancelReason cancelReason) {
        return null;
    }

    @Override
    public List<CancelReason> getAllCancelReason() {
        return this.cancelReasonRepository.findAll();
    }

    @Override
    public CancelReason getCancelReasonById(long id) {
        return this.cancelReasonRepository.findOne(id);
    }

    @Override
    public CancelReason getCancelReasonByCode(String code) {
        return null;
    }

    @Override
    public void deleteCancelReason(long id) {

    }

    @Override
    public void deleteCancelReason(CancelReason cancelReason) {

    }
}
