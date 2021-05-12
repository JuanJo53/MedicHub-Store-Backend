package bo.ucb.edu.medichub.dto;

import java.util.Date;
import java.util.List;

public class ReserveSubsidiaryRequest {
    private Integer reserveId;
    private Integer quantity;
    private Double total;
    private Date date;
    private String firstName;
    private Integer size;
    private Integer statusReserve;
    private List<ProductListResponse> products;

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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public Integer getStatusReserve() {
        return statusReserve;
    }

    public void setStatusReserve(Integer statusReserve) {
        this.statusReserve = statusReserve;
    }

    @Override
    public String toString() {
        return "ReserveSubsidiaryRequest{" +
                "reserveId=" + reserveId +
                ", quantity=" + quantity +
                ", total=" + total +
                ", date=" + date +
                ", firstName='" + firstName + '\'' +
                ", size=" + size +
                ", statusReserve=" + statusReserve +
                ", products=" + products +
                '}';
    }
}