package workflow_users;

import workflow_core.Workflow;

import java.util.ArrayList;
import java.util.List;

public class UserInbox  {
    private List<Workflow> pending, requested, processed = new ArrayList<>();
}
