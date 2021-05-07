package bo.ucb.edu.medichub.dto;

import java.util.Date;
import java.util.List;

public class PurchaseListRequest {

    private Integer purchaseId;
    private Double totalAmount;
    private String firstSurname;
    private String nit;
    private Date datePurchase;
    private List<ProductPurchaseListRequest> products;

    public PurchaseListRequest() {
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

    public Date getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(Date datePurchase) {
        this.datePurchase = datePurchase;
    }

    public List<ProductPurchaseListRequest> getProducts() {
        return products;
    }

    public void setProducts(List<ProductPurchaseListRequest> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "PurchaseListRequest{" +
                "purchaseId=" + purchaseId +
                ", totalAmount=" + totalAmount +
                ", firstSurname='" + firstSurname + '\'' +
                ", nit='" + nit + '\'' +
                ", datePurchase=" + datePurchase +
                ", products=" + products +
                '}';
    }
}
