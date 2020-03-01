package ke.ac.egerton.student_finance.settings.payment.services;

import ke.ac.egerton.student_finance.settings.payment.models.ImportColumn;
import ke.ac.egerton.student_finance.settings.payment.repository.ImportColumnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ImportColumnServiceImpl implements ImportColumnService{

    @Autowired
    ImportColumnRepository importColumnRepository;

    @Override
    public ImportColumn saveImportColumn(ImportColumn importColumn) {
        return importColumnRepository.save(importColumn);
    }

    @Override
    public ImportColumn updateImportColumn(ImportColumn importColumn) {
        return null;
    }

    @Override
    public List<ImportColumn> getAllImportColumn() {
        return this.importColumnRepository.findAll();
    }

    @Override
    public ImportColumn getImportColumnById(long id) {
        return this.importColumnRepository.findOne(id);
    }

    @Override
    public ImportColumn getImportColumnByCode(String code) {
        return null;
    }

    @Override
    public void deleteImportColumn(long id) {

    }

    @Override
    public void deleteImportColumn(ImportColumn importColumn) {

    }
}
