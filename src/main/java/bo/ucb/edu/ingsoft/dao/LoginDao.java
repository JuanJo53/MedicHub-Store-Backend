package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.UserLogInRequest;
import bo.ucb.edu.ingsoft.model.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {

    public UserLogInRequest login(Admin admin);

    UserLogInRequest login(String user, String password);
    //public void createAdmin(Admin admin);
}
