package workflow_role;

import workflow_users.User;

import java.util.List;

public interface Role {
    /**
     * To get the who are the right people to approve/reject an item.
     * 1. Get Role name
     * 2. Get list of users under role.
     * 3. Get UI component ID
     *
     */

    public String getRoleId();
    public List<User> getRoleUsers();
    public String getUIComponentId();
}
