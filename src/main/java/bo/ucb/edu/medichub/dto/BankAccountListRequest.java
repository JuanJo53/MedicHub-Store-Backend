package bo.ucb.edu.medichub.dto;

public class BankAccountListRequest {
    private Integer bankAccountId;
    private Integer accountNumber;

    public BankAccountListRequest() {
    }

    public Integer getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(Integer bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "BankAccountListRequest{" +
                "bankAccountId=" + bankAccountId +
                ", accountNumber=" + accountNumber +
                '}';
    }
}
