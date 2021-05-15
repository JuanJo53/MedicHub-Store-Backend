package bo.ucb.edu.medichub.dto;

public class ProductResponse {
    private Integer productId;
    private String brandName;
    private String name;
    private Integer stock;
    private Double price;
    private String type;
    private Integer dose;
    private String doseType;
    private String description;
    private String picture;

    public ProductResponse() {
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

    public Integer getDose() {
        return dose;
    }

    public void setDose(Integer dose) {
        this.dose = dose;
    }

    public String getDoseType() {
        return doseType;
    }

    public void setDoseType(String doseType) {
        this.doseType = doseType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "ProductResponse{" +
                "productId=" + productId +
                ", brandName='" + brandName + '\'' +
                ", name='" + name + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", dose=" + dose +
                ", doseType='" + doseType + '\'' +
                ", description='" + description + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
