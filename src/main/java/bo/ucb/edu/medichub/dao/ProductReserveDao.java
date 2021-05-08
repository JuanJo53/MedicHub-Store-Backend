package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.dto.*;
import bo.ucb.edu.medichub.model.ProductReserve;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductReserveDao {
    public void createProductReserve(ProductReserve productReserve);

    public List<ProductReserveRequest> getListProductReserve(ReserveRequest purchaseRequest);

    public List<ProductListResponse> productListClient(Integer clientId, Integer page, Integer size,Integer state);

    public Integer quantityProductReserve(Integer clientId);

    public List<ProductReserveRequest> reserveProductReserve(Integer clientId, Integer state);

    public Integer getProductReserveIfExists(Integer productId, Integer reserveId);

    public void updateProductReserve(ProductReserve productReserve);
}
