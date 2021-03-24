package bo.ucb.edu.medichub.model;

public class BankAccount {

    private Integer bankAccountId;
    private Integer pharmacyId;
    private String accountNumber;
    private String bank;
    private String accountType;
    private Integer status;
    private Transaction transaction;

    public BankAccount() {
    }

    public Integer getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(Integer bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public Integer getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(Integer pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "bankAccountId=" + bankAccountId +
                ", pharmacyId=" + pharmacyId +
                ", accountNumber=" + accountNumber +
                ", bank='" + bank + '\'' +
                ", account_type='" + accountType + '\'' +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}
