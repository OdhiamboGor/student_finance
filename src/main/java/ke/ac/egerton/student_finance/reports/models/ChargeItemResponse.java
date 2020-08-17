package ke.ac.egerton.student_finance.reports.models;

import ke.ac.egerton.student_finance.settings.feeSetup.models.ChargeItem;
import org.springframework.util.Assert;

public class ChargeItemResponse {

    private final String code;

    private final String name;


    public ChargeItemResponse(ChargeItem chargeItem) {
       Assert.notNull(chargeItem, "ChargeItem cannot be null");
       code = chargeItem.getCode();
       name = chargeItem.getName();
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ChargeItemResponse{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
