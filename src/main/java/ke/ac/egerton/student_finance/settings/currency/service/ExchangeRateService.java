package ke.ac.egerton.student_finance.settings.currency.service;

import ke.ac.egerton.student_finance.settings.currency.model.ExchangeRate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExchangeRateService {
    ExchangeRate saveExchangeRate(ExchangeRate exchangeRate);

    ExchangeRate updateExchangeRate(ExchangeRate exchangeRate);

    List< ExchangeRate > getAllExchangeRate();

    ExchangeRate getExchangeRateById(long id);

    void deleteExchangeRate(Long id);
}
