package bo.ucb.edu.medichub.api;

import bo.ucb.edu.medichub.bl.ClientBl;
import bo.ucb.edu.medichub.bl.TransactionBl;
import bo.ucb.edu.medichub.dto.ClientRequest;
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
@RequestMapping(value = "/client")
public class ClientApi {
    private ClientBl clientBl;
    private TransactionBl transactionBl;


    @Autowired
    public ClientApi(ClientBl clientBl, TransactionBl transactionBl) {
        this.clientBl = clientBl;
        this.transactionBl = transactionBl;
    }


    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus updateClient(@Valid @RequestBody ClientRequest clientRequest, HttpServletRequest request, BindingResult result) {
        if(!result.hasErrors()){
            Transaction transaction = TransactionUtil.createTransaction(request);
            transactionBl.createTransaction(transaction);
            ClientRequest clientResponse = clientBl.updateClient(clientRequest, transaction);
            return HttpStatus.OK;
        } else{
            return HttpStatus.BAD_REQUEST;
        }
    }

    @DeleteMapping(path="/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus deletePharmacy(@PathVariable String clientId, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        clientBl.deleteClient(Integer.parseInt(clientId),transaction);
        return HttpStatus.ACCEPTED;
    }
}
