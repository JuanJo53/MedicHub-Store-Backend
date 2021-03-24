package bo.ucb.edu.medichub.dto;

public class AuthRole {
    private Integer roleId;
    private Integer Id;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "AuthRole{" +
                "roleId=" + roleId +
                ", Id=" + Id +
                '}';
    }
}
