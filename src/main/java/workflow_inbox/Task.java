package workflow_inbox;

import workflow_users.User;

import java.util.ArrayList;
import java.util.List;

/**
 * A task is a unit of work that must be done by a human (manual work).
 */
public class Task {
    private String id;
    private String name;
    private List<User> owners = new ArrayList<User>();
    /**
     * I need from a task to know the following:
     *  - Who are the owners?
     *  - Task creation and update timestamps.
     *  - Task History. (Transactions)
     *  - Workflow Id.
     *  - Workflow Template Id.
     *  - User interface Id. (what UI component to show)
     *  -
     */
}
