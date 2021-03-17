package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.model.Pharmacy;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PharmacyDao {
    public void createPharmacy(Pharmacy pharmacy);

    public void updatePharmacy(Pharmacy pharmacy);
    public void deletePharmacy(Pharmacy pharmacy);

}


