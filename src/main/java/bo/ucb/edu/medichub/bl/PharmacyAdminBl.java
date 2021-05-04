package bo.ucb.edu.medichub.bl;

import bo.ucb.edu.medichub.dao.AuthDao;
import bo.ucb.edu.medichub.dao.PersonDao;
import bo.ucb.edu.medichub.dao.PharmacyAdminDao;
import bo.ucb.edu.medichub.dao.TransactionDao;
import bo.ucb.edu.medichub.dto.PasswordRequest;
import bo.ucb.edu.medichub.dto.PharmacyAdminRequest;
import bo.ucb.edu.medichub.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PharmacyAdminBl {
    private PharmacyAdminDao pharmacyAdminDao;
    private PersonDao personDao;
    private TransactionDao transactionDao;
    private AuthDao authDao;
    private BCryptPasswordEncoder passwordEncoder;

    private static final Logger LOGGER = LoggerFactory.getLogger(PharmacyAdminBl.class);

    @Autowired
    public PharmacyAdminBl(PharmacyAdminDao pharmacyAdminDao, PersonDao personDao, TransactionDao transactionDao, AuthDao authDao,
                           BCryptPasswordEncoder passwordEncoder) {
        this.pharmacyAdminDao = pharmacyAdminDao;
        this.personDao = personDao;
        this.transactionDao = transactionDao;
        this.authDao = authDao;
        this.passwordEncoder = passwordEncoder;
    }

    public PharmacyAdminRequest createPharmacyAdmin(PharmacyAdminRequest pharmacyAdminRequest, Transaction transaction){
        PharmacyAdmin pharmacyAdminPrueb = authDao.findPharmacyAdminByEmail(pharmacyAdminRequest.getEmail());
        Admin admin = authDao.findAdminByEmail(pharmacyAdminRequest.getEmail());
        Client client = authDao.findClientByEmail(pharmacyAdminRequest.getEmail());
        if(pharmacyAdminPrueb == null && admin==null && client==null){
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
            String password = passwordEncoder.encode(pharmacyAdminRequest.getPassword());
            pharmacyAdmin.setPassword(password);
            pharmacyAdmin.setTransaction(transaction);
            pharmacyAdminDao.createPharmacyAdmin(pharmacyAdmin);

            return pharmacyAdminRequest;
        } else {
            return null;
        }
    }


    public PharmacyAdminRequest updatePharmacyAdmin(PharmacyAdminRequest pharmacyAdminRequest, Transaction transaction){
        PharmacyAdmin pharmacyAdmin = new PharmacyAdmin();
        Person person = new Person();

        pharmacyAdmin.setPharmacyAdminId(pharmacyAdminRequest.getPharmacyAdminId());
        pharmacyAdmin.setSubsidiaryId(pharmacyAdminRequest.getSubsidiaryId());
        pharmacyAdmin.setUserName(pharmacyAdminRequest.getUserName());
        pharmacyAdmin.setEmail(pharmacyAdminRequest.getEmail());
        pharmacyAdmin.setTransaction(transaction);
        pharmacyAdminDao.updatePharmacyAdmin(pharmacyAdmin);

        PharmacyAdmin pharmacyAdmin2 = pharmacyAdminDao.getPersonId(pharmacyAdminRequest.getPharmacyAdminId());
        person.setPersonId(pharmacyAdmin2.getPersonId());
        person.setFirstName(pharmacyAdminRequest.getFirstName());
        person.setFirstSurname(pharmacyAdminRequest.getFirstSurname());
        person.setSecondSurname(pharmacyAdminRequest.getSecondSurname());
        person.setCi(pharmacyAdminRequest.getCi());
        person.setPhone(pharmacyAdminRequest.getPhone());
        person.setTransaction(transaction);
        personDao.updatePerson(person);

        return pharmacyAdminRequest;
    }

    public PasswordRequest updateAdminPharmacyPassword(PasswordRequest passwordRequest, Transaction transaction) {

        String passwordAdminPharm = pharmacyAdminDao.passworAdminPharm(passwordRequest.getId());
        if (passwordEncoder.matches(passwordRequest.getOldPassword(),passwordAdminPharm)){
            String passwordNew = passwordEncoder.encode(passwordRequest.getNewPassword());
            passwordRequest.setNewPassword(passwordNew);
            System.out.println("if "+passwordRequest.getOldPassword()+" "+passwordRequest.getNewPassword()+" "+passwordRequest.getId());
            pharmacyAdminDao.updateAdminPharmacyPassword(passwordRequest);
            return passwordRequest;
        }
        else{
            return null;
        }
    }

    public void deletePharmacyAdmin(Integer pharmacyAdminId, Transaction transaction) {
        PharmacyAdmin pharmacyAdmin = new PharmacyAdmin();
        pharmacyAdmin.setStatus(0);
        pharmacyAdmin.setPharmacyAdminId(pharmacyAdminId);
        pharmacyAdmin.setTransaction(transaction);
        pharmacyAdminDao.deletePharmacyAdmin(pharmacyAdmin);
    }

    public PharmacyAdminRequest findAdminById(Integer pharmacyAdminId){
        PharmacyAdminRequest admin = pharmacyAdminDao.findAdminById(pharmacyAdminId);
        return admin;
    }

    public PharmacyAdminRequest updatePharmacyAdminPerson(PharmacyAdminRequest pharmacyAdminRequest, Transaction transaction) {

        PharmacyAdmin pharmacyAdmin = new PharmacyAdmin();
        Person person = new Person();

        pharmacyAdmin.setPharmacyAdminId(pharmacyAdminRequest.getPharmacyAdminId());
        //pharmacyAdmin.setSubsidiaryId(pharmacyAdminRequest.getSubsidiaryId());
        pharmacyAdmin.setUserName(pharmacyAdminRequest.getUserName());
        pharmacyAdmin.setEmail(pharmacyAdminRequest.getEmail());
        pharmacyAdmin.setTransaction(transaction);
        pharmacyAdminDao.updatePharmacyAdminPerson(pharmacyAdmin);

        PharmacyAdmin pharmacyAdmin2 = pharmacyAdminDao.getPersonId(pharmacyAdminRequest.getPharmacyAdminId());
        person.setPersonId(pharmacyAdmin2.getPersonId());
        person.setFirstName(pharmacyAdminRequest.getFirstName());
        person.setFirstSurname(pharmacyAdminRequest.getFirstSurname());
        person.setSecondSurname(pharmacyAdminRequest.getSecondSurname());
        person.setCi(pharmacyAdminRequest.getCi());
        person.setPhone(pharmacyAdminRequest.getPhone());
        person.setTransaction(transaction);
        personDao.updatePerson(person);

        return pharmacyAdminRequest;
    }
}
