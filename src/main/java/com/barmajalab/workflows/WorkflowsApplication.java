package com.barmajalab.workflows;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import workflow_core.Workflow;
import workflow_runner.WorkflowRunner;

@SpringBootApplication
public class WorkflowsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkflowsApplication.class, args);
        Workflow workflowInstance = new Workflow();
        workflowInstance = workflowInstance.contructWorkflow("w123","Workflow NAme");


        WorkflowRunner workflowRunner = new WorkflowRunner();
        workflowRunner.executeCurrentStep(workflowInstance);
    }
}
