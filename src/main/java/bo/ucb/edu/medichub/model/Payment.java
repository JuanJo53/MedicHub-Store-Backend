package bo.ucb.edu.medichub.model;

import java.util.Date;

public class Payment {
    private Integer paymentId;
    private Integer cardId;
    private Integer reserveId;
    private Date paymentDate;
    private Double amount;
    private Integer status;
    private Transaction transaction;

    public Payment() {
        transaction = new Transaction();
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getReserveId() {
        return reserveId;
    }

    public void setReserveId(Integer reserveId) {
        this.reserveId = reserveId;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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
        return "Payment{" +
                "paymentId=" + paymentId +
                ", cardId=" + cardId +
                ", reserveId=" + reserveId +
                ", paymentDate=" + paymentDate +
                ", amount=" + amount +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}
