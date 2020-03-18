package ke.ac.egerton.student_finance.filters;

public class FeeSegmentFilter {

    private String code;
    private String description;

    public FeeSegmentFilter() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "FeeSegmentFilter{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
