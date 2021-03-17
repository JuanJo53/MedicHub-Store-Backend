package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.UserLogInRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {

    //public UserLogInRequest loginAd(UserLogInRequest userLogInRequest);

    public UserLogInRequest loginAd(String user, String password);
    //public UserLogInRequest loginAP(String user, String password);
    //public UserLogInRequest loginU(String user, String password);
    //public void createAdmin(Admin admin);


}
