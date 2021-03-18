package bo.ucb.edu.medichub.dto;

public class BankAccountRequest {
    private Integer pharmacyId;

    private Integer accountNumber;
    private String bank;
    private String account_type;

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

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    @Override
    public String toString() {
        return "BankAccountRequest{" +
                "pharmacyId=" + pharmacyId +
                ", accountNumber=" + accountNumber +
                ", bank='" + bank + '\'' +
                ", account_type='" + account_type + '\'' +
                '}';
    }
}
