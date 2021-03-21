package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.dto.ProductListRequest;
import bo.ucb.edu.medichub.dto.SubsidiaryRequest;
import bo.ucb.edu.medichub.model.Subsidiary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubsidiaryDao {
    public void createSubsidiary(Subsidiary subsidiary);
    public SubsidiaryRequest findSubsidiaryById(Integer subsidiaryId);
    public List<ProductListRequest> getProductsBySubsidiary(Integer subsidiaryId);
}
