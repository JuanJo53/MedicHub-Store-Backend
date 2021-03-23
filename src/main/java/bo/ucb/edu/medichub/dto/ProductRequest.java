package bo.ucb.edu.medichub.dto;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ProductRequest {
    @Positive
    @NumberFormat
    private Integer productId;
    @NotNull
    @Positive
    @NumberFormat
    private Integer subsidiaryId;
    @NotNull
    @Positive
    @NumberFormat
    private Integer brandId;
    @NotEmpty
    @Size(min = 3)
    private String name;
    @NotNull
    @Positive
    @NumberFormat
    private Integer stock;
    @NotNull
    @Positive
    @NumberFormat
    private Double price;
    @NotEmpty
    @Size(min = 4)
    private String type;
    @NotEmpty
    @Size(min = 4)
    private String dose;
    @NotEmpty
    @Size(min = 10, max = 150)
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
