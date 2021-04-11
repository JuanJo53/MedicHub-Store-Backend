package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.dto.ProductResponse;
import bo.ucb.edu.medichub.model.Pharmacy;
import bo.ucb.edu.medichub.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductDao {
    public void  createProduct(Product product);

    public void updateProduct(Product product);

    public void deleteProduct(Product product);

    public ProductResponse findProductById(Integer productId);

    public List<ProductResponse> productListOrderById(Integer subsidiaryId, Integer page, Integer size,String price);

    public List<ProductResponse> productListOrderByIdDesc(Integer subsidiaryId, Integer page, Integer size,String price);

    public List<ProductResponse> productListOrderByBrand(Integer subsidiaryId, Integer page, Integer size,String price);

    public List<ProductResponse> productListOrderByBrandDesc(Integer subsidiaryId, Integer page, Integer size,String price);

    public List<ProductResponse> productListOrderByProduct(Integer subsidiaryId, Integer page, Integer size,String price);

    public List<ProductResponse> productListOrderByProductDesc(Integer subsidiaryId, Integer page, Integer size,String price);

    public Integer getProductTotalBySubsidiary(Integer subsidiaryId);
}
