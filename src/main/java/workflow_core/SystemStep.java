package workflow_core;

import workflow_rules.Rule;

import java.util.ArrayList;
import java.util.List;

public class SystemStep implements Step{

    private String id;
    private String name;
    private List<Rule> rules = new ArrayList<>();
    private List<Rule> preRunRules = new ArrayList<>();
    private List<Rule> postRunRules = new ArrayList<>();
//    private List<Role> roles = new ArrayList<>();
    private Boolean isBlocker;
    private Step defaultDestination;

    public SystemStep(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void runStep() {

        System.out.println("========= STEP ("+name+") Started Running =======");
        for (Rule rule : preRunRules) {
            System.out.print("Pre Run === "+name+" -> ");
            rule.executeRule();
        }
        for (Rule rule : rules) {
            System.out.print("Run === "+name+" -> ");
            rule.executeRule();
        }
        for (Rule rule : postRunRules) {
            System.out.print("Post Run=== "+name+" -> ");
            rule.executeRule();
        }

        System.out.println("========= STEP ("+name+") Finished =======");


        /*
        TODO: Dispatch an event anyone interested. (Pub-Sub Model)
         */
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
    public Boolean getIsBlocker() {
        return isBlocker;
    }

    @Override
    public void setIsBlocker(Boolean isBlocker) {
        isBlocker = isBlocker;
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
