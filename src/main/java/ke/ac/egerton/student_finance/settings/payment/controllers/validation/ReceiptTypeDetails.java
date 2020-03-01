package ke.ac.egerton.student_finance.settings.payment.controllers.validation;

public class ReceiptTypeDetails {

    private Long id;
    private String code;
    private String name;
    private String payeeGroup;
    private String chargeItem;
    private String accountSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPayeeGroup() {
        return payeeGroup;
    }

    public void setPayeeGroup(String payeeGroup) {
        this.payeeGroup = payeeGroup;
    }

    public String getChargeItem() {
        return chargeItem;
    }

    public void setChargeItem(String chargeItem) {
        this.chargeItem = chargeItem;
    }

    public String getAccountSet() {
        return accountSet;
    }

    public void setAccountSet(String accountSet) {
        this.accountSet = accountSet;
    }
}
