package ke.ac.egerton.student_finance.settings.accountsSetup.service;

import ke.ac.egerton.student_finance.settings.accountsSetup.models.SegmentMapping;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SegmentMappingService {

    SegmentMapping saveSegmentMapping(SegmentMapping segmentMapping);

    SegmentMapping updateSegmentMapping(SegmentMapping segmentMapping);

    List< SegmentMapping > getAllSegmentMapping();

    SegmentMapping getSegmentMappingById(long id);

    SegmentMapping getSegmentMappingByCode(String code);

    void deleteSegmentMapping(long id);
}
