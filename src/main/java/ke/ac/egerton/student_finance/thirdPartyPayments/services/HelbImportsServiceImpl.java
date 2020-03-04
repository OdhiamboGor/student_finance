package ke.ac.egerton.student_finance.thirdPartyPayments.services;

import ke.ac.egerton.student_finance.thirdPartyPayments.repositories.HelbImportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HelbImportsServiceImpl implements HelbImportsService{

    @Autowired
    private HelbImportsRepository helbImportsRepository;
}
