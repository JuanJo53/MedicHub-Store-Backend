package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.dto.PasswordRequest;
import bo.ucb.edu.medichub.model.Admin;
import bo.ucb.edu.medichub.model.Client;
import bo.ucb.edu.medichub.model.PharmacyAdmin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminDao {

    public String passwordAdmin(Integer id);
    public void passwordNewAdmin(PasswordRequest adminPasswordReques);
}
