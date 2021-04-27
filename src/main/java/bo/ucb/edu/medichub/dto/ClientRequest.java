package bo.ucb.edu.medichub.dto;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ClientRequest {
    @NumberFormat
    @Positive
    private Integer clientId;
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
    @NotEmpty
    @Size(min = 6, max = 50)
    private String password;
    @NotEmpty
    private String birthdate;
    private String number;
    @NotEmpty
    @Size(min = 3, max = 145)
    private String street;
    @NotEmpty
    @Size(min = 3, max = 80)
    private String zone;
    @NotEmpty
    @Size(min = 3, max = 80)
    private String city;
    @NotEmpty
    @Size(min = 3, max = 80)
    private String country;

    public ClientRequest() {
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "ClientRequest{" +
                "clientId=" + clientId +
                ", firstName='" + firstName + '\'' +
                ", firstSurname='" + firstSurname + '\'' +
                ", secondSurname='" + secondSurname + '\'' +
                ", picture='" + picture + '\'' +
                ", ci='" + ci + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", number='" + number + '\'' +
                ", street='" + street + '\'' +
                ", zone='" + zone + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
