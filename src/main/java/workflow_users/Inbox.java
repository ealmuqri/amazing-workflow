package workflow_users;

import workflow_inbox.Task;

import java.util.ArrayList;
import java.util.List;

public class Inbox {
    private List<Task> pendingTasks,
            sentTasks,
            processedTasks = new ArrayList<Task>();
    private User owner;

}
