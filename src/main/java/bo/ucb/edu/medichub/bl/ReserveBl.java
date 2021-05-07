package bo.ucb.edu.medichub.bl;

import bo.ucb.edu.medichub.dao.*;
import bo.ucb.edu.medichub.dto.ProductReserveCarRequest;
import bo.ucb.edu.medichub.dto.ProductReserveRequest;
import bo.ucb.edu.medichub.dto.ProductResponse;
import bo.ucb.edu.medichub.dto.ReserveRequest;
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

        productReserve.setReserveId(lastId);
        productReserve.setProductId(productReserveCarRequest.getProductId());
        productReserve.setQuantity(productReserveCarRequest.getQuantity());
        productReserve.setTransaction(transaction);
        productReserveDao.createProductReserve(productReserve);

        return productReserveCarRequest;
    }

    public List<ProductResponse> productList(Integer clientId, Integer page, Integer size, Integer state) {
        List<ProductResponse> productResponse = new ArrayList<>();
        productResponse = productReserveDao.productListClient(clientId,page,size,state);
        return productResponse;
    }
}
