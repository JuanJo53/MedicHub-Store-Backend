package bo.ucb.edu.medichub.util.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Status 404

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApiNotFound extends Exception{

    public ApiNotFound(String message){
        super(message);
    }

}
