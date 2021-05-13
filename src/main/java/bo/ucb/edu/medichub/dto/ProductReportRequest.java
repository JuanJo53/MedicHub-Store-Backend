package bo.ucb.edu.medichub.dto;

public class ProductReportRequest {
    private Integer pending;
    private Double gainPurchase;
    private Double gainReserve;
    private String BestSellingProduct;

    public ProductReportRequest() {
    }

    public Integer getPending() {
        return pending;
    }

    public void setPending(Integer pending) {
        this.pending = pending;
    }

    public Double getGainPurchase() {
        return gainPurchase;
    }

    public void setGainPurchase(Double gainPurchase) {
        this.gainPurchase = gainPurchase;
    }

    public Double getGainReserve() {
        return gainReserve;
    }

    public void setGainReserve(Double gainReserve) {
        this.gainReserve = gainReserve;
    }

    public String getBestSellingProduct() {
        return BestSellingProduct;
    }

    public void setBestSellingProduct(String bestSellingProduct) {
        BestSellingProduct = bestSellingProduct;
    }

    @Override
    public String toString() {
        return "ProductReportRequest{" +
                "pending=" + pending +
                ", gainPurchase=" + gainPurchase +
                ", gainReserve=" + gainReserve +
                ", BestSellingProduct='" + BestSellingProduct + '\'' +
                '}';
    }
}
