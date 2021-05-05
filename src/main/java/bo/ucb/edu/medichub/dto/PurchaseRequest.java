package bo.ucb.edu.medichub.dto;

import java.util.Date;
import java.util.List;

public class PurchaseRequest {
    private Integer purchaseId;
    private Double totalAmount;
    private String firstSurname;
    private String nit;
    private List<ProductPurchaseRequest> products;

    public PurchaseRequest() {
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
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
                ", totalAmount=" + totalAmount +
                ", firstSurname='" + firstSurname + '\'' +
                ", nit='" + nit + '\'' +
                ", products=" + products +
                '}';
    }
}
