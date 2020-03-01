package ke.ac.egerton.student_finance.settings.accountsSetup.service;

import ke.ac.egerton.student_finance.settings.accountsSetup.models.SegmentMapping;
import ke.ac.egerton.student_finance.settings.accountsSetup.repository.SegmentMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SegmentMappingServiceImpl implements SegmentMappingService{

    @Autowired
    SegmentMappingRepository segmentMappingRepository;

    @Override
    public SegmentMapping saveSegmentMapping(SegmentMapping segmentMapping) {
        return segmentMappingRepository.save(segmentMapping);
    }

    @Override
    public SegmentMapping updateSegmentMapping(SegmentMapping segmentMapping) {
        return null;
    }

    @Override
    public List<SegmentMapping> getAllSegmentMapping() {
        return this.segmentMappingRepository.findAll();
    }

    @Override
    public SegmentMapping getSegmentMappingById(long id) {
        return this.segmentMappingRepository.findOne(id);
    }

    @Override
    public SegmentMapping getSegmentMappingByCode(String code) {
        return null;
    }

    @Override
    public void deleteSegmentMapping(long id) {

    }
}
