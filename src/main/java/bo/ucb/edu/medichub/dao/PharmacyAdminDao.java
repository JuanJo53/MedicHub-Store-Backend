package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.model.PharmacyAdmin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PharmacyAdminDao {
    public void createPharmacyAdmin(PharmacyAdmin pharmacyAdmin);

    public void updatePharmacyAdmin(PharmacyAdmin pharmacyAdmin);

    void deletePharmacyAdmin(PharmacyAdmin pharmacyAdmin);
}
