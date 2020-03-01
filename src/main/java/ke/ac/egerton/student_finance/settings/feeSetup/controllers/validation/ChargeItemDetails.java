package ke.ac.egerton.student_finance.settings.feeSetup.controllers.validation;

import java.math.BigDecimal;

public class ChargeItemDetails {

    private Long id;
    private String code;
    private String name;
    private String unitOfMeasure;
    private Boolean tuition;
    private String account;
    private String accountMap;
    private Boolean payment;
    private Boolean autoInsert;
    private BigDecimal amount;
    private Boolean hasSegment;
    private Boolean scholarship;
    private Boolean invoice;
    private String accountSets;
    private Long priority;

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

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Boolean getTuition() {
        return tuition;
    }

    public void setTuition(Boolean tuition) {
        this.tuition = tuition;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccountMap() {
        return accountMap;
    }

    public void setAccountMap(String accountMap) {
        this.accountMap = accountMap;
    }

    public Boolean getPayment() {
        return payment;
    }

    public void setPayment(Boolean payment) {
        this.payment = payment;
    }

    public Boolean getAutoInsert() {
        return autoInsert;
    }

    public void setAutoInsert(Boolean autoInsert) {
        this.autoInsert = autoInsert;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Boolean getHasSegment() {
        return hasSegment;
    }

    public void setHasSegment(Boolean hasSegment) {
        this.hasSegment = hasSegment;
    }

    public Boolean getScholarship() {
        return scholarship;
    }

    public void setScholarship(Boolean scholarship) {
        this.scholarship = scholarship;
    }

    public Boolean getInvoice() {
        return invoice;
    }

    public void setInvoice(Boolean invoice) {
        this.invoice = invoice;
    }

    public String getAccountSets() {
        return accountSets;
    }

    public void setAccountSets(String accountSets) {
        this.accountSets = accountSets;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }
}
