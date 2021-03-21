package bo.ucb.edu.medichub.dto;

public class SubsidiaryListRequest {
    private Integer subsidiaryId;
    private String subsidiaryName;

    public SubsidiaryListRequest() {
    }

    public Integer getSubsidiaryId() {
        return subsidiaryId;
    }

    public void setSubsidiaryId(Integer subsidiaryId) {
        this.subsidiaryId = subsidiaryId;
    }

    public String getSubsidiaryName() {
        return subsidiaryName;
    }

    public void setSubsidiaryName(String subsidiaryName) {
        this.subsidiaryName = subsidiaryName;
    }

    @Override
    public String toString() {
        return "SubsidiaryListRequest{" +
                "subsidiaryId=" + subsidiaryId +
                ", subsidiaryName='" + subsidiaryName + '\'' +
                '}';
    }
}
