package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.model.ProductReserve;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductReserveDao {
    public void createProductReserve(ProductReserve productReserve);
}
