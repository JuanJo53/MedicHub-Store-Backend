package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.medichub.bl.PharmacyBl;
import bo.ucb.edu.medichub.bl.TransactionBl;
import bo.ucb.edu.medichub.dto.PharmacyRequest;
import bo.ucb.edu.medichub.model.Transaction;
import bo.ucb.edu.medichub.util.TransactionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    public PharmacyRequest updatePharmacy(@RequestBody PharmacyRequest pharmacyRequest, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        pharmacyBl.updatePharmacy(pharmacyRequest,transaction);
        return pharmacyRequest;
    }

    @DeleteMapping(path="/{pharmacyId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deletePharmacy(@PathVariable String pharmacyId, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        pharmacyBl.deletePharmacy(Integer.parseInt(pharmacyId),transaction);
        return "Succesful process";
    }

    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PharmacyRequest> getPharmacies() {
        List<PharmacyRequest> pharmacies=pharmacyBl.getPharmacies();
        return pharmacies;
    }

    @RequestMapping(path="bankAccount" ,method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public BankAccountRequest createBankAccount(@RequestBody BankAccountRequest bankAccountRequest, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        BankAccountRequest bankAccountResponse = pharmacyBl.createBankAccount(bankAccountRequest, transaction);
        return bankAccountResponse;
    }
}