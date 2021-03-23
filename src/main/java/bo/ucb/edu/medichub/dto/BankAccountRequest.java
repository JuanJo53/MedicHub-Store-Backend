package bo.ucb.edu.medichub.dto;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;

public class BankAccountRequest {
    private Integer bankAccountId;
    @NotNull
    @NumberFormat
    @Positive
    private Integer pharmacyId;
    @NotNull
    @NumberFormat
    @Positive
    private Integer accountNumber;
    @NotEmpty
    @Size(min = 4, max = 25)
    private String bank;
    @NotEmpty
    @Size(min = 4, max = 25)
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
