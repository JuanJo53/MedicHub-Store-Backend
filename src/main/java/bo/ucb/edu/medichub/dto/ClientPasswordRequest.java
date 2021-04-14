package bo.ucb.edu.medichub.dto;

public class ClientPasswordRequest {

    private Integer clientId;
    private String passwordCurrent;
    private String passwordNew;

    public ClientPasswordRequest() {
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getPasswordCurrent() {
        return passwordCurrent;
    }

    public void setPasswordCurrent(String passwordCurrent) {
        this.passwordCurrent = passwordCurrent;
    }

    public String getPasswordNew() {
        return passwordNew;
    }

    public void setPasswordNew(String passwordNew) {
        this.passwordNew = passwordNew;
    }

    @Override
    public String toString() {
        return "ClientPasswordReques{" +
                "clientId=" + clientId +
                ", passwordCurrent='" + passwordCurrent + '\'' +
                ", passwordNew='" + passwordNew + '\'' +
                '}';
    }
}
