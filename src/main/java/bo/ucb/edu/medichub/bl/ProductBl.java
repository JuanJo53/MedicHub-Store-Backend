package bo.ucb.edu.medichub.bl;

import bo.ucb.edu.medichub.dao.ProductDao;
import bo.ucb.edu.medichub.dao.TransactionDao;
import bo.ucb.edu.medichub.dto.ProductRequest;
import bo.ucb.edu.medichub.dto.ProductResponse;
import bo.ucb.edu.medichub.model.Pharmacy;
import bo.ucb.edu.medichub.model.Product;
import bo.ucb.edu.medichub.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductBl {
    private ProductDao productDao;
    private TransactionDao transactionDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductBl.class);

    @Autowired
    public ProductBl(ProductDao productDao, TransactionDao transactionDao) {
        this.productDao = productDao;
        this.transactionDao = transactionDao;
    }

    public ProductRequest createProduct(ProductRequest productRequest, Transaction transaction){
        Product product = new Product();
        product.setSubsidiaryId(productRequest.getSubsidiaryId());
        product.setBrandId(productRequest.getBrandId());
        product.setName(productRequest.getName());
        product.setStock(productRequest.getStock());
        product.setPrice(productRequest.getPrice());
        product.setType(productRequest.getType());
        product.setDose(productRequest.getDose());
        product.setDescription(productRequest.getDescription());
        product.setTransaction(transaction);
        productDao.createProduct(product);
        return productRequest;
    }


    public ProductRequest updateProduct(ProductRequest productRequest, Transaction transaction){
        Product product = new Product();
        product.setProductId(productRequest.getProductId());
        product.setSubsidiaryId(productRequest.getSubsidiaryId());
        product.setBrandId(productRequest.getBrandId());
        product.setName(productRequest.getName());
        product.setStock(productRequest.getStock());
        product.setPrice(productRequest.getPrice());
        product.setType(productRequest.getType());
        product.setDose(productRequest.getDose());
        product.setDescription(productRequest.getDescription());
        product.setTransaction(transaction);
        productDao.updateProduct(product);
        return productRequest;
    }

    public void deleteProduct(Integer idProduct, Transaction transaction){
        Product product= new Product();
        product.setStatus(0);
        product.setProductId(idProduct);
        product.setTransaction(transaction);
        productDao.deleteProduct(product);
    }

    public ProductResponse findProductById(Integer productId){
        ProductResponse product = productDao.findProductById(productId);
        return  product;
    }

    public List<ProductResponse> productList(Integer subsidiaryId, Integer page, Integer size, String order, Boolean asc){

        List<ProductResponse> products = new ArrayList<>();
        LOGGER.error(String.valueOf(page));
        LOGGER.error(String.valueOf(size));
        LOGGER.error(order);
        LOGGER.error(asc.toString());
        if(order.equals("id") && asc){
            products = productDao.productListOrderById(subsidiaryId, page, size);
        }
        if(order.equals("id") && !asc){
            products = productDao.productListOrderByIdDesc(subsidiaryId, page, size);
        }
        if(order.equals("brand") && asc){
            products = productDao.productListOrderByBrand(subsidiaryId, page, size);
        }
        if(order.equals("brand") && !asc){
            products = productDao.productListOrderByBrandDesc(subsidiaryId, page, size);
        }
        if(order.equals("name") && asc){
            products = productDao.productListOrderByProduct(subsidiaryId, page, size);
        }
        if(order.equals("name") && !asc){
            products = productDao.productListOrderByProductDesc(subsidiaryId, page, size);
        }
        return products;
    }

    public Integer getProductTotalBySubsidiary(Integer subsidiaryId){
        Integer total = productDao.getProductTotalBySubsidiary(subsidiaryId);
        return total;
    }
}
