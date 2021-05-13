package bo.ucb.edu.medichub.bl;

import bo.ucb.edu.medichub.dao.ProductPurchaseDao;
import bo.ucb.edu.medichub.dao.PurchaseDao;
import bo.ucb.edu.medichub.dao.TransactionDao;
import bo.ucb.edu.medichub.dto.*;
import bo.ucb.edu.medichub.model.Product;
import bo.ucb.edu.medichub.model.ProductPurchase;
import bo.ucb.edu.medichub.model.Purchase;
import bo.ucb.edu.medichub.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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

        purchase.setPurchaseDate(new Date());
        purchase.setTotalAmount(purchaseRequest.getTotalAmount());
        purchase.setFirstSurname(purchaseRequest.getFirstSurname());
        purchase.setNit(purchaseRequest.getNit());
        purchase.setTransaction(transaction);
        purchaseDao.createPurchase(purchase);

        Integer lastInsertId = transactionDao.getLastInsertId();
        List<ProductTransactionRequest> products = purchaseRequest.getProducts();

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

    public List<PurchaseListRequest> getListPurchaseSubsidiary(Integer subsidiaryId,Integer page, Integer size) {
        List<PurchaseListRequest> purchase = new ArrayList<>();
        purchase = purchaseDao.getListPurchase(subsidiaryId,page,size);
        List<PurchaseListRequest> data = new ArrayList<>();
        for(int i=0;i<purchase.size();i++){
            PurchaseListRequest purchaseListRequest = new PurchaseListRequest();
            purchaseListRequest=purchase.get(i);
            List<ProductListResponse> productPurchaseListRequests = productPurchaseDao.getListProductPurchase(purchaseListRequest);
            purchaseListRequest.setProducts(productPurchaseListRequests);
            purchaseListRequest.setSize(purchase.size());
            data.add(purchaseListRequest);
        }
        return data;
    }

    public List<PurchaseGraph> getListPurchaseGraphSubsidiary(Integer subsidiaryId,String init, String end) {
        List<PurchaseListRequest> purchase = purchaseDao.getListPurchase(subsidiaryId,0,999999999);
        List<PurchaseListRequest> purchaseDates = purchaseDao.getListPurchaseDate(subsidiaryId, init, end);
        List<PurchaseGraph> graph = new ArrayList<>();
        for(int i = 0; i < purchaseDates.size(); i++){
            Integer count = 0;
            Double total = 0.0;
            for(int j = 0; j < purchase.size(); j++){
                if(purchaseDates.get(i).getDatePurchase().compareTo(purchase.get(j).getDatePurchase()) == 0){
                    count ++;
                    total += purchase.get(j).getTotalAmount();
                }
            }
            PurchaseGraph purchaseGraph = new PurchaseGraph();
            purchaseGraph.setCount(count);
            purchaseGraph.setDate(purchaseDates.get(i).getDatePurchase());
            purchaseGraph.setTotal(total);
            graph.add(purchaseGraph);
        }
        return graph;
    }
}
