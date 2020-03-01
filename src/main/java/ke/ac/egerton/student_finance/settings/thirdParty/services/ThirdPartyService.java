package ke.ac.egerton.student_finance.settings.thirdParty.services;

import ke.ac.egerton.student_finance.settings.thirdParty.models.ThirdParty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ThirdPartyService {

    ThirdParty saveThirdParty(ThirdParty thirdParty);

    ThirdParty updateThirdParty(ThirdParty thirdParty);

    List< ThirdParty > getAllThirdParty();

    ThirdParty getThirdPartyById(long id);

    ThirdParty getThirdPartyByCode(String code);

    void deleteThirdParty(Long id);

    void deleteThirdParty(ThirdParty thirdParty);
}
