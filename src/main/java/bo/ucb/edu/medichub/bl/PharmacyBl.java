package bo.ucb.edu.medichub.bl;

import bo.ucb.edu.medichub.dao.PharmacyDao;
import bo.ucb.edu.medichub.dao.TransactionDao;
import bo.ucb.edu.medichub.dto.PharmacyRequest;
import bo.ucb.edu.medichub.model.Pharmacy;
import bo.ucb.edu.medichub.model.Transaction;
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


    public void deletePharmacy(Integer idPharmacy, Transaction transaction){
        Pharmacy pharmacy= new Pharmacy();
        pharmacy.setStatus(0);
        pharmacy.setPharmacyId(idPharmacy);
        pharmacy.setTransaction(transaction);
        pharmacyDao.deletePharmacy(pharmacy);
    }


}







