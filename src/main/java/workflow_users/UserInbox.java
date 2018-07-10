package workflow_users;

import workflow_core.Workflow;

import java.util.ArrayList;
import java.util.List;

public class UserInbox  {
    private List<Workflow> pending = new ArrayList<>(),
            requested = new ArrayList<>(),
            processed = new ArrayList<>();

    public List<Workflow> getPending() {
        return pending;
    }

    public void setPending(List<Workflow> pending) {
        this.pending = pending;
    }

    public List<Workflow> getRequested() {
        return requested;
    }

    public void setRequested(List<Workflow> requested) {
        this.requested = requested;
    }

    public List<Workflow> getProcessed() {
        return processed;
    }

    public void setProcessed(List<Workflow> processed) {
        this.processed = processed;
    }

    public void addPending(Workflow workflow){
        this.pending.add(workflow);
        System.out.println("---> Item added to Pending");
    }
    /*

     */
}
