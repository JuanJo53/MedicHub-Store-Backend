package bo.ucb.edu.medichub.model;

public class ProductPurchase {
    private Integer productPurchaseId;
    private Integer productId;
    private Integer purchaseId;
    private Integer quantity;
    private Integer status;
    private Transaction transaction;

    public ProductPurchase() {
        transaction = new Transaction();
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

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
        return "ProductPurchase{" +
                "productPurchaseId=" + productPurchaseId +
                ", productId=" + productId +
                ", purchaseId=" + purchaseId +
                ", quantity=" + quantity +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}
