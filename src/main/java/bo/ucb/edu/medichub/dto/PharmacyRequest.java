package bo.ucb.edu.medichub.dto;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;

public class PharmacyRequest {
    @Positive
    @NumberFormat
    private Integer pharmacyId;
    @NotEmpty
    @Size(min = 8)
    private String name;
    private String picture;
    @NotEmpty
    @Size(min = 12, max = 18)
    private String phone;
    @NotEmpty
    @Size(min = 6)
    @Email
    private String email;

    public PharmacyRequest() {
    }

    public Integer getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(Integer pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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

    @Override
    public String toString() {
        return "PharmacyRequest{" +
                "pharmacyId=" + pharmacyId +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
