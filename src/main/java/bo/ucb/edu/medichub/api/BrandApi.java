package bo.ucb.edu.medichub.api;

import bo.ucb.edu.medichub.bl.BrandBl;
import bo.ucb.edu.medichub.bl.TransactionBl;
import bo.ucb.edu.medichub.dto.BrandListRequest;
import bo.ucb.edu.medichub.dto.BrandRequest;
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
@RequestMapping(value = "/brand")
public class BrandApi {
    private BrandBl brandBl;
    private TransactionBl transactionBl;

    @Autowired
    public BrandApi(BrandBl brandBl, TransactionBl transactionBl) {
        this.brandBl = brandBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus createSubsidiary(@Valid @RequestBody BrandRequest brandRequest, HttpServletRequest request,
                                         BindingResult result) {
        if(!result.hasErrors()){
            Transaction transaction = TransactionUtil.createTransaction(request);
            transactionBl.createTransaction(transaction);
            BrandRequest brandResponse = brandBl.createBrand(brandRequest, transaction);
            return HttpStatus.OK;
        } else {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus updateSubsidiary(@Valid @RequestBody BrandRequest brandRequest, HttpServletRequest request,
                                         BindingResult result) {
        if (!result.hasErrors()){
            Transaction transaction = TransactionUtil.createTransaction(request);
            transactionBl.createTransaction(transaction);
            BrandRequest brandResponse = brandBl.updateBrand(brandRequest, transaction);
            return HttpStatus.OK;
        } else {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @DeleteMapping(path="/{brandId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus deletePharmacy(@PathVariable String brandId, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        brandBl.deletePharmacy(Integer.parseInt(brandId),transaction);
        return HttpStatus.ACCEPTED;
    }

    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BrandListRequest> getBrands() {
        List<BrandListRequest> brands = brandBl.getBrands();
        return brands;
    }

    @GetMapping(path="/{brandId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BrandRequest findBrandById(@PathVariable String brandId){
        BrandRequest brand = brandBl.findBrandById(Integer.parseInt(brandId));
        return brand;
    }
}
