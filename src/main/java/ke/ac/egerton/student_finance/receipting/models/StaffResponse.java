package ke.ac.egerton.student_finance.receipting.models;

import ke.ac.egerton.models.Staff;
import org.springframework.util.Assert;

public class StaffResponse {
    private final String fullName;
    private final String payrollId;

    public StaffResponse(Staff staff) {
        Assert.notNull(staff, "Staff cannot be null");
        fullName = staff.getFullName();
        payrollId = staff.getPayrollId();
    }

    public String getFullName() {
        return fullName;
    }

    public String getPayrollId() {
        return payrollId;
    }

    @Override
    public String toString() {
        return "StaffResponse{" +
                "fullName='" + fullName + '\'' +
                ", payrollId='" + payrollId + '\'' +
                '}';
    }
}
