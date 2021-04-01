package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.model.Admin;
import bo.ucb.edu.medichub.model.Client;
import bo.ucb.edu.medichub.model.PharmacyAdmin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthDao {
    public PharmacyAdmin findPharmacyAdminById(String email);
    public Admin findAdminById(String email);
    public Client findClientById(String email);
}
