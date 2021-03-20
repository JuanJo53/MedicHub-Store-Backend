package bo.ucb.edu.medichub.model;

public class Subsidiary {
    private Integer subsidiaryId;
    private Integer pharmacyId;
    private Integer addressId;
    private String subsidiaryName;
    private String phone;
    private String email;
    private Integer status;
    private Transaction transaction;

    public Subsidiary() {
        transaction = new Transaction();
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

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
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
        return "Subsidiary{" +
                "subsidiaryId=" + subsidiaryId +
                ", pharmacyId=" + pharmacyId +
                ", addressId=" + addressId +
                ", subsidiaryName='" + subsidiaryName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ",  transaction=" + transaction +
                '}';
    }
}
