package workflow_core;

import workflow_role.Role;
import workflow_rules.Rule;

import java.util.ArrayList;
import java.util.List;

public class HumanStep implements Step {
    private String id;
    private String name;
    private List<Rule> rules = new ArrayList<>();
    private List<Rule> preRunRules = new ArrayList<>();
    private List<Rule> postRunRules = new ArrayList<>();
    private List<Role> roles = new ArrayList<>();
    private Boolean isBlocker;
    private Step defaultDestination;

    @Override
    public Boolean runStep(List<Object> data) {
        /**
         * IDEA:
         * 1. Run pre-run rules if success then, load UI.
         * 2. On user submission run rules if success run postRunRules then, return true;
         */
        return true;
    }

    // To run Rules and postRunRules.
    public Boolean runRules(List<Object> data){
        return true;
    }

    public HumanStep(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<Rule> getRules() {
        return rules;
    }

    @Override
    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    @Override
    public List<Rule> getPreRunRules() {
        return preRunRules;
    }

    @Override
    public void setPreRunRules(List<Rule> preRunRules) {
        this.preRunRules = preRunRules;
    }

    @Override
    public List<Rule> getPostRunRules() {
        return postRunRules;
    }

    @Override
    public void setPostRunRules(List<Rule> postRunRules) {
        this.postRunRules = postRunRules;
    }

    @Override
    public List<Role> getRoles() {
        return roles;
    }

    @Override
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public Boolean getIsBlocker() {
        return isBlocker;
    }

    @Override
    public void setIsBlocker(Boolean isBlocker) {
       this.isBlocker = isBlocker;
    }

    @Override
    public Step getDefaultDestination() {
        return defaultDestination;
    }

    @Override
    public void setDefaultDestination(Step defaultDestination) {
        this.defaultDestination = defaultDestination;
    }
}
