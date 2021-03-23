package bo.ucb.edu.medichub.util.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Status 401

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ApiUnauthorized extends Exception{

    public ApiUnauthorized (String message){
        super(message);
    }

}
