package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.dto.PharmacyAdminRequest;
import bo.ucb.edu.medichub.model.PharmacyAdmin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PharmacyAdminDao {
    public void createPharmacyAdmin(PharmacyAdmin pharmacyAdmin);

    public void updatePharmacyAdmin(PharmacyAdmin pharmacyAdmin);

    public void deletePharmacyAdmin(PharmacyAdmin pharmacyAdmin);

    public PharmacyAdminRequest findAdminById(Integer pharmacyId);
}
