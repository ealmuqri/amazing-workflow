package workflow_role;

import workflow_users.User;

import java.util.ArrayList;
import java.util.List;

public class DirectManagerRole implements Role{
    private String roleId;
    private String UIComponentId;
    private List<User> roleUsers = new ArrayList<>();

    public DirectManagerRole() {
        this.roleId = "direct_manager_role";
        this.UIComponentId = "approval";
        User user = new User("ealmuqri","Essam","essam.almuqri@gmail.com");
        this.roleUsers.add(user);
    }

    @Override
    public String getRoleId() {
        return roleId;
    }

    @Override
    public List<User> getRoleUsers() {
        return roleUsers;
    }

    @Override
    public String getUIComponentId() {
        return UIComponentId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public void setUIComponentId(String UIComponentId) {
        this.UIComponentId = UIComponentId;
    }

    public void setRoleUsers(List<User> roleUsers) {
        this.roleUsers = roleUsers;
    }
}
