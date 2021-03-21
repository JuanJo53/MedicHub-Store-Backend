package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.model.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDao {
    public void  createProduct(Product product);
}
