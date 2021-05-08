package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.model.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
    public void createPayment(Payment payment);
}
