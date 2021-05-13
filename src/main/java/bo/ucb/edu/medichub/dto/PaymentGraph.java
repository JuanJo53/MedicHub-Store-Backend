package bo.ucb.edu.medichub.dto;

import java.util.Date;

public class PaymentGraph {
    private Double price;
    private Integer quantity;
    private Date paymentDate;

    public PaymentGraph() {
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "PaymentGraph{" +
                "price=" + price +
                ", quantity=" + quantity +
                ", paymentDate=" + paymentDate +
                '}';
    }
}
