package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.ContactDao;
import bo.ucb.edu.ingsoft.dto.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaBl {
    private ContactDao contactDao;

    @Autowired
    public AgendaBl(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public Contact findContactById(Integer contactId) {
        return  contactDao.findByContactId(contactId);
    }
}
