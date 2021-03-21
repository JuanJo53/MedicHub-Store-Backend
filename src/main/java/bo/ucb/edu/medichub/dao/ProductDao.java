package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.model.Pharmacy;
import bo.ucb.edu.medichub.model.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDao {
    public void  createProduct(Product product);

    public void updateProduct(Product product);

    public void deleteProduct(Product product);
}
