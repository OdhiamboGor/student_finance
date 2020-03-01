package ke.ac.egerton.student_finance.settings.coreSetup.services;

import ke.ac.egerton.student_finance.settings.coreSetup.models.Installment;
import ke.ac.egerton.student_finance.settings.coreSetup.repository.InstallmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InstallmentServiceImpl implements InstallmentService {

    //Autowired Repositories
    @Autowired
    InstallmentRepository installmentRepository;


    @Override
    public Installment saveInstallment(Installment installment) {
        return installmentRepository.save(installment);
    }

    @Override
    public Installment updateInstallment(Installment installment) {
        return null;
    }

    @Override
    public List<Installment> getAllInstallment() {
        return this.installmentRepository.findAll();
    }

    @Override
    public Installment getInstallmentById(long id) {
        return this.installmentRepository.findOne(id);
    }

    @Override
    public Installment getInstallmentByCode(String code) {
        return null;
    }

    @Override
    public void deleteInstallment(long id) {

    }
}
