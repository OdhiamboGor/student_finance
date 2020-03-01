package ke.ac.egerton.student_finance.settings.accountsSetup.service;

import ke.ac.egerton.student_finance.settings.accountsSetup.models.SegmentCode;
import ke.ac.egerton.student_finance.settings.accountsSetup.repository.SegmentCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SegmentCodeServiceImpl implements SegmentCodeService {

    @Autowired
    SegmentCodeRepository segmentCodeRepository;


    @Override
    public SegmentCode saveSegmentCode(SegmentCode segmentCode) {
        return segmentCodeRepository.save(segmentCode);
    }

    @Override
    public SegmentCode updateSegmentCode(SegmentCode segmentCode) {
        return null;
    }

    @Override
    public List<SegmentCode> getAllSegmentCode() {
        return this.segmentCodeRepository.findAll();
    }

    @Override
    public SegmentCode getSegmentCodeById(long id) {
        return this.segmentCodeRepository.findOne(id);
    }

    @Override
    public SegmentCode getSegmentCodeByCode(String code) {
        return null;
    }

    @Override
    public void deleteSegmentCode(long id) {

    }
}
