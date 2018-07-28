package workflow_inbox;

import org.springframework.stereotype.Component;
import workflow_users.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class Inbox {
    private List<Task> pendingTasks,
            sentTasks,
            processedTasks = new ArrayList<Task>();
    private User owner;

}
