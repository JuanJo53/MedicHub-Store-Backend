package bo.ucb.edu.medichub.model;

import java.util.Date;

public class Reserve {
    private Integer reserveId;
    private Integer clientId;
    private Date date;
    private Double totalAmount;
    private Integer statusReserve;
    private Integer status;
    private Transaction transaction;

    public Reserve() {
        transaction = new Transaction();
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getStatusReserve() {
        return statusReserve;
    }

    public void setStatusReserve(Integer statusReserve) {
        this.statusReserve = statusReserve;
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
        return "Reserve{" +
                "reserveId=" + reserveId +
                ", clientId=" + clientId +
                ", date=" + date +
                ", totalAmount=" + totalAmount +
                ", statusReserve=" + statusReserve +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}
