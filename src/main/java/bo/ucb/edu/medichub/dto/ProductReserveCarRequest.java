package bo.ucb.edu.medichub.dto;

public class ProductReserveCarRequest {
    private Integer clientId;
    private Integer productId;
    private Integer quantity;

    public ProductReserveCarRequest() {
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
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

    @Override
    public String toString() {
        return "ProductReserveCarRequest{" +
                "clientId=" + clientId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
