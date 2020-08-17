package ke.ac.egerton.student_finance.reports.models;

import ke.ac.egerton.student_finance.feeSegment.models.FeeSegment;
import org.springframework.util.Assert;


public class FeeSegmentResponse {


    private final String code;
    private final String description;

    public FeeSegmentResponse(FeeSegment feeSegment) {

        Assert.notNull(feeSegment, "Fee Segment cannot be null");
        code = feeSegment.getCode();
        description = feeSegment.getDescription();
    }


    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "FeeSegmentResponse{" +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
