package bo.ucb.edu.medichub.api;

import bo.ucb.edu.medichub.bl.PharmacyAdminBl;
import bo.ucb.edu.medichub.bl.TransactionBl;
import bo.ucb.edu.medichub.dto.PharmacyAdminRequest;
import bo.ucb.edu.medichub.model.Transaction;
import bo.ucb.edu.medichub.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/pharmacyAdmin")
public class PharmacyAdminApi {
    private PharmacyAdminBl pharmacyAdminBl;
    private TransactionBl transactionBl;

    @Autowired
    public PharmacyAdminApi(PharmacyAdminBl pharmacyAdminBl, TransactionBl transactionBl) {
        this.pharmacyAdminBl = pharmacyAdminBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public PharmacyAdminRequest createSubsidiary(@RequestBody PharmacyAdminRequest pharmacyAdminRequest, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        PharmacyAdminRequest pharmacyAdminResponse = pharmacyAdminBl.createPharmacyAdmin(pharmacyAdminRequest, transaction);
        return pharmacyAdminResponse;
    }
}
