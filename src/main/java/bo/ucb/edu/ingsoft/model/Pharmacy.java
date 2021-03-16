package bo.ucb.edu.ingsoft.model;

public class Pharmacy {
    private Integer pharmacyId;
    private String name;
    private String phone;
    private String email;
    private String picture;
    private Integer status;
    private Transaction transaction;

    public Pharmacy() {
        transaction = new Transaction();
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "pharmacyId=" + pharmacyId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", picture='" + picture + '\'' +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}
