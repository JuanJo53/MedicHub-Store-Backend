package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.PharmacyDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.PharmacyRequest;
import bo.ucb.edu.ingsoft.model.Pharmacy;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
        if (pharmacyRequest.getName()!=null && pharmacyRequest.getEmail()!=null && pharmacyRequest.getPhone()!=null && transaction!=null && pharmacyRequest.getName()!="" && pharmacyRequest.getEmail()!="" && pharmacyRequest.getPhone()!=""){
            pharmacy.setName(pharmacyRequest.getName());
            pharmacy.setEmail(pharmacyRequest.getEmail());
            pharmacy.setPhone(pharmacyRequest.getPhone());
            pharmacy.setTransaction(transaction);
            pharmacyDao.createPharmacy(pharmacy);
            return pharmacyRequest;
        }
        else{
            return null;
        }

    }

    public PharmacyRequest updatePharmacy(PharmacyRequest pharmacyRequest, Transaction transaction){
        Pharmacy pharmacy=new Pharmacy();
        pharmacy.setEmail(pharmacyRequest.getEmail());
        pharmacy.setName(pharmacyRequest.getName());
        pharmacy.setPhone(pharmacyRequest.getPhone());
        pharmacy.setPharmacyId(pharmacyRequest.getPharmacyId());
        pharmacy.setTransaction(transaction);
        pharmacyDao.updatePharmacy(pharmacy);
        return pharmacyRequest;
    }


    public void deletePharmacy(Integer IdPharmacy, Transaction transaction){
        Pharmacy pharmacy= new Pharmacy();
        pharmacy.setStatus(0);
        pharmacy.setPharmacyId(IdPharmacy);
        pharmacy.setTransaction(transaction);
        pharmacyDao.deletePharmacy(pharmacy);
    }


}







