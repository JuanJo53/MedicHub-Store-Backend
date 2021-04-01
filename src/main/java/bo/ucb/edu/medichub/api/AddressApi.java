package bo.ucb.edu.medichub.api;


import bo.ucb.edu.medichub.bl.AddressBl;
import bo.ucb.edu.medichub.bl.ClientBl;
import bo.ucb.edu.medichub.bl.TransactionBl;
import bo.ucb.edu.medichub.dto.AddressRequest;
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
@RequestMapping(value = "/address")
public class AddressApi {
    private AddressBl addressBl;
    private TransactionBl transactionBl;


    @Autowired
    public AddressApi(AddressBl addressBl, TransactionBl transactionBl) {
        this.addressBl = addressBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping( method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus updateAddress(@Valid @RequestBody AddressRequest addressRequest, HttpServletRequest request, BindingResult result) {
        if(!result.hasErrors()){
            Transaction transaction = TransactionUtil.createTransaction(request);
            transactionBl.createTransaction(transaction);
            AddressRequest addressResponse = addressBl.updateAddress(addressRequest, transaction);
            return HttpStatus.OK;
        } else{
            return HttpStatus.BAD_REQUEST;
        }
    }

    @GetMapping(path="/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AddressRequest findAddressByClient(@PathVariable String clientId){
        AddressRequest address = addressBl.getAddressByPerson(Integer.parseInt(clientId));
        return address;
    }
}
