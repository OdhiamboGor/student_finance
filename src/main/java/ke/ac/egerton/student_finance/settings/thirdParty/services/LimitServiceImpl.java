package ke.ac.egerton.student_finance.settings.thirdParty.services;

import ke.ac.egerton.student_finance.settings.thirdParty.models.Limit;
import ke.ac.egerton.student_finance.settings.thirdParty.repository.LimitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LimitServiceImpl implements LimitService{

    @Autowired
    LimitRepository limitRepository;


    @Override
    public Limit saveLimit(Limit limit) {
        return limitRepository.save(limit);
    }

    @Override
    public Limit updateLimit(Limit limit) {
        return null;
    }

    @Override
    public List<Limit> getAllLimit() {
        return this.limitRepository.findAll();
    }

    @Override
    public Limit getLimitById(long id) {
        return this.limitRepository.findOne(id);
    }

    @Override
    public Limit getLimitByCode(String code) {
        return null;
    }

    @Override
    public void deleteLimit(Long id) {

    }
}
