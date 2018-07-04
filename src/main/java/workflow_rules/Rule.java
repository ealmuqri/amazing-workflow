package workflow_rules;

import java.util.List;

public interface Rule {
    public boolean executeRule();
    public void executeRules(List<String> methods, List<Object> workflowData);
    public String getRuleName();
    public String getRuleId();

}
