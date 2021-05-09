package bo.ucb.edu.medichub.api;

import bo.ucb.edu.medichub.bl.PaymentBl;
import bo.ucb.edu.medichub.bl.TransactionBl;
import bo.ucb.edu.medichub.dto.PaymentRequest;
import bo.ucb.edu.medichub.model.Transaction;
import bo.ucb.edu.medichub.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/payment")
public class PaymentApi {
    private PaymentBl paymentBl;
    private TransactionBl transactionBl;

    @Autowired
    public PaymentApi(PaymentBl paymentBl, TransactionBl transactionBl) {
        this.paymentBl = paymentBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus createPayment(@RequestBody PaymentRequest paymentRequest, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        paymentBl.createPayment(paymentRequest, transaction);
        return HttpStatus.OK;
    }
}