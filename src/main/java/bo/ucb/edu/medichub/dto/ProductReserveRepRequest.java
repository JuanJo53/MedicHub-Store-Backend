package bo.ucb.edu.medichub.dto;

public class ProductReserveRepRequest {
    private Integer productId;
    private Integer quantity;
    private String name;
    private Double total;

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

    @Override
    public String toString() {
        return "ProductReserveRepRequest{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                ", name='" + name + '\'' +
                ", total=" + total +
                '}';
    }
}
