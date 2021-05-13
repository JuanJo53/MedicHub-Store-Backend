package bo.ucb.edu.medichub.api;

import bo.ucb.edu.medichub.bl.PurchaseBl;
import bo.ucb.edu.medichub.bl.TransactionBl;
import bo.ucb.edu.medichub.dto.Graph;
import bo.ucb.edu.medichub.dto.ProductReserveRepRequest;
import bo.ucb.edu.medichub.dto.PurchaseListRequest;
import bo.ucb.edu.medichub.dto.PurchaseRequest;
import bo.ucb.edu.medichub.model.Transaction;
import bo.ucb.edu.medichub.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/purchase")
public class PurchaseApi {
    private PurchaseBl purchaseBl;
    private TransactionBl transactionBl;

    @Autowired
    public PurchaseApi(PurchaseBl purchaseBl, TransactionBl transactionBl) {
        this.purchaseBl = purchaseBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus createPurchase(@RequestBody PurchaseRequest purchaseRequest, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        PurchaseRequest purchaseResponse = purchaseBl.createPurchase(purchaseRequest, transaction);
        return HttpStatus.OK;
    }


    @GetMapping(path="/{subsidiaryId}/list" , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PurchaseListRequest> getPurchaseSubsidiary(@PathVariable String subsidiaryId,
                                                           @RequestParam Integer page,
                                                           @RequestParam Integer size) {
        List<PurchaseListRequest> purchase=purchaseBl.getListPurchaseSubsidiary(Integer.parseInt(subsidiaryId),page,size);

        return purchase;
    }

    @GetMapping(path="/{subsidiaryId}/graph" , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Graph> getPurchaseSubsidiary(@PathVariable String subsidiaryId,
                                             @RequestParam String init,
                                             @RequestParam String end) {
        List<Graph> purchase=purchaseBl.getListPurchaseGraphSubsidiary(Integer.parseInt(subsidiaryId),init,end);
        return purchase;
    }
    
    @GetMapping(path="/{subsidiaryId}/subsidiary/report", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductReserveRepRequest> getSubsidiaryListReportPharmacies(@PathVariable String subsidiaryId,
                                                                            @RequestParam Integer page,
                                                                            @RequestParam Integer size,
                                                                            @RequestParam Boolean asc){
        List<ProductReserveRepRequest> product = purchaseBl.getSubsidiaryListReportReserve(Integer.parseInt(subsidiaryId), page, size,asc);
        return product;
    }

    @GetMapping(path="/{subsidiaryId}/subsidiary/report/general", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductReserveRepRequest> getSubsidiaryListReportGeneralPharmacies(@PathVariable String subsidiaryId,
                                                                            @RequestParam Integer page,
                                                                            @RequestParam Integer size,
                                                                            @RequestParam Boolean asc){
        List<ProductReserveRepRequest> product = purchaseBl.getSubsidiaryListReportGeneralReserve(Integer.parseInt(subsidiaryId), page, size,asc);
        return product;
    }

}
