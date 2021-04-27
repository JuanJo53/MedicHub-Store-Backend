package bo.ucb.edu.medichub.api;

import bo.ucb.edu.medichub.bl.ClientBl;
import bo.ucb.edu.medichub.bl.TransactionBl;
import bo.ucb.edu.medichub.dto.*;
import bo.ucb.edu.medichub.model.Transaction;
import bo.ucb.edu.medichub.util.ImageUtil;
import bo.ucb.edu.medichub.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

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

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus createClient(@Valid @RequestBody ClientRequest clientRequest, HttpServletRequest request, BindingResult result) {
        if(!result.hasErrors()){
            Transaction transaction = TransactionUtil.createTransaction(request);
            transactionBl.createTransaction(transaction);
            ClientRequest clientResponse = clientBl.createClient(clientRequest, transaction);
            if(clientResponse==null){
                return HttpStatus.BAD_REQUEST;
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


    @PutMapping(path="/updatepassword", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus updatePasswordClient(@Valid @RequestBody PasswordRequest clientPasswordReques, HttpServletRequest request, BindingResult result){
        if(!result.hasErrors()){
            Transaction transaction = TransactionUtil.createTransaction(request);
            transactionBl.createTransaction(transaction);
            PasswordRequest clientPasswordReques1 = clientBl.updatepasswordClient(clientPasswordReques, transaction);
            if (clientPasswordReques1!=null){

                return HttpStatus.OK;
            }else{
                return HttpStatus.BAD_REQUEST;
            }
        } else{
            return HttpStatus.BAD_REQUEST;
        }
    }

    @DeleteMapping(path="/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus deleteClient(@PathVariable String clientId, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        clientBl.deleteClient(Integer.parseInt(clientId),transaction);
        return HttpStatus.ACCEPTED;
    }

    @GetMapping(path="/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClientRequest getClient(@PathVariable String clientId){
        return clientBl.getClient(Integer.parseInt(clientId));
    }

    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClientListRequest> getClients(@RequestParam Integer page, @RequestParam Integer size,
                                              @RequestParam String order, @RequestParam Boolean asc) {
        List<ClientListRequest> clients=clientBl.getClients(page, size, order, asc);
        return clients;
    }


    @GetMapping(path="/{clientId}/card", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CardRequest> getCards(@PathVariable String clientId){
        List<CardRequest> cards = clientBl.getCards(Integer.parseInt(clientId));
        return cards;
    }

    @RequestMapping(path = "/total",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer getClientTotal(){
        Integer cant = clientBl.getClientTotal();
        return cant;
    }

    @PutMapping(path="/{pharmacyId}/image", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity uploadImage(@RequestParam MultipartFile image, @PathVariable String clientId, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        clientBl.uploadImage(image,Integer.parseInt(clientId),transaction);
        return new ResponseEntity("Succesful process", HttpStatus.OK);
    }

    @GetMapping(path="image/{path}/{name}" , produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] getImage(@PathVariable String path, @PathVariable String name){
        ImageUtil storageUtil=new ImageUtil();
        byte[] image=storageUtil.getImage(path,name);
        return image;
    }
}
