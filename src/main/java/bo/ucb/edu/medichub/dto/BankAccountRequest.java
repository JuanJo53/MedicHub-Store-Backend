package bo.ucb.edu.medichub.dto;

public class BankAccountRequest {
    private Integer bankAccountId;
    private Integer pharmacyId;
    private Integer accountNumber;
    private String bank;
    private String accountType;

    public BankAccountRequest() {
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

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
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

    public void setAccountType(String account_type) {
        this.accountType = account_type;
    }

    @Override
    public String toString() {
        return "BankAccountRequest{" +
                "bamkAccountId=" + bankAccountId +
                ", pharmacyId=" + pharmacyId +
                ", accountNumber=" + accountNumber +
                ", bank='" + bank + '\'' +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
