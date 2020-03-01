package ke.ac.egerton.student_finance.settings.coreSetup.services;

import ke.ac.egerton.student_finance.settings.coreSetup.models.Installment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InstallmentService {
    Installment saveInstallment(Installment installment);

    Installment updateInstallment(Installment installment);

    List< Installment > getAllInstallment();

    Installment getInstallmentById(long id);

    Installment getInstallmentByCode(String code);

    void deleteInstallment(long id);

}
