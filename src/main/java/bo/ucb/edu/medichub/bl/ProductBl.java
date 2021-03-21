package bo.ucb.edu.medichub.bl;

import bo.ucb.edu.medichub.dao.ProductDao;
import bo.ucb.edu.medichub.dao.TransactionDao;
import bo.ucb.edu.medichub.dto.ProductRequest;
import bo.ucb.edu.medichub.model.Pharmacy;
import bo.ucb.edu.medichub.model.Product;
import bo.ucb.edu.medichub.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductBl {
    private ProductDao productDao;
    private TransactionDao transactionDao;

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


}
