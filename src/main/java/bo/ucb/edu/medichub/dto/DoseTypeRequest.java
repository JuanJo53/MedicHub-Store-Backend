package bo.ucb.edu.medichub.dto;

public class DoseTypeRequest {
    private Integer doseTypeId;
    private String type;

    public DoseTypeRequest() {
    }

    public Integer getDoseTypeId() {
        return doseTypeId;
    }

    public void setDoseTypeId(Integer doseTypeId) {
        this.doseTypeId = doseTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DoseTypeRequest{" +
                "doseTypeId=" + doseTypeId +
                ", type='" + type + '\'' +
                '}';
    }
}
