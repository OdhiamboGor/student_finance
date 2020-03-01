package ke.ac.egerton.student_finance.settings.accountsSetup.controllers.validation;

public class GlAccountDetails {
    private Long id;
    private String number;
    private String name;
    private Boolean active;
    private String accountStructure;
    private String accountType;
    private String accountGroup;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getAccountStructure() {
        return accountStructure;
    }

    public void setAccountStructure(String accountStructure) {
        this.accountStructure = accountStructure;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountGroup() {
        return accountGroup;
    }

    public void setAccountGroup(String accountGroup) {
        this.accountGroup = accountGroup;
    }
}
