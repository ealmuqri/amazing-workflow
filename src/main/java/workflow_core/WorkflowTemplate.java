package workflow_core;

import java.util.List;

public interface WorkflowTemplate {
//    public  Workflow constructWorkflow();
    public List<Step> getSteps();
    public void setSteps(List<Step> steps);
    public List<Bridge> getBridges();
    public void setBridges(List<Bridge> bridges);
    public void addStep(Step step);
    public void addBridge(Bridge bridge);
}
