package ke.ac.egerton.student_finance.thirdPartyPayments.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface HelbImportsService {

    boolean uploadHelb(MultipartFile file);
}
