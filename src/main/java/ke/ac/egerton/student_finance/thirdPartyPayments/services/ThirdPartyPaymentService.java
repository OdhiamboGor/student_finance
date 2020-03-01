package ke.ac.egerton.student_finance.thirdPartyPayments.services;


import ke.ac.egerton.student_finance.settings.thirdParty.models.Category;
import ke.ac.egerton.student_finance.thirdPartyPayments.models.ThirdPartyProcesses;

import java.util.List;

public interface ThirdPartyPaymentService {

    public List<ThirdPartyProcesses> loadThirdPartyProcess(String code);

    public List<Category> listCategory();

}

