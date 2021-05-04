package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.model.Product;
import bo.ucb.edu.medichub.model.ProductPurchase;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductPurchaseDao {
    public void createProductPurchase(ProductPurchase productPurchase);
    public Integer getStockByProductId(Integer productId);
    public void updateStock(Product product);
}
