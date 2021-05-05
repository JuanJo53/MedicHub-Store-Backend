package bo.ucb.edu.medichub.model;

import java.util.Date;

public class Purchase {
    private Integer purchaseId;
    private Date purchaseDate;
    private Double totalAmount;
    private String firstSurname;
    private String nit;
    private Integer status;
    private Transaction transaction;

    public Purchase() {
        transaction = new Transaction();
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
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
        return "Purchase{" +
                "purchaseId=" + purchaseId +
                ", purchaseDate=" + purchaseDate +
                ", totalAmount=" + totalAmount +
                ", firstSurname='" + firstSurname + '\'' +
                ", nit='" + nit + '\'' +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}
