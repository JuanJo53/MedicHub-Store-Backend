package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.model.Brand;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BrandDao {
    public void createBrand(Brand brand);
}
