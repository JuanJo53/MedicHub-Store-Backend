package bo.ucb.edu.medichub.dto;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;

public class SubsidiaryRequest {
    @NumberFormat
    @Positive
    private Integer subsidiaryId;
    @NumberFormat
    @Positive
    private Integer pharmacyId;
    @NotEmpty
    @Size(min = 6)
    private String subsidiaryName;
    @NotEmpty
    @Size(min = 12, max = 18)
    private String phone;
    @NotEmpty
    @Size(min = 6)
    @Email
    private String email;
    @Size(min = 2)
    private String number;
    @NotEmpty
    @Size(min = 3)
    private String street;
    @NotEmpty
    @Size(min = 3)
    private String zone;
    @NotEmpty
    @Size(min = 3)
    private String city;
    @NotEmpty
    @Size(min = 3)
    private String country;

    public SubsidiaryRequest() {
    }

    public Integer getSubsidiaryId() {
        return subsidiaryId;
    }

    public void setSubsidiaryId(Integer subsidiaryId) {
        this.subsidiaryId = subsidiaryId;
    }

    public Integer getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(Integer pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public String getSubsidiaryName() {
        return subsidiaryName;
    }

    public void setSubsidiaryName(String subsidiaryName) {
        this.subsidiaryName = subsidiaryName;
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
        return "SubsidiaryRequest{" +
                "subsidiaryId=" + subsidiaryId +
                ", pharmacyId=" + pharmacyId +
                ", subsidiaryName='" + subsidiaryName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", number='" + number + '\'' +
                ", street='" + street + '\'' +
                ", zone='" + zone + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
