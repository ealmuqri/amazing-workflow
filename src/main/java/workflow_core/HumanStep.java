package workflow_core;

import org.springframework.stereotype.Component;
import workflow_role.Role;
import workflow_rules.Rule;

import java.util.ArrayList;
import java.util.List;

@Component
public class HumanStep implements Step {
    private String id;
    private String name;
    private List<Rule> rules = new ArrayList<>();
    private List<Rule> preRunRules = new ArrayList<>();
    private List<Rule> postRunRules = new ArrayList<>();
    private Role role;
    private Boolean isBlocker;
    private Step defaultDestination;

    @Override
    public Boolean runStep(List<Object> data, List<Object> actionData) {
        System.out.println("========= Human STEP ("+name+") Started Running =======");

        for (Rule rule : rules) {
            System.out.print("Run === "+name+" -> ");
            rule.executeRule();
        }
        for (Rule rule : postRunRules) {
            System.out.print("Post Run=== "+name+" -> ");
            rule.executeRule();
        }

        System.out.println("========= STEP ("+name+") Finished =======");

        return true;
    }

    // To run Rules and postRunRules.
//    public Boolean runRules(List<Object> data){
//
//        System.out.println("========= Human STEP ("+name+") Started Running =======");
//
//        for (Rule rule : rules) {
//            System.out.print("Run === "+name+" -> ");
//            rule.executeRule();
//        }
//        for (Rule rule : postRunRules) {
//            System.out.print("Post Run=== "+name+" -> ");
//            rule.executeRule();
//        }
//
//        System.out.println("========= STEP ("+name+") Finished =======");
//
//        return true;
//    }
    @Override
    public Boolean preRunStep(List<Object> data) {
        System.out.println("========= Human STEP ("+name+") Pre Run Rules =======");
        for (Rule rule : preRunRules) {
            System.out.print("Pre Run === "+name+" -> ");
            rule.executeRule();
        }
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

    @Override
    public Role getRole() {
        return role;
    }

    @Override
    public void setRoles(Role role) {
        this.role=role;

    }
}
