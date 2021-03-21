package bo.ucb.edu.medichub.api;

import bo.ucb.edu.medichub.bl.BrandBl;
import bo.ucb.edu.medichub.bl.TransactionBl;
import bo.ucb.edu.medichub.dto.BrandRequest;
import bo.ucb.edu.medichub.model.Transaction;
import bo.ucb.edu.medichub.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/brand")
public class BrandApi {
    private BrandBl brandBl;
    private TransactionBl transactionBl;

    @Autowired
    public BrandApi(BrandBl brandBl, TransactionBl transactionBl) {
        this.brandBl = brandBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public BrandRequest createSubsidiary(@RequestBody BrandRequest brandRequest, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        BrandRequest brandResponse = brandBl.createBrand(brandRequest, transaction);
        return brandResponse;
    }
}
