package bo.ucb.edu.medichub.api;

import bo.ucb.edu.medichub.bl.ProductBl;
import bo.ucb.edu.medichub.bl.TransactionBl;
import bo.ucb.edu.medichub.dto.ProductRequest;
import bo.ucb.edu.medichub.model.Transaction;
import bo.ucb.edu.medichub.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
    public ProductRequest createProduct(@RequestBody ProductRequest productRequest, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        ProductRequest productResponse = productBl.createProduct(productRequest, transaction);
        return productResponse;
    }
}
