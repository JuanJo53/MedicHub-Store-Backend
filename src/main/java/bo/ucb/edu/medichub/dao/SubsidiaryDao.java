package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.dto.PersonListRequest;
import bo.ucb.edu.medichub.dto.ProductListRequest;
import bo.ucb.edu.medichub.dto.SubsidiaryRequest;
import bo.ucb.edu.medichub.dto.SubsidiaryResponse;
import bo.ucb.edu.medichub.model.Subsidiary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubsidiaryDao {
    public void createSubsidiary(Subsidiary subsidiary);
    public void updateSubsidiary(Subsidiary subsidiary);
    public void deleteSubsidiary(Subsidiary subsidiary);
    public SubsidiaryRequest findSubsidiaryById(Integer subsidiaryId);
    public List<ProductListRequest> getProductsBySubsidiary(Integer subsidiaryId);
    public List<PersonListRequest> getAdminsBySubsidiary(Integer subsidiaryId);


    public Integer addressId(Integer subsidiaryId);

    public List<SubsidiaryResponse> getListSubsidiary();
}
