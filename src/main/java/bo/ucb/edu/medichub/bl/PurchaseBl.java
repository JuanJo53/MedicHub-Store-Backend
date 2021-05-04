package bo.ucb.edu.medichub.bl;

import bo.ucb.edu.medichub.dao.ProductPurchaseDao;
import bo.ucb.edu.medichub.dao.PurchaseDao;
import bo.ucb.edu.medichub.dao.TransactionDao;
import bo.ucb.edu.medichub.dto.ProductPurchaseRequest;
import bo.ucb.edu.medichub.dto.PurchaseRequest;
import bo.ucb.edu.medichub.model.Product;
import bo.ucb.edu.medichub.model.ProductPurchase;
import bo.ucb.edu.medichub.model.Purchase;
import bo.ucb.edu.medichub.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseBl {
    private PurchaseDao purchaseDao;
    private ProductPurchaseDao productPurchaseDao;
    private TransactionDao transactionDao;

    @Autowired
    public PurchaseBl(PurchaseDao purchaseDao, ProductPurchaseDao productPurchaseDao, TransactionDao transactionDao) {
        this.purchaseDao = purchaseDao;
        this.productPurchaseDao = productPurchaseDao;
        this.transactionDao = transactionDao;
    }

    public PurchaseRequest createPurchase(PurchaseRequest purchaseRequest, Transaction transaction){
        Purchase purchase = new Purchase();
        ProductPurchase productPurchase = new ProductPurchase();

        purchase.setPurchaseDate(purchaseRequest.getPurchaseDate());
        purchase.setTotalAmount(purchaseRequest.getTotalAmount());
        purchase.setTransaction(transaction);
        purchaseDao.createPurchase(purchase);

        Integer lastInsertId = transactionDao.getLastInsertId();
        List<ProductPurchaseRequest> products = purchaseRequest.getProducts();

        for(int i = 0; i < products.size(); i++){
            Product product = new Product();

            Integer stock = productPurchaseDao.getStockByProductId(products.get(i).getProductId());
            stock = stock - products.get(i).getQuantity();
            product.setProductId(products.get(i).getProductId());
            product.setStock(stock);
            productPurchaseDao.updateStock(product);

            productPurchase.setPurchaseId(lastInsertId);
            productPurchase.setProductId(products.get(i).getProductId());
            productPurchase.setQuantity(products.get(i).getQuantity());
            productPurchase.setTransaction(transaction);
            productPurchaseDao.createProductPurchase(productPurchase);
        }

        return purchaseRequest;
    }
}
