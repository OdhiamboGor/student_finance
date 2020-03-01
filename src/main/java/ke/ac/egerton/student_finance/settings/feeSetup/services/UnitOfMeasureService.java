package ke.ac.egerton.student_finance.settings.feeSetup.services;

import ke.ac.egerton.student_finance.settings.feeSetup.models.UnitOfMeasure;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UnitOfMeasureService {

    UnitOfMeasure saveUnitOfMeasure(UnitOfMeasure unitOfMeasure);

    UnitOfMeasure updateUnitOfMeasure(UnitOfMeasure unitOfMeasure);

    List<UnitOfMeasure> getAllUnitOfMeasure();

    UnitOfMeasure getUnitOfMeasureById(long id);

    UnitOfMeasure getUnitOfMeasureByCode(String code);

    void deleteUnitOfMeasure(long id);
}
