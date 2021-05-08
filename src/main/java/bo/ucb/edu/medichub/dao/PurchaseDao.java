package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.dto.PurchaseListRequest;
import bo.ucb.edu.medichub.dto.PurchaseRequest;
import bo.ucb.edu.medichub.model.Purchase;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PurchaseDao {
    public void createPurchase(Purchase purchase);
    public List<PurchaseListRequest>  getListPurchase(Integer subsidiaryId,Integer page, Integer size);
}
