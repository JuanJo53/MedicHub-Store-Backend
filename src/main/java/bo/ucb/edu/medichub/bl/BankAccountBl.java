package bo.ucb.edu.medichub.bl;

import bo.ucb.edu.medichub.dao.BankAccountDao;
import bo.ucb.edu.medichub.dao.TransactionDao;
import bo.ucb.edu.medichub.dto.BankAccountRequest;
import bo.ucb.edu.medichub.model.BankAccount;
import bo.ucb.edu.medichub.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountBl {

    private BankAccountDao bankAccountDao;
    private TransactionDao transactionDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(BankAccountBl.class);

    @Autowired
    public BankAccountBl(BankAccountDao bankAccountDao, TransactionDao transactionDao) {
        this.bankAccountDao = bankAccountDao;
        this.transactionDao = transactionDao;
    }

    public BankAccountRequest createBankAccount(BankAccountRequest bankAccountRequest, Transaction transaction){
        BankAccount bankAccount=new BankAccount();
        bankAccount.setAccountType(bankAccountRequest.getAccountType());
        bankAccount.setBank(bankAccountRequest.getBank());
        bankAccount.setAccountNumber(bankAccountRequest.getAccountNumber());
        bankAccount.setPharmacyId(bankAccountRequest.getPharmacyId());
        bankAccount.setTransaction(transaction);
        bankAccountDao.createBankAccount(bankAccount);
        return bankAccountRequest;
    }

    public BankAccountRequest updateBankAccount(BankAccountRequest bankAccountRequest, Transaction transaction){
        BankAccount bankAccount = new BankAccount();

        bankAccount.setBankAccountId(bankAccountRequest.getBankAccountId());
        bankAccount.setAccountType(bankAccountRequest.getAccountType());
        bankAccount.setBank(bankAccountRequest.getBank());
        bankAccount.setAccountNumber(bankAccountRequest.getAccountNumber());
        bankAccount.setTransaction(transaction);
        bankAccountDao.updateBankAccount(bankAccount);
        return bankAccountRequest;
    }

    public BankAccountRequest findBankAccountById(Integer bankAccountId){
        BankAccountRequest bankAccountRequest = bankAccountDao.findBankAccountById(bankAccountId);
        return bankAccountRequest;
    }
}
