package ke.ac.egerton.student_finance.settings.payment.services;

import ke.ac.egerton.student_finance.settings.payment.models.ImportColumn;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ImportColumnService {

    ImportColumn saveImportColumn(ImportColumn importColumn);

    ImportColumn updateImportColumn(ImportColumn importColumn);

    List<ImportColumn> getAllImportColumn();

    ImportColumn getImportColumnById(long id);

    ImportColumn getImportColumnByCode(String code);

    void deleteImportColumn(long id);

    void deleteImportColumn(ImportColumn importColumn);
}
