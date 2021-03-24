package bo.ucb.edu.medichub.dto;

public class AuthRole {
    private Integer roleId;

    public AuthRole() {
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "AuthRole{" +
                "roleId=" + roleId +
                '}';
    }
}
