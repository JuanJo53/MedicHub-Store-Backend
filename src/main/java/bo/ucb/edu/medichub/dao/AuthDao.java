package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.dto.AuthRole;
import bo.ucb.edu.medichub.dto.UserLogInRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthDao {
    public AuthRole getIdPharmacyAdmin(String email, String password);
    public AuthRole getIdAdmin(String email, String password);
    public AuthRole getIdClient(String email, String password);
}
