package bo.ucb.edu.medichub.api;

import bo.ucb.edu.medichub.bl.PurchaseBl;
import bo.ucb.edu.medichub.bl.TransactionBl;
import bo.ucb.edu.medichub.dto.PurchaseRequest;
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
@RequestMapping(value = "/purchase")
public class PurchaseApi {
    private PurchaseBl purchaseBl;
    private TransactionBl transactionBl;

    @Autowired
    public PurchaseApi(PurchaseBl purchaseBl, TransactionBl transactionBl) {
        this.purchaseBl = purchaseBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus createPurchase(@RequestBody PurchaseRequest purchaseRequest, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        PurchaseRequest purchaseResponse = purchaseBl.createPurchase(purchaseRequest, transaction);
        return HttpStatus.OK;
    }
}
