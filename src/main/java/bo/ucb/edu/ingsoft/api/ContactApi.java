package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.AgendaBl;
import bo.ucb.edu.ingsoft.dto.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/contact")
public class ContactApi {

    private AgendaBl agendaBl;

    @Autowired
    public ContactApi(AgendaBl agendaBl) {
        this.agendaBl = agendaBl;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Contact findById() {
        return agendaBl.findContactById(0);
    }
}
