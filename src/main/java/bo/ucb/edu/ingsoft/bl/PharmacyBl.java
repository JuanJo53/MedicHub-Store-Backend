package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.PharmacyDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.PharmacyRequest;
import bo.ucb.edu.ingsoft.model.Pharmacy;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmacyBl {
    private PharmacyDao pharmacyDao;
    private TransactionDao transactionDao;

    @Autowired
    public PharmacyBl(PharmacyDao pharmacyDao, TransactionDao transactionDao) {
        this.pharmacyDao = pharmacyDao;
        this.transactionDao = transactionDao;
    }

    public PharmacyRequest createPharmacy(PharmacyRequest pharmacyRequest, Transaction transaction){
        Pharmacy pharmacy = new Pharmacy();

        pharmacy.setName(pharmacyRequest.getName());
        pharmacy.setEmail(pharmacyRequest.getEmail());
        pharmacy.setPhone(pharmacyRequest.getPhone());
        pharmacy.setTransaction(transaction);
        pharmacyDao.createPharmacy(pharmacy);

        return pharmacyRequest;
    }
}
