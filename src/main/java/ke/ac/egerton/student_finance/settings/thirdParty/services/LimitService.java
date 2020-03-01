package ke.ac.egerton.student_finance.settings.thirdParty.services;

import ke.ac.egerton.student_finance.settings.thirdParty.models.Limit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LimitService {

    Limit saveLimit(Limit limit);

    Limit updateLimit(Limit limit);

    List< Limit > getAllLimit();

    Limit getLimitById(long id);

    Limit getLimitByCode(String code);

    void deleteLimit(Long id);
}
