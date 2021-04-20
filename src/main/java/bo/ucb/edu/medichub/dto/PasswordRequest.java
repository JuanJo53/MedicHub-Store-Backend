package bo.ucb.edu.medichub.dto;

public class PasswordRequest {

    private Integer id;
    private String passwordCurrent;
    private String passwordNew;

    public PasswordRequest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                "clientId=" + id +
                ", passwordCurrent='" + passwordCurrent + '\'' +
                ", passwordNew='" + passwordNew + '\'' +
                '}';
    }
}
