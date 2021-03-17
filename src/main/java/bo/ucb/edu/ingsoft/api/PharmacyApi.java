package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.PharmacyBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.PharmacyRequest;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/pharmacy")
public class PharmacyApi {
    private PharmacyBl pharmacyBl;
    private TransactionBl transactionBl;

    private static final Logger LOGGER = LoggerFactory.getLogger(PharmacyApi.class);

    @Autowired
    public PharmacyApi(PharmacyBl pharmacyBl, TransactionBl transactionBl) {
        this.pharmacyBl = pharmacyBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public PharmacyRequest createPharmacy(@RequestBody PharmacyRequest pharmacyRequest, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        PharmacyRequest pharmacyResponse = pharmacyBl.createPharmacy(pharmacyRequest, transaction);
        return pharmacyResponse;
    }
    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String delete(@RequestParam Integer IdPharmacy, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        pharmacyBl.deletePharmacy(IdPharmacy,transaction);
        return "Publicacion eliminada";
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public PharmacyRequest update(@RequestBody PharmacyRequest pharmacyRequest, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        pharmacyBl.updatePharmacy(pharmacyRequest,transaction);
        return pharmacyRequest;
    }



}