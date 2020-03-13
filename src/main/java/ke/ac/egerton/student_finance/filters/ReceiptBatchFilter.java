package ke.ac.egerton.student_finance.filters;

public class ReceiptBatchFilter {

    private String batchId;
    private String username;
    private String batchDescription;

    public ReceiptBatchFilter() {
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBatchDescription() {
        return batchDescription;
    }

    public void setBatchDescription(String batchDescription) {
        this.batchDescription = batchDescription;
    }


}
