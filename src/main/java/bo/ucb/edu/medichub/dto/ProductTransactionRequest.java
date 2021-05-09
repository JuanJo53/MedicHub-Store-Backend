package bo.ucb.edu.medichub.dto;

public class ProductTransactionRequest {
    private Integer productTransactionId;
    private Integer productId;
    private Integer quantity;

    public ProductTransactionRequest() {
    }

    public Integer getProductTransactionId() {
        return productTransactionId;
    }

    public void setProductTransactionId(Integer productTransactionId) {
        this.productTransactionId = productTransactionId;
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
        return "ProductPurchaseRequest{" +
                "productPurchaseId=" + productTransactionId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
