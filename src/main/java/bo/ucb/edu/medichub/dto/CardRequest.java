package bo.ucb.edu.medichub.dto;

import org.springframework.format.annotation.NumberFormat;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class CardRequest {
    @NumberFormat
    @Positive
    private Integer cardId;
    @NumberFormat
    @Positive
    private Integer clientId;
    @NotEmpty
    @Size(min = 4, max = 25)
    private String accountNumber;
    @NotEmpty
    @Size(min = 4, max = 25)
    private String bank;
    @NotEmpty
    @Size(min = 4, max = 25)
    private String typeAccount;
    @NotEmpty
    @Size(min = 2, max = 4)
    private String cvvCode;
    @NotEmpty
    @Size(min = 1, max = 12)
    private String month;
    @NotEmpty
    @Size(min = 3, max = 4)
    private String year;

    public CardRequest() {
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
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

    public String getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
    }

    public String getCvvCode() {
        return cvvCode;
    }

    public void setCvvCode(String cvvCode) {
        this.cvvCode = cvvCode;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "CardRequest{" +
                "cardId=" + cardId +
                ", clientId=" + clientId +
                ", accountNumber='" + accountNumber + '\'' +
                ", bank='" + bank + '\'' +
                ", typeAccount='" + typeAccount + '\'' +
                ", cvvCode='" + cvvCode + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

}
