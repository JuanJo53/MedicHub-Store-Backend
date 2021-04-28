package bo.ucb.edu.medichub.model;

public class ProductReserve {
    private Integer productReserveId;
    private Integer productId;
    private Integer reserveId;
    private Integer quantity;
    private Integer status;
    private Transaction transaction;

    public ProductReserve() {
        transaction = new Transaction();
    }

    public Integer getProductReserveId() {
        return productReserveId;
    }

    public void setProductReserveId(Integer productReserveId) {
        this.productReserveId = productReserveId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getReserveId() {
        return reserveId;
    }

    public void setReserveId(Integer reserveId) {
        this.reserveId = reserveId;
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
        return "ProductReserve{" +
                "productReserveId=" + productReserveId +
                ", productId=" + productId +
                ", reserveId=" + reserveId +
                ", quantity=" + quantity +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}
