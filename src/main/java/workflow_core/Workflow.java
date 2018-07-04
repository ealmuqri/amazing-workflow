package workflow_core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.corba.se.spi.orbutil.threadpool.Work;
import workflow_rules.AttendanceRules;
import workflow_rules.EmptyRule;
import workflow_rules.Rule;
import workflow_rules.SalaryRules;

import java.util.ArrayList;
import java.util.List;

public class Workflow {
    private String ID;
    private String name;
    private String description;
    private List<Step> steps = new ArrayList<>();
    private List<Bridge> bridges = new ArrayList<>();
    private List<Object> workflowData = new ArrayList<>();
    private Step currentStep;
    private String templateId;

    public Workflow(){

    }

    public Workflow(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public Workflow contructWorkflow(String id, String name){
        Workflow workflowInstance = new Workflow(id, name);
        Rule emptyRule = new EmptyRule("r123", "emptyRule");
        Rule attendanceRule = new AttendanceRules("r1123", "Attendence Rules");
        Rule salaryRule = new SalaryRules("r3213","Salary Rules");
        List<String> methods = new ArrayList<String>();
        List<Object> workflowData = new ArrayList<Object>();
        methods.add("sampleMethod");
        workflowData.add("Essam");
        attendanceRule.executeRules(methods,workflowData);
        // I don't want to end up creating 1000 classes for my rules!
        /*
        OPTIONS:
        1. Create generic rules for Math, Dates, Strings ..etc and have them adhere to the interface.
        2. Have one Big Rules file and let the invoker define what functions required to run in order.
        3.
         */

        // TODO: Step paths should not point to a step that is not in workflow instance.

        Step step1 = new Step("s1", "step1", StepType.Human);
        Step step2 = new Step("s2", "step2", StepType.Human);

        // Creating Bridge //
        Path path = new Path(step1,step2);
        List<Path> paths = new ArrayList<>();
        paths.add(path);
        Bridge bridge = new Bridge("b123","bridge1",paths);
        bridge.addBridgeRule(emptyRule);
        bridge.addPostRunRule(emptyRule);
        bridge.addPreRunRule(salaryRule);

        // End Creating a Bridge //
        step1.addRule(attendanceRule);
        step1.addPostRunRule(emptyRule);
        step1.addPreRunRule(salaryRule);

        step2.addRule(attendanceRule);
        step2.addPostRunRule(emptyRule);
        step2.addPreRunRule(salaryRule);

        workflowInstance.addStep(step1);
        workflowInstance.addStep(step2);
        workflowInstance.addBridge(bridge);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String workflowJson = objectMapper.writeValueAsString(workflowInstance);
            System.out.println(workflowJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return workflowInstance;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public List<Bridge> getBridges() {
        return bridges;
    }

    public void setBridges(List<Bridge> bridges) {
        this.bridges = bridges;
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


    public void addStep(Step step) {
        this.steps.add(step);
        if (this.currentStep == null) {
            currentStep = step;
        }
    }

    public void addBridge(Bridge bridge) {
        this.bridges.add(bridge);
    }

}
