package bo.ucb.edu.medichub.dto;

public class ProductRequest {
    private Integer productId;
    private Integer subsidiaryId;
    private Integer brandId;
    private String name;
    private Integer stock;
    private Double price;
    private String type;
    private String dose;
    private String description;

    public ProductRequest() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getSubsidiaryId() {
        return subsidiaryId;
    }

    public void setSubsidiaryId(Integer subsidiaryId) {
        this.subsidiaryId = subsidiaryId;
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductRequest{" +
                "productId=" + productId +
                ", subsidiaryId=" + subsidiaryId +
                ", brandId=" + brandId +
                ", name='" + name + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", dose='" + dose + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
