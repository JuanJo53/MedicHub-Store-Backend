package bo.ucb.edu.medichub.bl;

import bo.ucb.edu.medichub.dao.AuthDao;
import bo.ucb.edu.medichub.dao.PharmacyDao;
import bo.ucb.edu.medichub.dao.TransactionDao;
import bo.ucb.edu.medichub.dto.*;
import bo.ucb.edu.medichub.model.Pharmacy;
import bo.ucb.edu.medichub.model.Transaction;
import bo.ucb.edu.medichub.util.ImageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class PharmacyBl {
    private PharmacyDao pharmacyDao;
    private TransactionDao transactionDao;
    private AuthDao authDao;
    private BCryptPasswordEncoder passwordEncoder;

    private static final Logger LOGGER = LoggerFactory.getLogger(BankAccountBl.class);

    @Autowired
    public PharmacyBl(PharmacyDao pharmacyDao, TransactionDao transactionDao,AuthDao authDao, BCryptPasswordEncoder passwordEncoder) {
        this.pharmacyDao = pharmacyDao;
        this.transactionDao = transactionDao;
        this.authDao = authDao;
        this.passwordEncoder=passwordEncoder;
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

    public List<PharmacyListRequest> getPharmacies(){
        List<PharmacyListRequest> pharmacies = pharmacyDao.getPharmacies();;
        return pharmacies;
    }

    public PharmacyRequest findPharmacyById(Integer pharmacyId){
        PharmacyRequest pharmacyRequest = pharmacyDao.findPharmacyById(pharmacyId);
        return  pharmacyRequest;
    }

    public List<BankAccountListRequest> getPharmacyBankAccounts(Integer pharmacyId){
        List<BankAccountListRequest> bankAccounts = pharmacyDao.getPharmacyBankAccounts(pharmacyId);
        return bankAccounts;
    }

    public List<SubsidiaryListRequest> getSubsidariesByPharmacy(Integer pharmacyId){
        List<SubsidiaryListRequest> subsidaries = pharmacyDao.getSubsidiariesByPharmacy(pharmacyId);
        return subsidaries;
    }

    public List<PersonListRequest> getAdminsByPharmacy(Integer pharmacyId){
        List<PersonListRequest> admins = pharmacyDao.getAdminsByPharmacy(pharmacyId);
        return admins;
    }

    public void uploadImage(MultipartFile image, Integer pharmacyId, Transaction transaction){
        ImageUtil imageUtil = new ImageUtil();
        Pharmacy pharmacy = new Pharmacy();
        String newImageName = imageUtil.uploadImage(image,"images/pharmacyImage","Pharmacy",pharmacyId);
        pharmacy.setPharmacyId(pharmacyId);
        pharmacy.setPicture(newImageName);
        pharmacy.setTransaction(transaction);
        pharmacyDao.updateImage(pharmacy);
    }

}







