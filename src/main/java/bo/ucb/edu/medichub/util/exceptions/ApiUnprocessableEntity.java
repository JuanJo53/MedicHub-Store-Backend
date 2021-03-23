package bo.ucb.edu.medichub.util.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Status 422

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ApiUnprocessableEntity extends Exception {

    public ApiUnprocessableEntity(String message) {
        super(message);
    }

}
