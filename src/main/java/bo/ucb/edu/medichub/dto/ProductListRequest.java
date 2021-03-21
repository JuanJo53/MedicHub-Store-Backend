package bo.ucb.edu.medichub.dto;

public class ProductListRequest {
    private Integer productId;
    private String brandName;
    private String name;

    public ProductListRequest() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductListRequest{" +
                "productId=" + productId +
                ", brandName='" + brandName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
