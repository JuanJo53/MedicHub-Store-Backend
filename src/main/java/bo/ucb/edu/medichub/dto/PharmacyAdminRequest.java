package bo.ucb.edu.medichub.dto;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;

public class PharmacyAdminRequest {
    @NumberFormat
    @Positive
    private Integer pharmacyId;
    @NumberFormat
    @Positive
    private Integer personId;
    @NumberFormat
    @Positive
    private Integer subsidiaryId;
    @NotEmpty
    @Size(min = 3)
    private String firstName;
    @NotEmpty
    @Size(min = 3)
    private String firstSurname;
    @NotEmpty
    @Size(min = 3)
    private String secondSurname;
    @NotEmpty
    @Size(min = 6)
    private String ci;
    @NotEmpty
    @Size(min = 8, max = 15)
    private String phone;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Size(min = 3)
    private String userName;
    @NotEmpty
    @Size(min = 6)
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

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "PharmacyAdminRequest{" +
                "pharmacyId=" + pharmacyId +
                ", personId=" + personId +
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
