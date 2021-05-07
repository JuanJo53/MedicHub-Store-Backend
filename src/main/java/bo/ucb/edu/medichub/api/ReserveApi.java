package bo.ucb.edu.medichub.api;

import bo.ucb.edu.medichub.bl.ReserveBl;
import bo.ucb.edu.medichub.bl.TransactionBl;
import bo.ucb.edu.medichub.dto.*;
import bo.ucb.edu.medichub.model.Transaction;
import bo.ucb.edu.medichub.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/reserve")
public class ReserveApi {
    private ReserveBl reserveBl;
    private TransactionBl transactionBl;

    @Autowired
    public ReserveApi(ReserveBl reserveBl, TransactionBl transactionBl) {
        this.reserveBl = reserveBl;
        this.transactionBl = transactionBl;
    }



    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus createPurchase(@RequestBody ProductReserveCarRequest productReserveCarRequest, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        reserveBl.manageReserve(productReserveCarRequest, transaction);
        return HttpStatus.OK;
    }

    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReserveRequest> getPharmacies(@RequestParam Integer page, @RequestParam Integer size,@RequestParam Integer state) {
        List<ReserveRequest> reserve=reserveBl.getListReserve(page,size,state);

        return reserve;
    }




    @GetMapping(path="/{clientId}/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductReserveListRequest getPharmacies(@PathVariable String clientId,
                                             @RequestParam Integer page,
                                             @RequestParam Integer size,
                                               @RequestParam Integer state){
        ProductReserveListRequest product = reserveBl.productList(Integer.parseInt(clientId), page, size,state);
        return product;
    }

    @GetMapping(path="/{clientId}/quantity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer quantityProductReserve(@PathVariable String clientId){
        Integer quantity = reserveBl.quantityProductReserve(Integer.parseInt(clientId));
        return quantity;
    }




    @GetMapping(path="/{clientId}/total", produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer getTotalProductReserve(@PathVariable String clientId,@RequestParam Integer state){
        Integer total = reserveBl.totalProductReserve(Integer.parseInt(clientId),state);
        return total;
    }

}
