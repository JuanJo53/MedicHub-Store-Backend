package bo.ucb.edu.medichub.model;

public class DoseType {
    private Integer doseType;
    private String type;
    private Integer status;
    private Transaction transaction;

    public DoseType() {
        transaction = new Transaction();
    }

    public Integer getDoseType() {
        return doseType;
    }

    public void setDoseType(Integer doseType) {
        this.doseType = doseType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return "DoseType{" +
                "doseType=" + doseType +
                ", type='" + type + '\'' +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}
