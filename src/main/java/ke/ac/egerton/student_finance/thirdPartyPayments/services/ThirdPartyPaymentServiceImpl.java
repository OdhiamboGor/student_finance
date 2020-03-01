package ke.ac.egerton.student_finance.thirdPartyPayments.services;

import ke.ac.egerton.student_finance.settings.thirdParty.models.Category;
import ke.ac.egerton.student_finance.settings.thirdParty.models.ThirdParty;
import ke.ac.egerton.student_finance.settings.thirdParty.repository.CategoryRepository;
import ke.ac.egerton.student_finance.settings.thirdParty.repository.ThirdPartyRepository;
import ke.ac.egerton.student_finance.settings.thirdParty.services.CategoryService;
import ke.ac.egerton.student_finance.thirdPartyPayments.models.ThirdPartyProcesses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ThirdPartyPaymentServiceImpl implements ThirdPartyPaymentService {

    @Autowired
    ThirdPartyRepository thirdPartiesRepository;

    @Autowired
    ThirdPartyPaymentService thirdPartyPaymentService;
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryService categoryService;

    @Transactional
    public List<ThirdPartyProcesses> loadThirdParty(String code) {
        return thirdPartyPaymentService.loadThirdPartyProcess(code);

    }

    @Override
    public List<ThirdPartyProcesses> loadThirdPartyProcess(String code) {
        return null;
    }

    @Override
    @Transactional
    public List<Category> listCategory() {
        return categoryRepository.findAll();

    }

}
