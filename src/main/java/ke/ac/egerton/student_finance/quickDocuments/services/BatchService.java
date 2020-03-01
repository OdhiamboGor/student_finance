package ke.ac.egerton.student_finance.quickDocuments.services;

import ke.ac.egerton.student_finance.quickDocuments.models.Batches;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BatchService {

    Batches saveBatch(Batches batches);

    Batches updateBatch(Batches batches);

    List<Batches> getAllBatch();

    Batches getBatchById(long id);

    Batches getBatchByCode(String code);

    void deleteBatch(String code);

    void deleteBatch(Batches batches);
}
