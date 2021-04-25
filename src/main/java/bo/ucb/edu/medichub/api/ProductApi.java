package bo.ucb.edu.medichub.api;

import bo.ucb.edu.medichub.bl.ProductBl;
import bo.ucb.edu.medichub.bl.TransactionBl;
import bo.ucb.edu.medichub.dto.ClientListRequest;
import bo.ucb.edu.medichub.dto.ProductRequest;
import bo.ucb.edu.medichub.dto.ProductResponse;
import bo.ucb.edu.medichub.model.Transaction;
import bo.ucb.edu.medichub.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*" ,methods = {RequestMethod.PUT, RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE})
@RequestMapping(value = "/product")
public class ProductApi {
    private ProductBl productBl;
    private TransactionBl transactionBl;

    @Autowired
    public ProductApi(ProductBl productBl, TransactionBl transactionBl) {
        this.productBl = productBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus createProduct(@Valid @RequestBody ProductRequest productRequest, HttpServletRequest request, BindingResult result) {
        if(!result.hasErrors()){
            Transaction transaction = TransactionUtil.createTransaction(request);
            transactionBl.createTransaction(transaction);
            ProductRequest productResponse = productBl.createProduct(productRequest, transaction);
            return HttpStatus.OK;
        }else{
            return HttpStatus.BAD_REQUEST;
        }
    }


    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus updateProduct(@Valid @RequestBody ProductRequest productRequest, HttpServletRequest request,
                                        BindingResult result) {
        if(!result.hasErrors()){
            Transaction transaction = TransactionUtil.createTransaction(request);
            transactionBl.createTransaction(transaction);
            ProductRequest productResponse = productBl.updateProduct(productRequest, transaction);
            return HttpStatus.OK;
        }else{
            return HttpStatus.BAD_REQUEST;
        }
    }

    @DeleteMapping(path="/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteProduct(@PathVariable String productId, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        productBl.deleteProduct(Integer.parseInt(productId),transaction);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(path="/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponse findProductById(@PathVariable String productId){
        ProductResponse product = productBl.findProductById(Integer.parseInt(productId));
        return product;
    }

    @GetMapping(path="/{subsidiaryId}/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductResponse> productList(@PathVariable String subsidiaryId,
                                             @RequestParam Integer page,
                                             @RequestParam Integer size,
                                             @RequestParam String order,
                                             @RequestParam Boolean asc,
                                             @RequestParam String price,
                                             @RequestParam String brand  ){
        List<ProductResponse> product = productBl.productList(Integer.parseInt(subsidiaryId), page, size, order, asc, price,brand);
        return product;
    }

    @GetMapping(path="/{subsidiaryId}/total", produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer getProductTotalBySubsidiary(@PathVariable String subsidiaryId){
        Integer total = productBl.getProductTotalBySubsidiary(Integer.parseInt(subsidiaryId));
        return total;
    }
}
