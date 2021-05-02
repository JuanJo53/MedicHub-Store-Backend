package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.model.Purchase;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PurchaseDao {
    public void createPurchase(Purchase purchase);
}
