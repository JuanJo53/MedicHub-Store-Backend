package bo.ucb.edu.medichub.dto;

import java.util.Date;

public class PurchaseGraph {
    private Integer count;
    private Double total;
    private Date date;

    public PurchaseGraph() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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

    @Override
    public String toString() {
        return "PurchaseGraph{" +
                "count=" + count +
                ", total=" + total +
                ", date=" + date +
                '}';
    }
}
