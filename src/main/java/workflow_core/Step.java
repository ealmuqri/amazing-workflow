package workflow_core;

import workflow_rules.Rule;

import java.util.ArrayList;
import java.util.List;

public class Step {

    private String ID;
    private String name;
    private StepType stepType;
    private List<Rule> rules = new ArrayList<>();
    private List<Rule> preRunRules = new ArrayList<>();
    private List<Rule> postRunRules = new ArrayList<>();
    private Role[] roles;
    private Boolean isBlocker;
    private Step defaultDestination;

    public Step(String ID, String name, StepType stepType) {
        this.ID = ID;
        this.name = name;
        this.stepType = stepType;

    }

    public void runStep() {
        /*
            1. Run Pre Run Rules.
            2. Run Rules.
            3. Run Post Run Rules
            4. Fire Conclusion Event.
         */

        System.out.println("========= STEP ("+name+") Started Running =======");
        for (Rule rule : preRunRules) {
            rule.executeRule();
        }
        for (Rule rule : rules) {
            rule.executeRule();
        }
        for (Rule rule : postRunRules) {
            rule.executeRule();
        }

        System.out.println("========= STEP ("+name+") Finished =======");
        /*
        TODO: Dispatch an event anyone interested. (Pub-Sub Model)
         */
    }

    public void addRule(Rule rule) {
        this.rules.add(rule);
    }

    public void addPreRunRule(Rule rule) {
        this.preRunRules.add(rule);
    }

    public void addPostRunRule(Rule rule) {
        this.postRunRules.add(rule);
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

    public StepType getStepType() {
        return stepType;
    }

    public void setStepType(StepType stepType) {
        this.stepType = stepType;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    public List<Rule> getPreRunRules() {
        return preRunRules;
    }

    public void setPreRunRules(List<Rule> preRunRules) {
        this.preRunRules = preRunRules;
    }

    public List<Rule> getPostRunRules() {
        return postRunRules;
    }

    public void setPostRunRules(List<Rule> postRunRules) {
        this.postRunRules = postRunRules;
    }

    public Role[] getRoles() {
        return roles;
    }

    public void setRoles(Role[] roles) {
        this.roles = roles;
    }

    public Boolean getBlocker() {
        return isBlocker;
    }

    public void setBlocker(Boolean blocker) {
        isBlocker = blocker;
    }

    public Step getDefaultDestination() {
        return defaultDestination;
    }

    public void setDefaultDestination(Step defaultDestination) {
        this.defaultDestination = defaultDestination;
    }
}
