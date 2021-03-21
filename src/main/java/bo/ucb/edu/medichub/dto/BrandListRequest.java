package bo.ucb.edu.medichub.dto;

public class BrandListRequest {
    private Integer brandId;
    private String name;

    public BrandListRequest() {
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BrandListRequest{" +
                "brandId=" + brandId +
                ", name='" + name + '\'' +
                '}';
    }
}
