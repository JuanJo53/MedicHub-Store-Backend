package bo.ucb.edu.medichub.bl;

import bo.ucb.edu.medichub.dao.LoginDao;
import bo.ucb.edu.medichub.dao.TransactionDao;
import bo.ucb.edu.medichub.dto.UserLogInRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginBl {
    private LoginDao loginDao;
    private TransactionDao transactionDao;


    @Autowired
    public LoginBl(LoginDao loginDao, TransactionDao transactionDao) {
        this.loginDao = loginDao;
        this.transactionDao = transactionDao;
    }

    public UserLogInRequest logIn(String user,String password, String type){
        if (type.equals("Admin")){
            System.out.println("entre");
            return loginDao.loginAd(user,password);
        }
        else{
            if(type.equals("adminpharmacy")){
                //return loginDao.loginAP("","");
                return null;
            }
            else{
                if(type.equals("user")){
                    //return loginDao.loginU("","");
                    return null;
                }
                else{
                    return null;
                }
            }
        }
    }


}
















