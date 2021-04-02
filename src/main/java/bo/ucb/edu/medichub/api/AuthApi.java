package bo.ucb.edu.medichub.api;

import bo.ucb.edu.medichub.bl.TransactionBl;
import bo.ucb.edu.medichub.bl.UserService;
import bo.ucb.edu.medichub.dto.AuthenticationRequest;
import bo.ucb.edu.medichub.dto.AuthenticationResponse;
import bo.ucb.edu.medichub.model.Transaction;
import bo.ucb.edu.medichub.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
/*import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/auth")
public class AuthApi {

    @Autowired
    private TransactionBl transactionBl;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletRequest request){
        userService.loadAuth(authenticationRequest);
    }

}*/
