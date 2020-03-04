package ke.ac.egerton.student_finance.thirdPartyPayments.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "SFTPIMPORTS")
public class HelbImports extends AuditableEntity {

    @Id
    @GeneratedValue(generator = "SFTPIMPORTS")
    @GenericGenerator(name = "SFTPIMPORTS", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;
    @NotNull(message = "This field cannot be null")
    @Column(name = "REFNO")
    private String refNo;
    @Column(name = "RCNO")
    private String  rcptNo;
    @Column(name = "TPSTUDENTNO")
    private String tpStudentNo;
    @Column(name = "STUDENTNUMBER")
    private String studentNo;
    @Column(name = "ACCOUNT")
    private String account;
    @Column(name = "FIRSTNAME")
    private String  firstName;
    @Column(name = "SECONDNAME")
    private String   secondName;
    @Column(name = "LASTNAME")
    private String lastName;
    @Column(name = "ACADEMICYEAR")
    @NotNull(message = "This field cannot be null")
    private String   academicYear;
    @Column(name = "SEMSESSIONCODE")
    @NotNull(message = "This field cannot be null")
    private String semesterCode;
    @Column(name = "AMOUNT")
    private Integer amount;
    @Column(name = "HMCUR")
    private String  homeCurrency;
    @Column(name = "HMAMT")
    private Integer homeAmount ;
    @Column(name = "SRCCUR")
    private String srCurrency;
    @Column(name = "SRCAMT")
    private Integer  srAmount;
    @Column(name = "EXCHRATE")
    private BigDecimal  exchangeRate;
    @NotNull(message = "This field cannot be null")
    @Column(name = "TPCODE")
    private String tpCode;
    @Column(name = "DOCNO")
    private String documentNo;
    @Column(name = "ENTRYDESC")
    private String entryDescription;
    @Column(name = "IMPORTID")
    private String importId;
    @Column(name = "PROCESSED")
    private Integer processed;
    @Column(name = "DELETED")
    private Integer deleted;
    @Column(name = "IDNUMBER")
    private String  idNumber;
    @Column(name = "YEARCODE")
    private Integer yearCode;
    @Column(name = "PERIODCODE")
    private String  periodCode;
    @Transient
    private MultipartFile file;

    public HelbImports( ){}

    public HelbImports(Long id, String refNo, String rcptNo, String tpStudentNo, String studentNo, String account, String firstName, String secondName,
                       String lastName, String academicYear, String semesterCode, Integer amount, String homeCurrency, Integer homeAmount, String srCurrency,
                       Integer srAmount, BigDecimal exchangeRate, String tpCode, String documentNo, String entryDescription, String importId, Integer processed,
                       Integer deleted, String idNumber, Integer yearCode, String periodCode) {
            super();
            this.id= id;
            this.refNo = refNo;
            this.rcptNo = rcptNo;
            this.tpStudentNo =tpStudentNo;
            this.studentNo = studentNo;
            this.account = account;
            this.firstName = firstName;
            this.secondName = secondName;
            this.lastName = lastName;
            this.academicYear =academicYear;
            this.semesterCode =semesterCode;
            this.amount = amount;
            this.homeCurrency = homeCurrency;
            this.homeAmount = homeAmount;
            this.srCurrency =srCurrency;
            this.srAmount = srAmount;
            this.exchangeRate =exchangeRate;
            this.tpCode =tpCode;
            this.documentNo = documentNo;
            this.entryDescription =entryDescription;
            this.importId = importId;
            this.processed =processed;
            this.deleted =deleted;
            this.idNumber =idNumber;
            this.yearCode =yearCode;
            this.periodCode =periodCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getRcptNo() {
        return rcptNo;
    }

    public void setRcptNo(String rcptNo) {
        this.rcptNo = rcptNo;
    }

    public String getTpStudentNo() {
        return tpStudentNo;
    }

    public void setTpStudentNo(String tpStudentNo) {
        this.tpStudentNo = tpStudentNo;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getSemesterCode() {
        return semesterCode;
    }

    public void setSemesterCode(String semesterCode) {
        this.semesterCode = semesterCode;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getHomeCurrency() {
        return homeCurrency;
    }

    public void setHomeCurrency(String homeCurrency) {
        this.homeCurrency = homeCurrency;
    }

    public Integer getHomeAmount() {
        return homeAmount;
    }

    public void setHomeAmount(Integer homeAmount) {
        this.homeAmount = homeAmount;
    }

    public String getSrCurrency() {
        return srCurrency;
    }

    public void setSrCurrency(String srCurrency) {
        this.srCurrency = srCurrency;
    }

    public Integer getSrAmount() {
        return srAmount;
    }

    public void setSrAmount(Integer srAmount) {
        this.srAmount = srAmount;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getTpCode() {
        return tpCode;
    }

    public void setTpCode(String tpCode) {
        this.tpCode = tpCode;
    }

    public String getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
    }

    public String getEntryDescription() {
        return entryDescription;
    }

    public void setEntryDescription(String entryDescription) {
        this.entryDescription = entryDescription;
    }

    public String getImportId() {
        return importId;
    }

    public void setImportId(String importId) {
        this.importId = importId;
    }

    public Integer getProcessed() {
        return processed;
    }

    public void setProcessed(Integer processed) {
        this.processed = processed;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Integer getYearCode() {
        return yearCode;
    }

    public void setYearCode(Integer yearCode) {
        this.yearCode = yearCode;
    }

    public String getPeriodCode() {
        return periodCode;
    }

    public void setPeriodCode(String periodCode) {
        this.periodCode = periodCode;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
