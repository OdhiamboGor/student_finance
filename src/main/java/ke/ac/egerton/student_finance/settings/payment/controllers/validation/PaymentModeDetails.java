package ke.ac.egerton.student_finance.settings.payment.controllers.validation;

public class PaymentModeDetails {

    private Long id;
    private String sysCode;
    private String code;
    private String name;
    private String reference;
    private String label;
    private String labelDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
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

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabelDate() {
        return labelDate;
    }

    public void setLabelDate(String labelDate) {
        this.labelDate = labelDate;
    }
}
