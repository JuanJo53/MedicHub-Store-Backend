package bo.ucb.edu.medichub.bl;

import bo.ucb.edu.medichub.dao.BankAccountDao;
import bo.ucb.edu.medichub.dao.PharmacyDao;
import bo.ucb.edu.medichub.dao.TransactionDao;
import bo.ucb.edu.medichub.dto.BankAccountRequest;
import bo.ucb.edu.medichub.model.BankAccount;
import bo.ucb.edu.medichub.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountBl {

    private BankAccountDao bankAccountDao;
    private TransactionDao transactionDao;

    @Autowired
    public BankAccountBl(BankAccountDao bankAccountDao, TransactionDao transactionDao) {
        this.bankAccountDao = bankAccountDao;
        this.transactionDao = transactionDao;
    }

    public BankAccountRequest createBankAccount(BankAccountRequest bankAccountRequest, Transaction transaction){
        BankAccount bankAccount=new BankAccount();
        bankAccount.setAccount_type(bankAccountRequest.getAccount_type());
        bankAccount.setBank(bankAccountRequest.getBank());
        bankAccount.setAccountNumber(bankAccountRequest.getAccountNumber());
        bankAccount.setPharmacyId(bankAccountRequest.getPharmacyId());
        bankAccount.setTransaction(transaction);
        bankAccountDao.createBankAccount(bankAccount);
        return bankAccountRequest;
    }

}
