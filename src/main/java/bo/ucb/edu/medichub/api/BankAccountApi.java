package bo.ucb.edu.medichub.api;


import bo.ucb.edu.medichub.bl.BankAccountBl;
import bo.ucb.edu.medichub.bl.TransactionBl;
import bo.ucb.edu.medichub.dto.BankAccountRequest;
import bo.ucb.edu.medichub.model.Transaction;
import bo.ucb.edu.medichub.util.TransactionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*",methods = {RequestMethod.PUT, RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE})
@RequestMapping(value = "/bankAccount")
public class BankAccountApi {
    private BankAccountBl bankAccountBl;
    private TransactionBl transactionBl;

    private static final Logger LOGGER = LoggerFactory.getLogger(PharmacyApi.class);

    @Autowired
    public BankAccountApi(BankAccountBl bankAccountBl, TransactionBl transactionBl) {
        this.bankAccountBl = bankAccountBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus createBankAccount(@Valid @RequestBody BankAccountRequest bankAccountRequest, HttpServletRequest request,
                                        BindingResult result) {
        if(!result.hasErrors()){
            Transaction transaction = TransactionUtil.createTransaction(request);
            transactionBl.createTransaction(transaction);
            BankAccountRequest bankAccountResponse = bankAccountBl.createBankAccount(bankAccountRequest, transaction);
            return HttpStatus.OK;
        }  else {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus updateBankAccount(@Valid @RequestBody BankAccountRequest bankAccountRequest, HttpServletRequest request,BindingResult result) {
        if(!result.hasErrors()){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        bankAccountBl.updateBankAccount(bankAccountRequest,transaction);
            return HttpStatus.OK;
        } else{
            return HttpStatus.BAD_REQUEST;
        }
    }

    @GetMapping(path="/{subsidiaryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BankAccountRequest findBankAccountById(@PathVariable String subsidiaryId){
        BankAccountRequest bankAccountRequest = bankAccountBl.findBankAccountById(Integer.parseInt(subsidiaryId));
        return bankAccountRequest;
    }
}
