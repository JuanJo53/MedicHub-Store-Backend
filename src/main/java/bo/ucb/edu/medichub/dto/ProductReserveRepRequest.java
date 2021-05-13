package bo.ucb.edu.medichub.dto;

public class ProductReserveRepRequest {
    private Integer productId;
    private Integer quantity;
    private String name;
    private Double price;
    private Double total;
    private Integer stock;
    private String picture;

    public ProductReserveRepRequest() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "ProductReserveRepRequest{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", total=" + total +
                ", stock=" + stock +
                ", picture='" + picture + '\'' +
                '}';
    }
}
