package bo.ucb.edu.medichub.api;

import bo.ucb.edu.medichub.bl.AddressBl;
import bo.ucb.edu.medichub.bl.AdminBl;
import bo.ucb.edu.medichub.bl.TransactionBl;
import bo.ucb.edu.medichub.dto.AdminRequest;
import bo.ucb.edu.medichub.dto.PasswordRequest;
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
@RequestMapping(value = "/admin")
public class AdminApi {
    private AdminBl adminBl;
    private TransactionBl transactionBl;


    @Autowired
    public AdminApi(AdminBl adminBl, TransactionBl transactionBl) {
        this.adminBl = adminBl;
        this.transactionBl = transactionBl;
    }

    @PutMapping(path="/updatepassword", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus updatePasswordPAdmin(@Valid @RequestBody PasswordRequest adminPasswordReques, HttpServletRequest request, BindingResult result){
        if(!result.hasErrors()){
            Transaction transaction = TransactionUtil.createTransaction(request);
            transactionBl.createTransaction(transaction);
            PasswordRequest clientPasswordReques1 = adminBl.updatepasswordAdmin(adminPasswordReques, transaction);
            if (clientPasswordReques1!=null){

                return HttpStatus.OK;
            }else{
                return HttpStatus.BAD_REQUEST;
            }
        } else{
            return HttpStatus.BAD_REQUEST;
        }
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus updateAdmin(@Valid @RequestBody AdminRequest adminRequest, HttpServletRequest request, BindingResult result) {
        if(!result.hasErrors()){
            Transaction transaction = TransactionUtil.createTransaction(request);
            transactionBl.createTransaction(transaction);
            AdminRequest adminResponse = adminBl.updateAdmin(adminRequest, transaction);
            return HttpStatus.OK;
        } else{
            return HttpStatus.BAD_REQUEST;
        }
    }
}
