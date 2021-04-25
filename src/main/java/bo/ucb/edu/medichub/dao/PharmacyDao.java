package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.dto.*;
import bo.ucb.edu.medichub.model.Pharmacy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PharmacyDao {
    public void createPharmacy(Pharmacy pharmacy);
    public void updatePharmacy(Pharmacy pharmacy);
    public void deletePharmacy(Pharmacy pharmacy);
    public List<PharmacyListRequest> getPharmacies();
    public List<BankAccountListRequest> getPharmacyBankAccounts(Integer pharmacyId);
    public List<SubsidiaryListRequest> getSubsidiariesByPharmacy(Integer pharmacyId);
    public PharmacyRequest findPharmacyById(Integer pharmacyId);
    public List<PersonListRequest> getAdminsByPharmacy(Integer pharmacyId);


}


