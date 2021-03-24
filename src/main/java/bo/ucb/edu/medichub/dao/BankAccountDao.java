package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.dto.BankAccountRequest;
import bo.ucb.edu.medichub.model.BankAccount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BankAccountDao {

    public void createBankAccount(BankAccount bankAccount);
    public void updateBankAccount(BankAccount bankAccount);
    public BankAccountRequest findBankAccountById(Integer subsidiaryId);
}


