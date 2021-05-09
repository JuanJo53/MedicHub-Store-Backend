package bo.ucb.edu.medichub.dto;

public class PaymentRequest {
    private Integer paymentId;
    private Integer clientId;
    private Integer cardId;
    private Double total;

    public PaymentRequest() {
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "paymentId=" + paymentId +
                ", clientId=" + clientId +
                ", cardId=" + cardId +
                ", total=" + total +
                '}';
    }
}
