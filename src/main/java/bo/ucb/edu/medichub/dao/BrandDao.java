package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.dto.BrandListRequest;
import bo.ucb.edu.medichub.dto.BrandRequest;
import bo.ucb.edu.medichub.model.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrandDao {
    public void createBrand(Brand brand);
    public void updateBrand(Brand brand);
    public List<BrandListRequest> getBrands();
    public BrandRequest findBrandById(Integer brandId);
}
