package bo.ucb.edu.medichub.dto;

import java.util.Date;
import java.util.List;

public class ReserveListRequest {
    private Integer reserveId;
    private Double total;
    private Date dateReserve;
    private Integer quantity;
    private Integer size;
    private List<ProductListResponse> product;

    public ReserveListRequest() {
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

    public Date getDateReserve() {
        return dateReserve;
    }

    public void setDateReserve(Date dateReserve) {
        this.dateReserve = dateReserve;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<ProductListResponse> getProduct() {
        return product;
    }

    public void setProduct(List<ProductListResponse> product) {
        this.product = product;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "ReserveListRequest{" +
                "reserveId=" + reserveId +
                ", total=" + total +
                ", dateReserve=" + dateReserve +
                ", quantity=" + quantity +
                ", size=" + size +
                ", product=" + product +
                '}';
    }
}
