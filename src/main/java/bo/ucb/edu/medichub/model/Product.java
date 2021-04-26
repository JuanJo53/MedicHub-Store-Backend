package bo.ucb.edu.medichub.model;

public class Product {
    private Integer productId;
    private Integer subsidiaryId;
    private Integer brandId;
    private Integer doseTypeId;
    private String name;
    private Integer stock;
    private Double price;
    private String type;
    private Integer dose;
    private String description;
    private String picture;
    private Integer status;
    private Transaction transaction;

    public Product() {
        transaction = new Transaction();
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

    public Integer getDoseTypeId() {
        return doseTypeId;
    }

    public void setDoseTypeId(Integer doseTypeId) {
        this.doseTypeId = doseTypeId;
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
        return "Product{" +
                "productId=" + productId +
                ", subsidiaryId=" + subsidiaryId +
                ", brandId=" + brandId +
                ", doseTypeId=" + doseTypeId +
                ", name='" + name + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", dose=" + dose +
                ", description='" + description + '\'' +
                ", picture='" + picture + '\'' +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}
