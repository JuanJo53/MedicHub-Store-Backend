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

    public List<ProductResponse> productListOrderById(Integer subsidiaryId, Integer page, Integer size,String price,String brand);

    public List<ProductResponse> productListOrderByIdDesc(Integer subsidiaryId, Integer page, Integer size,String price,String brand);

    public List<ProductResponse> productListOrderByBrand(Integer subsidiaryId, Integer page, Integer size,String price,String brand);

    public List<ProductResponse> productListOrderByBrandDesc(Integer subsidiaryId, Integer page, Integer size,String price,String brand);

    public List<ProductResponse> productListOrderByProduct(Integer subsidiaryId, Integer page, Integer size,String price,String brand);

    public List<ProductResponse> productListOrderByProductDesc(Integer subsidiaryId, Integer page, Integer size,String price,String brand);

    public Integer getProductTotalBySubsidiary(Integer subsidiaryId);



    public List<ProductResponse> productListOrderByPrice(Integer subsidiaryId, Integer page, Integer size, String value);
    public List<ProductResponse> productListOrderByPriceDesc(Integer subsidiaryId, Integer page, Integer size, String value);
    public List<ProductResponse> productListOrderByName(Integer subsidiaryId, Integer page, Integer size, String value);
    public List<ProductResponse> productListOrderByNameDesc(Integer subsidiaryId, Integer page, Integer size, String value);
    public List<ProductResponse> productListOrderByMedic(Integer subsidiaryId, Integer page, Integer size, String value);
    public List<ProductResponse> productListOrderByMedicDesc(Integer subsidiaryId, Integer page, Integer size, String value);
    public List<ProductResponse> productListOrderByDose(Integer subsidiaryId, Integer page, Integer size, String value);
    public List<ProductResponse> productListOrderByDoseDesc(Integer subsidiaryId, Integer page, Integer size, String value);
    public List<ProductResponse> productListOrderByBrands(Integer subsidiaryId, Integer page, Integer size, String value);
    public List<ProductResponse> productListOrderByBrandsDesc(Integer subsidiaryId, Integer page, Integer size, String value);
    public List<ProductResponse> productListOrderByAll(Integer subsidiaryId, Integer page, Integer size, String value);
    public List<ProductResponse> productListOrderByAllDesc(Integer subsidiaryId, Integer page, Integer size, String value);
}
