package bo.ucb.edu.ingsoft.dto;

public class UserLogInRequest {
    private int adminid;
    private String typeuser;

    public UserLogInRequest(){
    }

    public int getAdminid() {
        return adminid;
    }

    public void setAdminid(int adminid) {
        this.adminid = adminid;
    }

    public String getTypeuser() {
        return typeuser;
    }

    public void setTypeuser(String typeuser) {
        this.typeuser = typeuser;
    }

    @Override
    public String toString() {
        return "UserLogInRequest{" +
                "adminid=" + adminid +
                ", typeuser='" + typeuser + '\'' +
                '}';
    }
}
