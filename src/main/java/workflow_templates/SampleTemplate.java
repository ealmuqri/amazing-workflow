package workflow_templates;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import workflow_core.*;
import workflow_rules.AttendanceRules;
import workflow_rules.EmptyRule;
import workflow_rules.Rule;
import workflow_rules.SalaryRules;

import java.util.ArrayList;
import java.util.List;

public class SampleTemplate implements WorkflowTemplate {
    private String id="w123";
    private String name = "sample workflow";
    private List<Step> steps = new ArrayList<>();
    private List<Bridge> bridges = new ArrayList<>();

    public SampleTemplate(String id, String name, List<Step> steps, List<Bridge> bridges) {
        this.id = id;
        this.name = name;
        this.steps = steps;
        this.bridges = bridges;
    }

    public SampleTemplate() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<Step> getSteps() {
        return steps;
    }

    @Override
    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    @Override
    public List<Bridge> getBridges() {
        return bridges;
    }

    @Override
    public void setBridges(List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public WorkflowTemplate getTemplate() {
        //WorkflowTemplate workflowTemplate = new SampleTemplate();
        Rule emptyRule = new EmptyRule("r123", "emptyRule");
        Rule attendanceRule = new AttendanceRules("r1123", "Attendence Rules");
        Rule salaryRule = new SalaryRules("r3213","Salary Rules");
        List<String> methods = new ArrayList<String>();
        List<Object> workflowData = new ArrayList<Object>();
//        methods.add("sampleMethod");
//        workflowData.add("Essam");
//        attendanceRule.executeRules(methods,workflowData);
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

        List<Step> steps = new ArrayList<>();
        steps.add(step1);
        steps.add(step2);

        List<Bridge> bridges = new ArrayList<>();
        bridges.add(bridge);

        this.bridges=bridges;
        this.steps=steps;
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            String workflowJson = objectMapper.writeValueAsString(this);
//            System.out.println(workflowJson);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
        return this;
    }

    @Override
    public void addStep(Step step){
        this.steps.add(step);
    }

    @Override
    public void addBridge(Bridge bridge){
        this.bridges.add(bridge);
    }
}
