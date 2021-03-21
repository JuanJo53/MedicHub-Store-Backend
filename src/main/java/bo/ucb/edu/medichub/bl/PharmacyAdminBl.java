package bo.ucb.edu.medichub.bl;

import bo.ucb.edu.medichub.dao.PersonDao;
import bo.ucb.edu.medichub.dao.PharmacyAdminDao;
import bo.ucb.edu.medichub.dao.TransactionDao;
import bo.ucb.edu.medichub.dto.PharmacyAdminRequest;
import bo.ucb.edu.medichub.model.Person;
import bo.ucb.edu.medichub.model.PharmacyAdmin;
import bo.ucb.edu.medichub.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmacyAdminBl {
    private PharmacyAdminDao pharmacyAdminDao;
    private PersonDao personDao;
    private TransactionDao transactionDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(PharmacyAdminBl.class);

    @Autowired
    public PharmacyAdminBl(PharmacyAdminDao pharmacyAdminDao, PersonDao personDao, TransactionDao transactionDao) {
        this.pharmacyAdminDao = pharmacyAdminDao;
        this.personDao = personDao;
        this.transactionDao = transactionDao;
    }

    public PharmacyAdminRequest createPharmacyAdmin(PharmacyAdminRequest pharmacyAdminRequest, Transaction transaction){
        PharmacyAdmin pharmacyAdmin = new PharmacyAdmin();
        Person person = new Person();

        person.setFirstName(pharmacyAdminRequest.getFirstName());
        person.setFirstSurname(pharmacyAdminRequest.getFirstSurname());
        person.setSecondSurname(pharmacyAdminRequest.getSecondSurname());
        person.setCi(pharmacyAdminRequest.getCi());
        person.setPhone(pharmacyAdminRequest.getPhone());
        person.setTransaction(transaction);
        personDao.createPerson(person);
        Integer getLastIdPerson = transactionDao.getLastInsertId();

        pharmacyAdmin.setPersonId(getLastIdPerson);
        pharmacyAdmin.setSubsidiaryId(pharmacyAdminRequest.getSubsidiaryId());
        pharmacyAdmin.setEmail(pharmacyAdminRequest.getEmail());
        pharmacyAdmin.setUserName(pharmacyAdminRequest.getUserName());
        pharmacyAdmin.setPassword(pharmacyAdminRequest.getPassword());
        pharmacyAdmin.setTransaction(transaction);
        pharmacyAdminDao.createPharmacyAdmin(pharmacyAdmin);

        return pharmacyAdminRequest;

    }
}
