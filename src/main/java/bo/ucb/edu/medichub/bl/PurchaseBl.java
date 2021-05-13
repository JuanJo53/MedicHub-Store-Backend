package bo.ucb.edu.medichub.bl;

import bo.ucb.edu.medichub.dao.*;
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
    private ProductReserveDao productReserveDao;

    @Autowired
    public PurchaseBl(PurchaseDao purchaseDao, ProductPurchaseDao productPurchaseDao, TransactionDao transactionDao, ProductReserveDao productReserveDao) {
        this.purchaseDao = purchaseDao;
        this.productPurchaseDao = productPurchaseDao;
        this.transactionDao = transactionDao;
        this.productReserveDao = productReserveDao;
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

    public List<Graph> getListPurchaseGraphSubsidiary(Integer subsidiaryId, String init, String end) {
        List<PurchaseListRequest> purchase = purchaseDao.getListPurchase(subsidiaryId,0,999999999);
        List<PurchaseListRequest> purchaseDates = purchaseDao.getListPurchaseDate(subsidiaryId, init, end);
        List<Graph> graph = new ArrayList<>();
        for(int i = 0; i < purchaseDates.size(); i++){
            Integer count = 0;
            Double total = 0.0;
            for(int j = 0; j < purchase.size(); j++){
                if(purchaseDates.get(i).getDatePurchase().compareTo(purchase.get(j).getDatePurchase()) == 0){
                    count ++;
                    total += purchase.get(j).getTotalAmount();
                }
            }
            Graph purchaseGraph = new Graph();
            purchaseGraph.setCount(count);
            purchaseGraph.setDate(purchaseDates.get(i).getDatePurchase());
            purchaseGraph.setTotal(total);
            graph.add(purchaseGraph);
        }
        return graph;
    }
    public List<ProductReserveRepRequest> getSubsidiaryListReportReserve(Integer subsidiaryId, Integer page, Integer size, Boolean asc) {
        List<ProductReserveRepRequest> reserveSubsidiaryRequests = new ArrayList<>();
        List<ProductReserveRepRequest> data = new ArrayList<>();
        if(asc){
            reserveSubsidiaryRequests = productPurchaseDao.getProductSubsidiaryReportAsc(subsidiaryId,page,size);
        }
        if(!asc){
            reserveSubsidiaryRequests = productPurchaseDao.getProductSubsidiaryReportDesc(subsidiaryId,page,size);
        }
        double total=0;
        for(int i=0;i<reserveSubsidiaryRequests.size();i++){
            ProductReserveRepRequest productReserveRepRequest = new ProductReserveRepRequest();
            productReserveRepRequest = reserveSubsidiaryRequests.get(i);
            total=(productReserveRepRequest.getPrice()*productReserveRepRequest.getQuantity());
            productReserveRepRequest.setTotal(total);
            data.add(productReserveRepRequest);
        }
        return data;
    }
    public ProductReportRequest getSubsidiaryListReportStatistics(Integer subsidiaryId) {
        ProductReportRequest productReportRequest = new ProductReportRequest();
        ArrayList<Integer> reserveId = productReserveDao.getPendingSubsidiary(subsidiaryId);
        Integer cantidad=0;
        for (int i=0;i<reserveId.size();i++){
            List<ProductListResponse> productResponse = new ArrayList<>();
            productResponse =productReserveDao.productSubsidiaryReserveListClient(reserveId.get(i),subsidiaryId);
            cantidad =cantidad+ productResponse.size();
        }
        productReportRequest.setPending(cantidad);

        List<ProductReserveRepRequest> reserveSubsidiaryPurchases = new ArrayList<>();
        reserveSubsidiaryPurchases = productPurchaseDao.getProductSubsidiaryReport(subsidiaryId);
        double totalPurchase=0;
        for(int i=0;i<reserveSubsidiaryPurchases.size();i++){
            ProductReserveRepRequest productReserveRepRequest = new ProductReserveRepRequest();
            productReserveRepRequest = reserveSubsidiaryPurchases.get(i);
            totalPurchase=totalPurchase+(productReserveRepRequest.getPrice()*productReserveRepRequest.getQuantity());
        }
        productReportRequest.setGainPurchase(totalPurchase);


        List<ProductReserveRepRequest> reserveSubsidiaryRequests = new ArrayList<>();

        reserveSubsidiaryRequests = productReserveDao.getProductSubsidiaryReports(subsidiaryId);

        double totalReserve=0;
        for(int i=0;i<reserveSubsidiaryRequests.size();i++){
            ProductReserveRepRequest productReserveRepRequest = new ProductReserveRepRequest();
            productReserveRepRequest = reserveSubsidiaryRequests.get(i);
            totalReserve=totalReserve+(productReserveRepRequest.getPrice()*productReserveRepRequest.getQuantity());
        }
        productReportRequest.setGainReserve(totalReserve);

        List<ProductReserveRepRequest> data = getSubsidiaryListReportGeneralReserve(subsidiaryId,0,5,false);
        ProductReserveRepRequest dataFinal = data.get(0);
        productReportRequest.setBestSellingProduct(dataFinal.getName());

        return productReportRequest;
    }


    public List<ProductReserveRepRequest> getSubsidiaryListReportGeneralReserve(Integer subsidiaryId, Integer page, Integer size, Boolean asc) {
        List<ProductReserveRepRequest> reserveSubsidiaryPurchases = new ArrayList<>();
        List<ProductReserveRepRequest> data = new ArrayList<>();
        reserveSubsidiaryPurchases = productPurchaseDao.getProductSubsidiaryReportAsc(subsidiaryId,page,size);
        List<ProductReserveRepRequest> reserveSubsidiaryReserves = new ArrayList<>();
        reserveSubsidiaryReserves = productReserveDao.getProductSubsidiaryReportAsc(subsidiaryId,page,size);
        for (int i=0;i<reserveSubsidiaryPurchases.size();i++){
            ProductReserveRepRequest reserveSubsidiaryPurchase = new ProductReserveRepRequest();
            reserveSubsidiaryPurchase = reserveSubsidiaryPurchases.get(i);
            boolean valida=false;
            double total=0;
            Integer quantity=0;
            for (int j=0;j<reserveSubsidiaryReserves.size();j++){
                ProductReserveRepRequest reserveSubsidiaryReserve = new ProductReserveRepRequest();
                reserveSubsidiaryReserve = reserveSubsidiaryReserves.get(j);
                if(reserveSubsidiaryPurchase.getProductId()==reserveSubsidiaryReserve.getProductId()){
                    total=total+(reserveSubsidiaryReserve.getPrice()*reserveSubsidiaryReserve.getQuantity())+(reserveSubsidiaryPurchase.getPrice()*reserveSubsidiaryPurchase.getQuantity());
                    quantity= quantity + (reserveSubsidiaryPurchase.getQuantity()+reserveSubsidiaryReserve.getQuantity());
                    valida=true;
                    reserveSubsidiaryReserves.remove(j);
                    break;
                }
            }
            if (valida==true){
                reserveSubsidiaryPurchase.setTotal(total);
                reserveSubsidiaryPurchase.setQuantity(quantity);
                data.add(reserveSubsidiaryPurchase);
                reserveSubsidiaryPurchases.remove(i);
                i--;
            }
        }
        for (int i=0;i<reserveSubsidiaryReserves.size();i++){
            ProductReserveRepRequest reserveSubsidiaryReserve = new ProductReserveRepRequest();
            reserveSubsidiaryReserve = reserveSubsidiaryReserves.get(i);
            reserveSubsidiaryReserve.setTotal(reserveSubsidiaryReserve.getPrice()*reserveSubsidiaryReserve.getQuantity());
            data.add(reserveSubsidiaryReserve);
        }
        for (int i=0;i<reserveSubsidiaryPurchases.size();i++){
            ProductReserveRepRequest reserveSubsidiaryPurchase = new ProductReserveRepRequest();
            reserveSubsidiaryPurchase = reserveSubsidiaryPurchases.get(i);
            reserveSubsidiaryPurchase.setTotal(reserveSubsidiaryPurchase.getPrice()*reserveSubsidiaryPurchase.getQuantity());
            data.add(reserveSubsidiaryPurchase);
        }
        List<ProductReserveRepRequest> dataFinal = new ArrayList<>();
        for (int i=0;i<data.size();i++){
            int valor=0;
            ProductReserveRepRequest dataOrderI = new ProductReserveRepRequest();
            dataOrderI = data.get(0);
            int val=dataOrderI.getQuantity();
            for(int j=1;j<data.size();j++){
                ProductReserveRepRequest dataOrderJ = new ProductReserveRepRequest();
                dataOrderJ = data.get(j);
                if(asc){
                    if(val>dataOrderJ.getQuantity()){
                        val=dataOrderJ.getQuantity();
                        valor=j;
                    }
                }
                else{
                    if(val<dataOrderJ.getQuantity()){
                        val=dataOrderJ.getQuantity();
                        valor=j;
                    }
                }

            }
            dataFinal.add(data.get(valor));
            data.remove(valor);
            i--;

        }
        return dataFinal;
    }


}
