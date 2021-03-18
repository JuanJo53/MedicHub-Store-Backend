package bo.ucb.edu.medichub.api;

import bo.ucb.edu.medichub.bl.LoginBl;
import bo.ucb.edu.medichub.bl.TransactionBl;
import bo.ucb.edu.medichub.dto.UserLogInRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/logIn")
public class LoginApi {
    private LoginBl loginBl;
    private TransactionBl transactionBl;

    private static final Logger LOGGER = LoggerFactory.getLogger(PharmacyApi.class);

    @Autowired
    public LoginApi(LoginBl loginBl, TransactionBl transactionBl) {
        this.loginBl = loginBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserLogInRequest userlogin(@RequestParam String user, String password, String type){
        return loginBl.logIn(user,password,type);
    }





}
