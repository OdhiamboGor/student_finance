package ke.ac.egerton.student_finance.reports.models;

import javax.persistence.Column;

public class ChargeItemReport {

    private String code;

    private String name;

    public ChargeItemReport() {
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
        return "ChargeItemReport{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
