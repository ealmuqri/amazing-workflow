package workflow_core;

import workflow_rules.Rule;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private String ID;
    private String name;
    private List<Rule> bridgeRules = new ArrayList<Rule>();
    private List<Rule> preRunRules = new ArrayList<Rule>();
    private List<Rule> postRunRules = new ArrayList<Rule>();
    private List<Path> paths = new ArrayList<Path>();

    public String getID() {
        return ID;
    }

    public Bridge(String ID, String name, List<Path> paths) {
        this.ID = ID;
        this.name = name;
        this.paths = paths;
    }

    public Boolean runBridge() {
        /*
            1. Run Pre Run Rules.
            2. Run Rules.
            3. Run Post Run Rules
            4. Fire Conclusion Event.
         */

        System.out.println("========= Bridge ("+name+") Started Running =======");
        for (Rule rule : preRunRules) {
            if(!rule.executeRule())
                return false;
        }
        for (Rule rule : bridgeRules) {
            if(!rule.executeRule())
                return false;
        }
        for (Rule rule : postRunRules) {
            if(!rule.executeRule())
                return false;
        }

        System.out.println("========= Bridge ("+name+") Finished =======");
        /*
        TODO: Dispatch an event anyone interested. (Pub-Sub Model)
         */

        return true;
    }
    public void addBridgeRule(Rule rule) {
        this.bridgeRules.add(rule);
    }

    public void addPreRunRule(Rule rule) {
        this.preRunRules.add(rule);
    }

    public void addPostRunRule(Rule rule) {
        this.postRunRules.add(rule);
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

    public List<Rule> getBridgeRules() {
        return bridgeRules;
    }

    public void setBridgeRules(List<Rule> bridgeRules) {
        this.bridgeRules = bridgeRules;
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

    public List<Path> getPaths() {
        return paths;
    }

    public void setPaths(List<Path> paths) {
        this.paths = paths;
    }

    public void addPath(Path path){
        this.paths.add(path);
    }
}
