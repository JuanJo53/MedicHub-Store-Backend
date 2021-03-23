package bo.ucb.edu.medichub.api;

import bo.ucb.edu.medichub.bl.PharmacyBl;
import bo.ucb.edu.medichub.bl.TransactionBl;
import bo.ucb.edu.medichub.dto.*;
import bo.ucb.edu.medichub.model.Transaction;
import bo.ucb.edu.medichub.util.TransactionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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
    public HttpStatus createPharmacy(@Valid @RequestBody PharmacyRequest pharmacyRequest, HttpServletRequest request, BindingResult result) {
        if(!result.hasErrors()){
            Transaction transaction = TransactionUtil.createTransaction(request);
            transactionBl.createTransaction(transaction);
            PharmacyRequest pharmacyResponse = pharmacyBl.createPharmacy(pharmacyRequest, transaction);
            return HttpStatus.OK;
        }
        else{
            return HttpStatus.BAD_REQUEST;
        }
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus updatePharmacy(@Valid @RequestBody PharmacyRequest pharmacyRequest, HttpServletRequest request,
                                          BindingResult result) {
        if(!result.hasErrors()){
            Transaction transaction = TransactionUtil.createTransaction(request);
            transactionBl.createTransaction(transaction);
            pharmacyBl.updatePharmacy(pharmacyRequest,transaction);
            return HttpStatus.OK;
        } else {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @DeleteMapping(path="/{pharmacyId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deletePharmacy(@PathVariable String pharmacyId, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        pharmacyBl.deletePharmacy(Integer.parseInt(pharmacyId),transaction);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PharmacyListRequest> getPharmacies() {
        List<PharmacyListRequest> pharmacies=pharmacyBl.getPharmacies();
        return pharmacies;
    }

    @GetMapping(path="/{pharmacyId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PharmacyRequest findPharmacyById(@PathVariable String pharmacyId){
        PharmacyRequest pharmacy = pharmacyBl.findPharmacyById(Integer.parseInt(pharmacyId));
        return pharmacy;
    }

    @GetMapping(path="/{pharmacyId}/bankAccount", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BankAccountListRequest> getPharmacyBankAccounts(@PathVariable String pharmacyId){
        List<BankAccountListRequest> accounts = pharmacyBl.getPharmacyBankAccounts(Integer.parseInt(pharmacyId));
        return accounts;
    }

    @GetMapping(path="/{pharmacyId}/subsidiary", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SubsidiaryListRequest> getSubsidariesByPharmacy(@PathVariable String pharmacyId){
        List<SubsidiaryListRequest> subsidaries = pharmacyBl.getSubsidariesByPharmacy(Integer.parseInt(pharmacyId));
        return subsidaries;
    }

    @GetMapping(path="/{pharmacyId}/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonListRequest> getAdminsByPharmacy(@PathVariable String pharmacyId){
        List<PersonListRequest> admins = pharmacyBl.getAdminsByPharmacy(Integer.parseInt(pharmacyId));
        return admins;
    }

}