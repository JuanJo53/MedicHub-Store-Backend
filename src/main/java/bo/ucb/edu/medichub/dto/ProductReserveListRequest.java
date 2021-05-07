package bo.ucb.edu.medichub.dto;

import java.util.List;

public class ProductReserveListRequest {
    private Integer reserveId;
    private Double total;
    private List<ProductListResponse> product;

    public ProductReserveListRequest() {
    }

    public Integer getReserveId() {
        return reserveId;
    }

    public void setReserveId(Integer reserveId) {
        this.reserveId = reserveId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<ProductListResponse> getProduct() {
        return product;
    }

    public void setProduct(List<ProductListResponse> product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductReserveListRequest{" +
                "reserveId=" + reserveId +
                ", total=" + total +
                ", product=" + product +
                '}';
    }
}
