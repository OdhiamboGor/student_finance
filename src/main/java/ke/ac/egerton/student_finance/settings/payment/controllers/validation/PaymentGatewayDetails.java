package ke.ac.egerton.student_finance.settings.payment.controllers.validation;

public class PaymentGatewayDetails {

    private Long id;
    private String code;
    private String name;
    private String paymentMode;
    private String currency;
    private Boolean mpesa;
    private Boolean payBill;
    private Boolean payPal;
    private Boolean bank;

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


    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getMpesa() {
        return mpesa;
    }

    public void setMpesa(Boolean mpesa) {
        this.mpesa = mpesa;
    }

    public Boolean getPayBill() {
        return payBill;
    }

    public void setPayBill(Boolean payBill) {
        this.payBill = payBill;
    }

    public Boolean getPayPal() {
        return payPal;
    }

    public void setPayPal(Boolean payPal) {
        this.payPal = payPal;
    }

    public Boolean getBank() {
        return bank;
    }

    public void setBank(Boolean bank) {
        this.bank = bank;
    }

}
