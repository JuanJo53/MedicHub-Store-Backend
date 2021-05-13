package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.dto.PaymentGraph;
import bo.ucb.edu.medichub.dto.ProductTransactionRequest;
import bo.ucb.edu.medichub.model.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentDao {
    public void createPayment(Payment payment);

    public Integer getBankAccountId(Integer subsidiaryId);

    public List<ProductTransactionRequest> getProductList(Integer reserveId);

    public List<Payment>  getPaymentDateList(Integer subsidiaryId, String init, String end);

    public List<PaymentGraph>  getProductSubsidiaryList(Integer subsidiaryId);
}
