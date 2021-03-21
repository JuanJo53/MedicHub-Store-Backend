package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.dto.BankAccountRequest;
import bo.ucb.edu.medichub.dto.PharmacyRequest;
import bo.ucb.edu.medichub.dto.SubsidiaryListRequest;
import bo.ucb.edu.medichub.model.BankAccount;
import bo.ucb.edu.medichub.model.Pharmacy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PharmacyDao {
    public void createPharmacy(Pharmacy pharmacy);
    public void updatePharmacy(Pharmacy pharmacy);
    public void deletePharmacy(Pharmacy pharmacy);
    public List<PharmacyRequest> getPharmacies();
    public List<BankAccountRequest> getPharmacyBankAccounts(Integer pharmacyId);
    public List<SubsidiaryListRequest> getSubsidiariesByPharmacy(Integer pharmacyId);
}


