package ke.ac.egerton.student_finance.settings.feeSetup.services;

import ke.ac.egerton.student_finance.settings.feeSetup.models.UnitOfMeasure;
import ke.ac.egerton.student_finance.settings.feeSetup.repositories.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Override
    public UnitOfMeasure saveUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        return unitOfMeasureRepository.save(unitOfMeasure);
    }

    @Override
    public UnitOfMeasure updateUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        return null;
    }

    @Override
    public List<UnitOfMeasure> getAllUnitOfMeasure() {
        return this.unitOfMeasureRepository.findAll();
    }

    @Override
    public UnitOfMeasure getUnitOfMeasureById(long id) {
        return this.unitOfMeasureRepository.findOne(id);
    }

    @Override
    public UnitOfMeasure getUnitOfMeasureByCode(String code) {
        return null;
    }

    @Override
    public void deleteUnitOfMeasure(long id) {

    }
}
