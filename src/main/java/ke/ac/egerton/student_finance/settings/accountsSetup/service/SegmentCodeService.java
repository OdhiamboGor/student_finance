package ke.ac.egerton.student_finance.settings.accountsSetup.service;

import ke.ac.egerton.student_finance.settings.accountsSetup.models.SegmentCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SegmentCodeService {

    SegmentCode saveSegmentCode(SegmentCode segmentCode);

    SegmentCode updateSegmentCode(SegmentCode segmentCode);

    List< SegmentCode > getAllSegmentCode();

    SegmentCode getSegmentCodeById(long id);

    SegmentCode getSegmentCodeByCode(String code);

    void deleteSegmentCode(long id);
}
