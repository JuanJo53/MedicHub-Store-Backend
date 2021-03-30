package bo.ucb.edu.medichub.api;

import bo.ucb.edu.medichub.bl.CardBl;
import bo.ucb.edu.medichub.bl.TransactionBl;
import bo.ucb.edu.medichub.dto.CardRequest;
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
@RequestMapping(value = "/card")
public class CardApi {
    private CardBl cardBl;
    private TransactionBl transactionBl;

    @Autowired
    public CardApi(CardBl cardBl, TransactionBl transactionBl) {
        this.cardBl = cardBl;
        this.transactionBl = transactionBl;
    }


    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus createCard(@Valid @RequestBody CardRequest cardRequest, HttpServletRequest request, BindingResult result) {
        if(!result.hasErrors()){
            Transaction transaction = TransactionUtil.createTransaction(request);
            transactionBl.createTransaction(transaction);
            CardRequest clientResponse = cardBl.createCard(cardRequest, transaction);
            return HttpStatus.OK;
        }
        else{
            return HttpStatus.BAD_REQUEST;
        }
    }


    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus updateCard(@Valid @RequestBody CardRequest cardRequest, HttpServletRequest request, BindingResult result) {
        if(!result.hasErrors()){
            Transaction transaction = TransactionUtil.createTransaction(request);
            transactionBl.createTransaction(transaction);
            CardRequest clientResponse = cardBl.updateCard(cardRequest, transaction);
            return HttpStatus.OK;
        }
        else{
            return HttpStatus.BAD_REQUEST;
        }
    }

    @DeleteMapping(path="/{cardId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus deleteCard(@PathVariable String cardId, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        cardBl.deleteCard(Integer.parseInt(cardId),transaction);
        return HttpStatus.ACCEPTED;
    }
}
