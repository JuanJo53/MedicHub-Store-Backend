package bo.ucb.edu.medichub.model;

public class PharmacyAdmin {
    private Integer pharmacyAdminId;
    private Integer personId;
    private Integer subsidiaryId;
    private String email;
    private String userName;
    private String password;
    private String picture;
    private Integer status;
    private Transaction transaction;

    public PharmacyAdmin() {
        transaction = new Transaction();
    }

    public Integer getPharmacyAdminId() {
        return pharmacyAdminId;
    }

    public void setPharmacyAdminId(Integer pharmacyAdminId) {
        this.pharmacyAdminId = pharmacyAdminId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getSubsidiaryId() {
        return subsidiaryId;
    }

    public void setSubsidiaryId(Integer subsidiaryId) {
        this.subsidiaryId = subsidiaryId;
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
        return "PharmacyAdmin{" +
                "pharmacyAdminId=" + pharmacyAdminId +
                ", personId=" + personId +
                ", subsidiaryId=" + subsidiaryId +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", picture='" + picture + '\'' +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}
