package ke.ac.egerton.student_finance.filters;

public class CategoryFilter {


    private String code;
    private String name;

    public CategoryFilter() {
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
        return "CategoryFilter{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
