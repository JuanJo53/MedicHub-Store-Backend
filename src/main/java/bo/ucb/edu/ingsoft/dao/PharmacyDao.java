package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.BankAccount;
import bo.ucb.edu.ingsoft.model.Pharmacy;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PharmacyDao {
    public void createPharmacy(Pharmacy pharmacy);

    public void updatePharmacy(Pharmacy pharmacy);
    public void deletePharmacy(Pharmacy pharmacy);

    public void createBankAccount(BankAccount bankAccount);
}


