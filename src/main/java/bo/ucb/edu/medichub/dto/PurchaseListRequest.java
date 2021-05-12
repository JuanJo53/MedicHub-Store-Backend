package bo.ucb.edu.medichub.dto;

import java.util.Date;
import java.util.List;

public class PurchaseListRequest {

    private Integer purchaseId;
    private Double totalAmount;
    private String firstSurname;
    private String nit;
    private Date datePurchase;
    private Integer size;
    private List<ProductListResponse> products;

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

    public List<ProductListResponse> getProducts() {
        return products;
    }

    public void setProducts(List<ProductListResponse> products) {
        this.products = products;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "PurchaseListRequest{" +
                "purchaseId=" + purchaseId +
                ", totalAmount=" + totalAmount +
                ", firstSurname='" + firstSurname + '\'' +
                ", nit='" + nit + '\'' +
                ", datePurchase=" + datePurchase +
                ", size=" + size +
                ", products=" + products +
                '}';
    }
}
