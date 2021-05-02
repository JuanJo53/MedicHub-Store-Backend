package bo.ucb.edu.medichub.dto;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class AdminRequest {
    @NumberFormat
    @Positive
    private Integer adminId;
    @NotEmpty
    @Size(min = 3, max = 25)
    private String firstName;
    @NotEmpty
    @Size(min = 3, max = 25)
    private String firstSurname;
    @NotEmpty
    @Size(min = 3, max = 25)
    private String secondSurname;
    private String picture;
    @NotEmpty
    @Size(min = 6, max = 20)
    private String ci;
    @NotEmpty
    @Size(min = 8, max = 18)
    private String phone;
    @NotEmpty
    @Size(min = 6, max = 50)
    @Email
    private String email;
    @NotEmpty
    @Size(min = 3, max = 20)
    private String userName;
    private String password;

    public AdminRequest() {
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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
        return "AdminRequest{" +
                "adminId=" + adminId +
                ", firstName='" + firstName + '\'' +
                ", firstSurname='" + firstSurname + '\'' +
                ", secondSurname='" + secondSurname + '\'' +
                ", picture='" + picture + '\'' +
                ", ci='" + ci + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
