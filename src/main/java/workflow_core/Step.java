package workflow_core;

import workflow_role.Role;
import workflow_rules.Rule;

import java.util.List;

public interface Step {
    // TODO: refactor data List to Key-Value pair.
    public Boolean runStep(List<Object> data, List<Object> actionData);
    public Boolean preRunStep(List<Object> data);

     public String getId();
     public void setId(String id);

     public String getName();
     public void setName(String name);

     public List<Rule> getRules();
     public void setRules(List<Rule> rules);


     public List<Rule> getPreRunRules();
     public void setPreRunRules(List<Rule> preRunRules);

     public List<Rule> getPostRunRules();
     public void setPostRunRules(List<Rule> postRunRules);



     public Boolean getIsBlocker();
     public void setIsBlocker(Boolean isBlocker);

     public Step getDefaultDestination();
     public void setDefaultDestination(Step step);

     public Role getRole();
     public void setRoles(Role role);




}
