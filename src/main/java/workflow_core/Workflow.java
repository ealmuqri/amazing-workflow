package workflow_core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.corba.se.spi.orbutil.threadpool.Work;
import workflow_rules.AttendanceRules;
import workflow_rules.EmptyRule;
import workflow_rules.Rule;
import workflow_rules.SalaryRules;
import workflow_templates.SampleTemplate;
import workflow_users.User;

import java.util.ArrayList;
import java.util.List;

public class Workflow {
    private String ID;
    private String name;
    private String description;
    private List<Object> workflowData = new ArrayList<>();
    private Step currentStep;
    private WorkflowTemplate workflowTemplate;
    private User requester;

    public Workflow(){

    }

    public Workflow(String ID, String name, WorkflowTemplate workflowTemplate) {
        this.ID = ID;
        this.name = name;
        this.workflowTemplate = workflowTemplate;
    }

    public Workflow constructWorkflow(String id, String name){
        this.workflowTemplate = new SampleTemplate().getTemplate();
        this.ID =id;
        this.name = name;
        this.currentStep = workflowTemplate.getSteps().get(0);
        return this;
    }

    public WorkflowTemplate getWorkflowTemplate() {
        return workflowTemplate;
    }

    public void setWorkflowTemplate(WorkflowTemplate workflowTemplate) {
        this.workflowTemplate = workflowTemplate;
    }

    public User getRequester() {
        return requester;
    }

    public void setRequester(User requester) {
        this.requester = requester;
    }


    public List<Object> getWorkflowData() {
        return workflowData;
    }

    public void setWorkflowData(List<Object> workflowData) {
        this.workflowData = workflowData;
    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public Step getCurrentStep() {
        return currentStep;
    }

    public void setCurrentStep(Step currentStep) {
        this.currentStep = currentStep;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

}
