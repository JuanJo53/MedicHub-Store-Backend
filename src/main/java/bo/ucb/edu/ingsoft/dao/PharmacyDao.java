package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.Pharmacy;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PharmacyDao {
    public void createPharmacy(Pharmacy pharmacy);
}
