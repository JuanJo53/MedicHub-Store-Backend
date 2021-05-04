package bo.ucb.edu.medichub.api;

import bo.ucb.edu.medichub.bl.PharmacyAdminBl;
import bo.ucb.edu.medichub.bl.TransactionBl;
import bo.ucb.edu.medichub.dto.PasswordRequest;
import bo.ucb.edu.medichub.dto.PharmacyAdminRequest;
import bo.ucb.edu.medichub.model.Transaction;
import bo.ucb.edu.medichub.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
    public HttpStatus createSubsidiary(@Valid @RequestBody PharmacyAdminRequest pharmacyAdminRequest, HttpServletRequest request, BindingResult result) {
        if(!result.hasErrors()){
            Transaction transaction = TransactionUtil.createTransaction(request);
            transactionBl.createTransaction(transaction);
            PharmacyAdminRequest pharmacyAdminResponse = pharmacyAdminBl.createPharmacyAdmin(pharmacyAdminRequest, transaction);
            if(pharmacyAdminResponse==null){
                return  HttpStatus.BAD_REQUEST;
            } else {
                return HttpStatus.OK;
            }
        }
        else{
            return HttpStatus.BAD_REQUEST;
        }
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus updatePharmacyAdmin(@Valid @RequestBody PharmacyAdminRequest pharmacyAdminRequest, HttpServletRequest request, BindingResult result) {
        if(!result.hasErrors()){
            Transaction transaction = TransactionUtil.createTransaction(request);
            transactionBl.createTransaction(transaction);
            PharmacyAdminRequest pharmacyAdminResponse = pharmacyAdminBl.updatePharmacyAdmin(pharmacyAdminRequest, transaction);
            return HttpStatus.OK;
        } else{
            return HttpStatus.BAD_REQUEST;
        }
    }

    @DeleteMapping(path="/{pharmacyAdminId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus deletePharmacyAdmin(@PathVariable String pharmacyAdminId, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        pharmacyAdminBl.deletePharmacyAdmin(Integer.parseInt(pharmacyAdminId),transaction);
        return HttpStatus.ACCEPTED;
    }

    @GetMapping(path="/{pharmacyAdminId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PharmacyAdminRequest findAdminById(@PathVariable String pharmacyAdminId){
        PharmacyAdminRequest admin = pharmacyAdminBl.findAdminById(Integer.parseInt(pharmacyAdminId));
        return admin;
    }

    @PutMapping(path="/password", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus updatePassword(@Valid @RequestBody PasswordRequest passwordReques, HttpServletRequest request, BindingResult result){
        if(!result.hasErrors()){
            Transaction transaction = TransactionUtil.createTransaction(request);
            transactionBl.createTransaction(transaction);
            PasswordRequest passwordReques1 = pharmacyAdminBl.updateAdminPharmacyPassword(passwordReques, transaction);
            if (passwordReques1!=null){
                return HttpStatus.OK;
            }else{
                return HttpStatus.BAD_REQUEST;
            }
        } else{
            return HttpStatus.BAD_REQUEST;
        }
    }


}
