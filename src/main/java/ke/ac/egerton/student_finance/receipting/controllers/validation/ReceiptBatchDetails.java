package ke.ac.egerton.student_finance.receipting.controllers.validation;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ReceiptBatchDetails {

    //private Long id;
    private String userId;
    private String batchDate;
    private Long batchEnd;
    private String batchDescription;
    private String username;

    /*public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
*/

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBatchDate() {
        return batchDate;
    }

    public void setBatchDate(String batchDate) {
        this.batchDate = batchDate;
    }

    public Long getBatchEnd() {
        return batchEnd;
    }

    public void setBatchEnd(Long batchEnd) {
        this.batchEnd = batchEnd;
    }

    public String getBatchDescription() {
        return batchDescription;
    }

    public void setBatchDescription(String batchDescription) {
        this.batchDescription = batchDescription;
    }


}
