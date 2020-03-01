package ke.ac.egerton.student_finance.settings.currency.service;

import ke.ac.egerton.student_finance.settings.currency.model.ExchangeRate;
import ke.ac.egerton.student_finance.settings.currency.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExchangeRateServiceImpl implements ExchangeRateService {
    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @Override
    public ExchangeRate saveExchangeRate(ExchangeRate exchangeRate) {
        return exchangeRateRepository.save(exchangeRate);
    }

    @Override
    public ExchangeRate updateExchangeRate(ExchangeRate exchangeRate) {
        return null;
    }

    @Override
    public List<ExchangeRate> getAllExchangeRate() {
        return this.exchangeRateRepository.findAll();
    }

    @Override
    public ExchangeRate getExchangeRateById(long id) {
        return this.exchangeRateRepository.findOne(id);
    }

    @Override
    public void deleteExchangeRate(Long id) {

    }
}
