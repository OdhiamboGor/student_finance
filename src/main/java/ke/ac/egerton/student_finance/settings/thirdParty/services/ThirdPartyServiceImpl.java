package ke.ac.egerton.student_finance.settings.thirdParty.services;

import ke.ac.egerton.student_finance.settings.thirdParty.models.ThirdParty;
import ke.ac.egerton.student_finance.settings.thirdParty.repository.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ThirdPartyServiceImpl implements ThirdPartyService{

    @Autowired
    ThirdPartyRepository thirdPartyRepository;


    @Override
    public ThirdParty saveThirdParty(ThirdParty thirdParty) {
        return thirdPartyRepository.save(thirdParty);
    }

    @Override
    public ThirdParty updateThirdParty(ThirdParty thirdParty) {
        return null;
    }

    @Override
    public List<ThirdParty> getAllThirdParty() {
        return this.thirdPartyRepository.findAll();
    }

    @Override
    public ThirdParty getThirdPartyById(long id) {
        return thirdPartyRepository.findOne(id);
    }

    @Override
    public ThirdParty getThirdPartyByCode(String code) {
        return this.thirdPartyRepository.findByCode(code);
    }

    @Override
    public void deleteThirdParty(Long id) {

    }

    @Override
    public void deleteThirdParty(ThirdParty thirdParty) {

    }
}
