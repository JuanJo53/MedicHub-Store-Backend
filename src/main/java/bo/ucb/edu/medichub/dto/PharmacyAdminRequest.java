package bo.ucb.edu.medichub.dto;

public class PharmacyAdminRequest {
    private Integer pharmacyId;
    private Integer subsidiaryId;
    private String firstName;
    private String firstSurname;
    private String secondSurname;
    private String ci;
    private String phone;
    private String email;
    private String userName;
    private String password;

    public PharmacyAdminRequest() {
    }

    public Integer getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(Integer pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public Integer getSubsidiaryId() {
        return subsidiaryId;
    }

    public void setSubsidiaryId(Integer subsidiaryId) {
        this.subsidiaryId = subsidiaryId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PharmacyAdminRequest{" +
                "pharmacyId=" + pharmacyId +
                ", subsidiaryId=" + subsidiaryId +
                ", firstName='" + firstName + '\'' +
                ", firstSurname='" + firstSurname + '\'' +
                ", secondSurname='" + secondSurname + '\'' +
                ", ci='" + ci + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
