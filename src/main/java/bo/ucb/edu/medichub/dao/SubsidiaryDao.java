package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.model.Subsidiary;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubsidiaryDao {
    public void createSubsidiary(Subsidiary subsidiary);
}
