package bo.ucb.edu.medichub.dto;

public class PharmacyListRequest {
    private Integer pharmacyId;
    private String name;

    public PharmacyListRequest() {
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

    @Override
    public String toString() {
        return "PharmacyListRequest{" +
                "pharmacyId=" + pharmacyId +
                ", name='" + name + '\'' +
                '}';
    }
}
