package ke.ac.egerton.student_finance.filters;

public class ChargeItemFilter {

    private String code;

    private String name;

    public ChargeItemFilter() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ChargeItemFilter{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

