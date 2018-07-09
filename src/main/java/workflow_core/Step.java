package workflow_core;

import workflow_rules.Rule;

import java.util.List;

public interface Step {
    public void runStep();

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


}
