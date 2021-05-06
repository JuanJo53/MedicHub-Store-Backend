package bo.ucb.edu.medichub.bl;

import bo.ucb.edu.medichub.dao.*;
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
            productReserveRequest = reserveDao.getListProductReserve(reserveRequests);
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

    public void manageReserve(ReserveRequest reserveRequest, Transaction transaction){
        Integer status = reserveDao.getLastReserveStatus(reserveRequest.getClientId());
        if(status == null){
            createReserve(reserveRequest, transaction);
        }
        // Creado-Reservado
        if(status == 1 && status != null){

        }
        // Pendiente
        if(status == 2 && status != null){
            createReserve(reserveRequest, transaction);
        }
        // Confirmado-Cancelado
        if((status == 3 || status == 4) && status !=null){
            createReserve(reserveRequest, transaction);
        }
    }

    public ReserveRequest createReserve(ReserveRequest reserveRequest,  Transaction transaction){
        Reserve reserve = new Reserve();
        ProductReserve productReserve = new ProductReserve();

        reserve.setClientId(reserveRequest.getClientId());
        reserve.setStatusReserve(1);
        reserve.setTotalAmount(reserveRequest.getTotal());
        reserve.setDate(new Date());
        reserve.setTransaction(transaction);
        reserveDao.createReserve(reserve);

        Integer lastInsert = transactionDao.getLastInsertId();
        List<ProductReserveRequest> products = reserveRequest.getProduct();

        for(int i=0; i<products.size(); i++){
            productReserve.setReserveId(lastInsert);
            productReserve.setProductId(products.get(i).getProductId());
            LOGGER.error(productReserve.getProductId().toString());
            productReserve.setQuantity(products.get(i).getQuantity());
            productReserve.setTransaction(transaction);
            productReserveDao.createProductReserve(productReserve);
        }

        return reserveRequest;
    }

}
