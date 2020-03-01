package ke.ac.egerton.student_finance.reports.models;

public class StudentReport {

    private  String studentNumber;
    private String accountNumber;
    private String name;
    private String programmeCode;
    private String campusCode;
    private String departmentCode;
    private String studyLevelCode;
    private String facultyCode;
    private Integer yearCode;

    public StudentReport() {
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgrammeCode() {
        return programmeCode;
    }

    public void setProgrammeCode(String programmeCode) {
        this.programmeCode = programmeCode;
    }

    public String getCampusCode() {
        return campusCode;
    }

    public void setCampusCode(String campusCode) {
        this.campusCode = campusCode;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getStudyLevelCode() {
        return studyLevelCode;
    }

    public void setStudyLevelCode(String studyLevelCode) {
        this.studyLevelCode = studyLevelCode;
    }

    public String getFacultyCode() {
        return facultyCode;
    }

    public void setFacultyCode(String facultyCode) {
        this.facultyCode = facultyCode;
    }

    public Integer getYearCode() {
        return yearCode;
    }

    public void setYearCode(Integer yearCode) {
        this.yearCode = yearCode;
    }
}
