package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.dto.*;
import bo.ucb.edu.medichub.model.ProductReserve;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductReserveDao {
    public void createProductReserve(ProductReserve productReserve);

    public List<ProductReserveRequest> getListProductReserve(ReserveRequest purchaseRequest);

    public List<ProductResponse> productListClient(Integer clientId, Integer page, Integer size,Integer state);
}
