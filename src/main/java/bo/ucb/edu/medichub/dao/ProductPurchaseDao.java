package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.dto.ProductListResponse;
import bo.ucb.edu.medichub.dto.ProductReserveRepRequest;
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
    public List<ProductListResponse> getListProductPurchase(PurchaseListRequest purchaseListRequest);

    public List<ProductReserveRepRequest> getProductSubsidiaryReportAsc(Integer subsidiaryId, Integer page, Integer size);

    public List<ProductReserveRepRequest> getProductSubsidiaryReportDesc(Integer subsidiaryId, Integer page, Integer size);

    public List<ProductReserveRepRequest> getProductSubsidiaryReport(Integer subsidiaryId);
}
