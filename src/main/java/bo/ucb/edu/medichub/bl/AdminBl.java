package bo.ucb.edu.medichub.bl;

import bo.ucb.edu.medichub.dao.AdminDao;
import bo.ucb.edu.medichub.dao.AuthDao;
import bo.ucb.edu.medichub.dao.PersonDao;
import bo.ucb.edu.medichub.dao.TransactionDao;
import bo.ucb.edu.medichub.dto.AdminRequest;
import bo.ucb.edu.medichub.dto.PasswordRequest;
import bo.ucb.edu.medichub.model.Admin;
import bo.ucb.edu.medichub.model.Person;
import bo.ucb.edu.medichub.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminBl {

    private AdminDao adminDao;
    private TransactionDao transactionDao;
    private PersonDao personDao;
    private BCryptPasswordEncoder passwordEncoder;

    private static final Logger LOGGER = LoggerFactory.getLogger(PharmacyAdminBl.class);

    @Autowired
    public AdminBl(AdminDao adminDao, TransactionDao transactionDao, PersonDao personDao, BCryptPasswordEncoder passwordEncoder) {
        this.adminDao = adminDao;
        this.transactionDao = transactionDao;
        this.personDao = personDao;
        this.passwordEncoder = passwordEncoder;
    }


    public PasswordRequest updatepasswordAdmin(PasswordRequest adminPasswordReques, Transaction transaction) {

        String passwordClient = adminDao.passwordAdmin(adminPasswordReques.getId());
        if (passwordEncoder.matches(adminPasswordReques.getOldPassword(),passwordClient)){
            String passwordNew = passwordEncoder.encode(adminPasswordReques.getNewPassword());
            adminPasswordReques.setNewPassword(passwordNew);
            adminDao.passwordNewAdmin(adminPasswordReques);
            return adminPasswordReques;
        }
        else{
            return null;
        }
    }

    public AdminRequest updateAdmin(AdminRequest adminRequest, Transaction transaction) {
        Admin admin = new Admin();
        Person person = new Person();

        admin.setAdminId(adminRequest.getAdminId());
        admin.setEmail(adminRequest.getEmail());
        admin.setUserName(adminRequest.getUserName());
        admin.setTransaction(transaction);
        adminDao.updateAdmin(admin);
        Integer idPerson = adminDao.getPersonId(admin);

        person.setPersonId(idPerson);
        person.setFirstName(adminRequest.getFirstName());
        person.setFirstSurname(adminRequest.getFirstSurname());
        person.setSecondSurname(adminRequest.getSecondSurname());
        person.setCi(adminRequest.getCi());
        person.setPhone(adminRequest.getPhone());
        person.setTransaction(transaction);
        personDao.updatePerson(person);

        return adminRequest;
    }
}
