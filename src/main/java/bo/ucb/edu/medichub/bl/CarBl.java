package bo.ucb.edu.medichub.bl;

import bo.ucb.edu.medichub.dao.ProductReserveDao;
import bo.ucb.edu.medichub.dao.ReserveDao;
import bo.ucb.edu.medichub.dao.TransactionDao;
import bo.ucb.edu.medichub.model.Reserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarBl {
    private ReserveDao reserveDao;
    private ProductReserveDao productReserveDao;
    private TransactionDao transactionDao;

    @Autowired
    public CarBl(ReserveDao reserveDao, ProductReserveDao productReserveDao, TransactionDao transactionDao) {
        this.reserveDao = reserveDao;
        this.productReserveDao = productReserveDao;
        this.transactionDao = transactionDao;
    }
}
