package workflow_inbox;

import workflow_users.User;

import java.util.ArrayList;
import java.util.List;

public class Inbox {
    private List<Task> pendingTasks,
            sentTasks,
            processedTasks = new ArrayList<Task>();
    private User owner;

}
