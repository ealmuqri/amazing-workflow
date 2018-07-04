package workflow_rules;

import java.util.List;

public class EmptyRule implements Rule {
    private String id, name;

    public EmptyRule(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean executeRule() {
        System.out.println("Rule Executed");
        return true;
    }

    @Override
    public void executeRules(List<String> methods, List<Object> workflowData) {

    }

    @Override
    public String getRuleName() {
        return name;
    }

    @Override
    public String getRuleId() {
        return id;
    }


}
