package ke.ac.egerton.student_finance.reports.models;

import ke.ac.egerton.student_finance.receipting.models.Receipt;
import org.springframework.util.Assert;

import java.util.Date;

public class ReceiptResponse {

    private String batchId;
    private String receiptNumber;
    private String customerId;



    public  ReceiptResponse(Receipt receipt){
        Assert.notNull(receipt, "Batch cannot be null");
        batchId = receipt.getBatchId();
        receiptNumber = receipt.getReceiptNumber();
        customerId = receipt.getCustomerId();
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
