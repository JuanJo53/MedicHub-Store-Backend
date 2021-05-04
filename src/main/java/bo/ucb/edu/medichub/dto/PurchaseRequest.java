package bo.ucb.edu.medichub.dto;

import java.util.Date;
import java.util.List;

public class PurchaseRequest {
    private Integer purchaseId;
    private Date purchaseDate;
    private Double totalAmount;
    private List<ProductPurchaseRequest> products;

    public PurchaseRequest() {
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<ProductPurchaseRequest> getProducts() {
        return products;
    }

    public void setProducts(List<ProductPurchaseRequest> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "PurchaseRequest{" +
                "purchaseId=" + purchaseId +
                ", purchaseDate=" + purchaseDate +
                ", totalAmount=" + totalAmount +
                ", productPurchaseRequests=" + products +
                '}';
    }
}
