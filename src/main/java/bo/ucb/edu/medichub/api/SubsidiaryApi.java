package bo.ucb.edu.medichub.api;

import bo.ucb.edu.medichub.bl.SubsidiaryBl;
import bo.ucb.edu.medichub.bl.TransactionBl;
import bo.ucb.edu.medichub.dto.SubsidiaryRequest;
import bo.ucb.edu.medichub.model.Transaction;
import bo.ucb.edu.medichub.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public SubsidiaryRequest createSubsidiary(@RequestBody SubsidiaryRequest subsidiaryRequest, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        SubsidiaryRequest subsidiaryResponse = subsidiaryBl.createSubsidiary(subsidiaryRequest, transaction);
        return subsidiaryResponse;
    }

    @GetMapping(path="/{subsidiaryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SubsidiaryRequest findSubsidiaryById(@PathVariable String subsidiaryId){
        SubsidiaryRequest subsidiary = subsidiaryBl.findSubsidiaryById(Integer.parseInt(subsidiaryId));
        return subsidiary;
    }
}
