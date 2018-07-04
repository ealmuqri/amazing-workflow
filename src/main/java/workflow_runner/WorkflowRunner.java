package workflow_runner;
import java.util.ArrayList;
import java.util.List;
import workflow_core.Bridge;
import workflow_core.Path;
import workflow_core.Step;
import workflow_core.Workflow;

public class WorkflowRunner {

    public void executeNextStep(Workflow workflow) {
        workflow.getCurrentStep().runStep();
    }

    public void executeCurrentStep(Workflow workflow) {
        // Check if the workflow is finished.
        if (workflow.getCurrentStep() != null){
            System.out.println("--------------------------------");
            workflow.getCurrentStep().runStep();
            executeCurrentStepBridges(workflow);
        }else
        System.out.println("=-==-=-=- workflow finished -=-=-=-=-=-");
    }

    public void executeCurrentStepBridges(Workflow workflow){
        List<Bridge> bridges = findSourcePaths(workflow.getCurrentStep(),workflow.getBridges());
        // Check if no bridges were found and no default path.
        if (bridges.isEmpty() && workflow.getCurrentStep().getDefaultDestination()==null){
            // TODO: This is not valid condition, need review.
            System.out.println("--- Last Step ---");
            workflow.setCurrentStep(null);
        }
        // Not last step.
        else {
            List<Bridge> activeBridges = findActiveBridges(bridges);
            // Check if no bridges where returned (means, use default path or this is last step)
            if (activeBridges.isEmpty()){
                // Check if the step has default destination.
                if (workflow.getCurrentStep().getDefaultDestination() != null){
                    workflow.setCurrentStep(workflow.getCurrentStep().getDefaultDestination());
                }
                // Last step
                else{
                    System.out.println("----- Last Step ----");
                    workflow.setCurrentStep(null);
                    // TODO: Finish workflow execution. (Last Step)
                }
            // There exist active bridges.
            }else {
                // Check if number of bridges is greater than 1 (parallel execution)
                if (activeBridges.size() > 1){
                    // TODO: Handle copies of Workflow
                }
                // Only one bridge matches.
                else{
                    // Determine where the workflow will move to.
                    for (Path path: workflow.getBridges().get(0).getPaths()){
                        if (workflow.getCurrentStep().equals(path.getSource()))
                            workflow.setCurrentStep(path.getDestination());
                    }
                }
            }
            executeCurrentStep(workflow);
        }


    }

    /**
     * Returns list of bridges that match in their source the step passed
     * @param step
     * @param bridges
     * @return Filtered Bridges where bridge's path source = step.
     */
    public List<Bridge> findSourcePaths(Step step, List<Bridge> bridges){
        List<Bridge> filteredBridges = new ArrayList<Bridge>();
        // Loop through list of bridges to find the right path.
        for (Bridge bridge: bridges) {
            List<Path> paths =  bridge.getPaths();
            // Loop through list of paths to find source where it equals current Step.
            for (Path path: paths){
                // If source matches step then, add to filteredBridges
                if(path.getSource().equals(step)){
                    filteredBridges.add(bridge);
                }
            }
        }
        return filteredBridges;
    }

    /**
     * Return the list of active bridges where the result of rules execution is true.
     * @param bridges List of bridges which their rules will be executed and verified for Bridge Activity.
     * @return List of bridges which are active. In Other words return the bridges which returned (true) when executed.
     *
     */
    public List<Bridge> findActiveBridges(List<Bridge> bridges){
        List<Bridge> activeBridges = new ArrayList<Bridge>();
        // Run all rules to check which bridge is going to be active.
        for(Bridge bridge: bridges){
            if(bridge.runBridge())
                activeBridges.add(bridge);
        }
        return activeBridges;
    }
}
