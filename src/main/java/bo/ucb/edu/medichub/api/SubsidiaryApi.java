package bo.ucb.edu.medichub.api;

import bo.ucb.edu.medichub.bl.SubsidiaryBl;
import bo.ucb.edu.medichub.bl.TransactionBl;
import bo.ucb.edu.medichub.dto.PersonListRequest;
import bo.ucb.edu.medichub.dto.ProductListRequest;
import bo.ucb.edu.medichub.dto.SubsidiaryRequest;
import bo.ucb.edu.medichub.model.Transaction;
import bo.ucb.edu.medichub.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/subsidiary")
public class SubsidiaryApi {
    private SubsidiaryBl subsidiaryBl;
    private TransactionBl transactionBl;

    @Autowired
    public SubsidiaryApi(SubsidiaryBl subsidiaryBl, TransactionBl transactionBl) {
        this.subsidiaryBl = subsidiaryBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus createSubsidiary(@Valid @RequestBody SubsidiaryRequest subsidiaryRequest, HttpServletRequest request,
                                              BindingResult result) {
        if(!result.hasErrors()){
            Transaction transaction = TransactionUtil.createTransaction(request);
            transactionBl.createTransaction(transaction);
            SubsidiaryRequest subsidiaryResponse = subsidiaryBl.createSubsidiary(subsidiaryRequest, transaction);
            return HttpStatus.OK;
        } else {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus updateSubsidiary(@Valid @RequestBody SubsidiaryRequest subsidiaryRequest, HttpServletRequest request,
                                              BindingResult result) {
        if(!result.hasErrors()){
            Transaction transaction = TransactionUtil.createTransaction(request);
            transactionBl.createTransaction(transaction);
            SubsidiaryRequest subsidiaryResponse = subsidiaryBl.updateSubsidiary(subsidiaryRequest, transaction);
            return HttpStatus.OK;
        } else {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @DeleteMapping(path="/{subsidiaryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus deletePharmacy(@PathVariable String subsidiaryId, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        subsidiaryBl.deletePharmacy(Integer.parseInt(subsidiaryId),transaction);
        return HttpStatus.ACCEPTED;
    }

    @GetMapping(path="/{subsidiaryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SubsidiaryRequest findSubsidiaryById(@PathVariable String subsidiaryId){
        SubsidiaryRequest subsidiary = subsidiaryBl.findSubsidiaryById(Integer.parseInt(subsidiaryId));
        return subsidiary;
    }

    @GetMapping(path="/{subsidiaryId}/product", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductListRequest> getProductsBySubsidiary(@PathVariable String subsidiaryId){
        List<ProductListRequest> products = subsidiaryBl.getProductsBySubsidiary(Integer.parseInt(subsidiaryId));
        return products;
    }

    @GetMapping(path="/{subsidiaryId}/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonListRequest> getAdminsBySubsidiary(@PathVariable String subsidiaryId){
        List<PersonListRequest> admins = subsidiaryBl.getAdminsBySubsidiary(Integer.parseInt(subsidiaryId));
        return admins;
    }
}
