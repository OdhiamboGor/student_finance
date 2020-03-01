package ke.ac.egerton.student_finance.quickDocuments.services;

import ke.ac.egerton.student_finance.quickDocuments.models.Batches;
import ke.ac.egerton.student_finance.quickDocuments.repositories.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BatchServiceImpl implements BatchService{


    @Autowired
    BatchRepository batchRepository;

    @Override
    public Batches saveBatch(Batches batches) {

        return batchRepository.save(batches);
    }

    @Override
    public Batches updateBatch(Batches batches) {

        return this.batchRepository.save(batches);
    }

    @Override
    public List<Batches> getAllBatch() {
        return this.batchRepository.findAll();
    }

    @Override
    public Batches getBatchById(long id) {
        return this.batchRepository.findOne(id);
    }

    @Override
    public Batches getBatchByCode(String code) {
        return null;
    }

    @Override
    public void deleteBatch(String code) {

    }

    @Override
    public void deleteBatch(Batches batches) {

    }
}
