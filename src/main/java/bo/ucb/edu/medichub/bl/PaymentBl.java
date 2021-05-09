package bo.ucb.edu.medichub.bl;

import bo.ucb.edu.medichub.dao.PaymentDao;
import bo.ucb.edu.medichub.dao.ProductPurchaseDao;
import bo.ucb.edu.medichub.dao.ReserveDao;
import bo.ucb.edu.medichub.dao.TransactionDao;
import bo.ucb.edu.medichub.dto.PaymentRequest;
import bo.ucb.edu.medichub.dto.ProductTransactionRequest;
import bo.ucb.edu.medichub.model.Payment;
import bo.ucb.edu.medichub.model.Product;
import bo.ucb.edu.medichub.model.Reserve;
import bo.ucb.edu.medichub.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PaymentBl {
    private PaymentDao paymentDao;
    private ReserveDao reserveDao;
    private ProductPurchaseDao productPurchaseDao;
    private TransactionDao transactionDao;

    @Autowired
    public PaymentBl(PaymentDao paymentDao, ReserveDao reserveDao, ProductPurchaseDao productPurchaseDao, TransactionDao transactionDao) {
        this.paymentDao = paymentDao;
        this.reserveDao = reserveDao;
        this.productPurchaseDao = productPurchaseDao;
        this.transactionDao = transactionDao;
    }

    public void createPayment(PaymentRequest paymentRequest, Transaction transaction){
        Payment payment = new Payment();
        Reserve reserve = new Reserve();

        Integer lastReserveId = reserveDao.getLastReserveId(paymentRequest.getClientId());

        List<ProductTransactionRequest> products = paymentDao.getProductList(lastReserveId);

        for(int i = 0; i < products.size(); i++){
            Product product = new Product();

            Integer stock = productPurchaseDao.getStockByProductId(products.get(i).getProductId());
            stock = stock - products.get(i).getQuantity();
            product.setProductId(products.get(i).getProductId());
            product.setStock(stock);
            productPurchaseDao.updateStock(product);
        }

        reserve.setClientId(paymentRequest.getClientId());
        reserve.setReserveId(lastReserveId);
        reserve.setStatusReserve(2);
        reserve.setTransaction(transaction);
        reserveDao.updateReserveStatus(reserve);

        payment.setPaymentDate(new Date());
        payment.setAmount(paymentRequest.getTotal());
        payment.setReserveId(lastReserveId);
        payment.setCardId(paymentRequest.getCardId());
        payment.setTransaction(transaction);
        paymentDao.createPayment(payment);
    }
}
