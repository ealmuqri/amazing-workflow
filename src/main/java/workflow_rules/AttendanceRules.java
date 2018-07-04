package workflow_rules;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class AttendanceRules implements Rule {
    private String id, name;

    public AttendanceRules(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean executeRule() {
        System.out.println("==== Attendence Rules ====");
        System.out.println("Rule1: Checking Employee Attendence");
        System.out.println("-- Success");
        System.out.println("Rule2: Checking Employee Abcense");
        System.out.println("-- Success");
        return true;
    }

    @Override
    public void executeRules(List<String> methods, List<Object> worklowData) {
        for (String method: methods) {
            try {
                Method meth = this.getClass().getMethod(method,List.class);
                meth.invoke(this, worklowData);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    TODO
    Check JAVA Reflections recommendations.
     */

    public void executeMethods(){
        try{
            System.out.println(this.getClass().getMethod("sampleMethod").invoke(this));
        }
        catch (NoSuchMethodException|IllegalAccessException|InvocationTargetException exception){
            System.out.println("Exception");
        }

    }
    /*
    TODO:
    Function that will take input list of functions to execute and the functions relation ships. (And, OR)
     */

    @Override
    public String getRuleName() {
        return name;
    }

    @Override
    public String getRuleId() {
        return id;
    }

    public void sampleMethod(List<Object> workflowData){
        System.out.println("I got invoked");
        for (Object data: workflowData
             ) {
            System.out.println(data.getClass());
        }

    }
}
