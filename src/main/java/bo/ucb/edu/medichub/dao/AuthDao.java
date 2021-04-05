package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.model.Admin;
import bo.ucb.edu.medichub.model.Client;
import bo.ucb.edu.medichub.model.PharmacyAdmin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthDao {
    public PharmacyAdmin findPharmacyAdminByEmail(String email);
    public Admin findAdminByEmail(String email);
    public Client findClientByEmail(String email);
}
