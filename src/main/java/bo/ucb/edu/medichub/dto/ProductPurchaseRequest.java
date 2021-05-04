package bo.ucb.edu.medichub.dto;

public class ProductPurchaseRequest {
    private Integer productPurchaseId;
    private Integer productId;
    private Integer quantity;

    public ProductPurchaseRequest() {
    }

    public Integer getProductPurchaseId() {
        return productPurchaseId;
    }

    public void setProductPurchaseId(Integer productPurchaseId) {
        this.productPurchaseId = productPurchaseId;
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
                "productPurchaseId=" + productPurchaseId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
