package ke.ac.egerton.student_finance.quickDocuments.models;

import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

public class BatchEntry {

    @Id
    @GeneratedValue(generator = "SFINVBT")
    @GenericGenerator(name = "SFINVBT", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @Column(name = "BATCHNO")
    private Batches batch;
}
