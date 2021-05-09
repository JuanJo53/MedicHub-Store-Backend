package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.dto.ProductPurchaseListRequest;
import bo.ucb.edu.medichub.dto.PurchaseListRequest;
import bo.ucb.edu.medichub.model.Product;
import bo.ucb.edu.medichub.model.ProductPurchase;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductPurchaseDao {
    public void createProductPurchase(ProductPurchase productPurchase);
    public Integer getStockByProductId(Integer productId);
    public void updateStock(Product product);
    public List<ProductPurchaseListRequest> getListProductPurchase(PurchaseListRequest purchaseListRequest);
}
