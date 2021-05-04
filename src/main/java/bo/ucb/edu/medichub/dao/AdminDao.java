package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.dto.AdminRequest;
import bo.ucb.edu.medichub.dto.PasswordRequest;
import bo.ucb.edu.medichub.model.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminDao {

    public String passwordAdmin(Integer id);
    public void passwordNewAdmin(PasswordRequest adminPasswordReques);
    public void updateAdmin(Admin admin);
    public AdminRequest findAdminById(Integer adminId);
    public Integer getPersonId(Admin admin);
    public void updateImage(Admin admin);
}
