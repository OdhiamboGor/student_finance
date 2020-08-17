package ke.ac.egerton.student_finance.reports.models;

import ke.ac.egerton.student_finance.receipting.models.ReceiptBatch;
import org.springframework.util.Assert;

public class BatchResponse {

    private final String batchId;
    private final String batchDescription;
    private final String userName;

    public BatchResponse(ReceiptBatch receiptBatch) {

        Assert.notNull(receiptBatch, "Batch cannot be null");
        batchId = receiptBatch.getBatchId();
        batchDescription = receiptBatch.getBatchDescription();
        userName = receiptBatch.getUsername();

    }

    public String getBatchId() {
        return batchId;
    }

    public String getBatchDescription() {
        return batchDescription;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "BatchResponse{" +
                "batchId='" + batchId + '\'' +
                ", batchDescription='" + batchDescription + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
