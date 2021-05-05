package bo.ucb.edu.medichub.dto;

import java.util.Date;
import java.util.List;

public class ReserveRequest {
    private Integer reserveId;
    private Integer clientId;
    private Double total;
    private List<ProductReserveRequest> product;

    public ReserveRequest() {
    }

    public Integer getReserveId() {
        return reserveId;
    }

    public void setReserveId(Integer reserveId) {
        this.reserveId = reserveId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<ProductReserveRequest> getProduct() {
        return product;
    }

    public void setProduct(List<ProductReserveRequest> product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ReserveRequest{" +
                "reserveId=" + reserveId +
                ", clientId=" + clientId +
                ", total=" + total +
                ", product=" + product +
                '}';
    }
}
