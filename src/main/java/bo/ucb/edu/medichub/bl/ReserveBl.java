package bo.ucb.edu.medichub.bl;

import bo.ucb.edu.medichub.dao.*;
import bo.ucb.edu.medichub.dto.*;
import bo.ucb.edu.medichub.model.ProductReserve;
import bo.ucb.edu.medichub.model.Reserve;
import bo.ucb.edu.medichub.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReserveBl {
    private ReserveDao reserveDao;
    private ProductReserveDao productReserveDao;
    private TransactionDao transactionDao;

    private static Logger LOGGER = LoggerFactory.getLogger(ReserveBl.class);

    @Autowired
    public ReserveBl(ReserveDao reserveDao, ProductReserveDao productReserveDao, TransactionDao transactionDao) {
        this.reserveDao = reserveDao;
        this.productReserveDao = productReserveDao;
        this.transactionDao = transactionDao;
    }

    public List<ReserveRequest> getListReserve(Integer page, Integer size, Integer state) {
        List<ReserveRequest> reserve = new ArrayList<>();
        List<ReserveRequest> data = new ArrayList<>();
        reserve = reserveDao.getListReserve(page,size,state);
        for(int i=0;i<reserve.size();i++){
            ReserveRequest reserveRequests = new ReserveRequest();
            reserveRequests = reserve.get(i);
            List<ProductReserveRequest> productReserveRequest = new ArrayList<>();
            productReserveRequest = productReserveDao.getListProductReserve(reserveRequests);
            double total = 0;
            for(int j=0;j<productReserveRequest.size();j++){
                ProductReserveRequest product = new ProductReserveRequest();
                product = productReserveRequest.get(j);
                total+=(product.getPrice()*product.getQuantity());
            }
            reserveRequests.setTotal(total);
            reserveRequests.setProduct(productReserveRequest);
            data.add(reserveRequests);
        }
        return data;
    }

    public void manageReserve(ProductReserveCarRequest productReserveCarRequest, Transaction transaction){
        Integer status = reserveDao.getLastReserveStatus(productReserveCarRequest.getClientId());
        if(status == null){
            createReserve(productReserveCarRequest, transaction);
        } else {
            // Creado-Reservado
            if(status == 1){
                LOGGER.error("creado");
                createProductReserve(productReserveCarRequest, transaction);
            }
            // Pendiente-Confirmado-Cancelado
            if(status == 2 || status == 3 || status == 4){
                createReserve(productReserveCarRequest, transaction);
            }
        }
    }

    public ProductReserveCarRequest createReserve(ProductReserveCarRequest productReserveCarRequest,  Transaction transaction){
        Reserve reserve = new Reserve();
        ProductReserve productReserve = new ProductReserve();

        reserve.setClientId(productReserveCarRequest.getClientId());
        reserve.setStatusReserve(1);
        reserve.setDate(new Date());
        reserve.setTransaction(transaction);
        reserveDao.createReserve(reserve);

        Integer lastInsert = transactionDao.getLastInsertId();

        productReserve.setReserveId(lastInsert);
        productReserve.setProductId(productReserveCarRequest.getProductId());
        LOGGER.error(productReserve.getProductId().toString());
        productReserve.setQuantity(productReserveCarRequest.getQuantity());
        productReserve.setTransaction(transaction);
        productReserveDao.createProductReserve(productReserve);

        return productReserveCarRequest;
    }

    public ProductReserveCarRequest createProductReserve(ProductReserveCarRequest productReserveCarRequest, Transaction transaction){
        ProductReserve productReserve = new ProductReserve();

        Integer lastId = reserveDao.getLastReserveId(productReserveCarRequest.getClientId());


        Integer product = productReserveDao.getProductReserveIfExists(productReserveCarRequest.getProductId(), lastId);
        if(product == null){
            productReserve.setReserveId(lastId);
            productReserve.setProductId(productReserveCarRequest.getProductId());
            productReserve.setQuantity(productReserveCarRequest.getQuantity());
            productReserve.setTransaction(transaction);
            productReserveDao.createProductReserve(productReserve);
        } else {
            productReserve.setReserveId(lastId);
            productReserve.setProductId(productReserveCarRequest.getProductId());
            product = product + productReserveCarRequest.getQuantity();
            productReserve.setQuantity(product);
            productReserve.setTransaction(transaction);
            productReserveDao.updateProductReserve(productReserve);
        }

        return productReserveCarRequest;
    }

    public ProductReserveCarRequest updateProductReserve(ProductReserveCarRequest productReserveCarRequest, Transaction transaction){
        ProductReserve productReserve = new ProductReserve();

        Integer lastId = reserveDao.getLastReserveId(productReserveCarRequest.getClientId());

        productReserve.setReserveId(lastId);
        productReserve.setProductId(productReserveCarRequest.getProductId());
        productReserve.setQuantity(productReserveCarRequest.getQuantity());
        productReserve.setTransaction(transaction);
        productReserveDao.updateProductReserve(productReserve);

        return productReserveCarRequest;
    }

    public void deleteProductReserve(Integer productReserveId, Transaction transaction){
        ProductReserve productReserve = new ProductReserve();

        productReserve.setProductReserveId(productReserveId);
        productReserve.setStatus(0);
        productReserve.setTransaction(transaction);
        productReserveDao.deleteProductReserve(productReserve);
    }

    public ProductReserveListRequest productList(Integer clientId, Integer page, Integer size, Integer state) {
        Integer reserveId = reserveDao.getReserveId(clientId,state);
        List<ProductReserveRequest> productReserveRequests = new ArrayList<>();
        productReserveRequests = productReserveDao.reserveProductReserve(reserveId,clientId,state);
        double total=0;
        for (int i=0;i<productReserveRequests.size();i++){
            ProductReserveRequest data = new ProductReserveRequest();
            data = productReserveRequests.get(i);
            total=total+(data.getPrice()*data.getQuantity());
        }
        List<ProductListResponse> productResponse = new ArrayList<>();
        ProductReserveListRequest productReserveListRequest = new ProductReserveListRequest();

        productResponse = productReserveDao.productListClient(clientId,page,size,state);
        productReserveListRequest.setProduct(productResponse);
        productReserveListRequest.setTotal(total);
        productReserveListRequest.setReserveId(reserveId);
        return productReserveListRequest;
    }

    public Integer quantityProductReserve(Integer clientId) {
        return productReserveDao.quantityProductReserve(clientId,1);
    }



    public Integer totalProductReserve(Integer clientId, Integer state) {
        Integer reserveId = reserveDao.getReserveId(clientId,state);
        List<ProductReserveRequest> productReserveRequests = new ArrayList<>();
        productReserveRequests = productReserveDao.reserveProductReserve(reserveId,clientId,state);
        return productReserveRequests.size();
    }

    public void confirmReserve(Integer reserveId, Transaction transaction) {
        Reserve productReserve = new Reserve();
        productReserve.setReserveId(reserveId);
        productReserve.setStatusReserve(3);
        productReserve.setTransaction(transaction);
        reserveDao.updateReserve(productReserve);
    }

    public void deleteClientReserve(Integer reserveId, Transaction transaction) {
        Reserve productReserve = new Reserve();
        productReserve.setReserveId(reserveId);
        productReserve.setStatusReserve(4);
        productReserve.setTransaction(transaction);
        reserveDao.deleteClientReserve(productReserve);
    }


    public List<ReserveListRequest> productClientList(Integer clientId, String page, String size, Integer state) {
        List<ReserveListRequest> reserveListRequests = new ArrayList<>();
        List<ReserveListRequest> data = new ArrayList<>();
        reserveListRequests = reserveDao.getReserveClient(clientId,state,page,size);
        for (int i=0;i<reserveListRequests.size();i++){

            ReserveListRequest reserveListRequest = new ReserveListRequest();
            reserveListRequest = reserveListRequests.get(i);
            System.out.println(reserveListRequest.getReserveId());
            System.out.println(reserveListRequest.getDateReserve());
            List<ProductReserveRequest> productReserveRequests = new ArrayList<>();
            productReserveRequests = productReserveDao.reserveProductReserve(reserveListRequest.getReserveId(),clientId,state);
            double total=0;
            for (int j=0;j<productReserveRequests.size();j++){
                ProductReserveRequest dataFinal = new ProductReserveRequest();
                dataFinal = productReserveRequests.get(j);
                total=total+(dataFinal.getPrice()*dataFinal.getQuantity());
            }
            Integer quantity = productReserveDao.quantityProductReserve(clientId,state);
            List<ProductListResponse> productResponse = new ArrayList<>();
            productResponse = productReserveDao.productReserveListClient(clientId,state,reserveListRequest.getReserveId());
            reserveListRequest.setQuantity(quantity);
            reserveListRequest.setTotal(total);
            reserveListRequest.setProduct(productResponse);
            data.add(reserveListRequest);
        }
        return data;
    }
}
