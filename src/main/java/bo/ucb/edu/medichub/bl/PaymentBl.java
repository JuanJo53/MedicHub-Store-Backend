package bo.ucb.edu.medichub.bl;

import bo.ucb.edu.medichub.dao.PaymentDao;
import bo.ucb.edu.medichub.dao.ReserveDao;
import bo.ucb.edu.medichub.dao.TransactionDao;
import bo.ucb.edu.medichub.dto.PaymentRequest;
import bo.ucb.edu.medichub.model.Payment;
import bo.ucb.edu.medichub.model.Reserve;
import bo.ucb.edu.medichub.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PaymentBl {
    private PaymentDao paymentDao;
    private ReserveDao reserveDao;
    private TransactionDao transactionDao;

    @Autowired
    public PaymentBl(PaymentDao paymentDao, ReserveDao reserveDao, TransactionDao transactionDao) {
        this.paymentDao = paymentDao;
        this.reserveDao = reserveDao;
        this.transactionDao = transactionDao;
    }

    public void createPayment(PaymentRequest paymentRequest, Transaction transaction){
        Payment payment = new Payment();
        Reserve reserve = new Reserve();

        Integer lastReserveId = reserveDao.getLastReserveId(paymentRequest.getClientId());

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
