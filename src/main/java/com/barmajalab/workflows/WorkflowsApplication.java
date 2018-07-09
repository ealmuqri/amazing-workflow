package com.barmajalab.workflows;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import workflow_core.Workflow;
import workflow_runner.WorkflowRunner;
import workflow_users.User;

@SpringBootApplication
public class WorkflowsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkflowsApplication.class, args);
        Workflow workflowInstance = new Workflow();
        // TODO: needs refactoring to convert it to factory method for workflows. Needs to add what template.
        workflowInstance = workflowInstance.constructWorkflow("w123","Workflow NAme");

        User user1 =  new User("u1234","essam","ealmuqri.c@stc.com.sa");

        WorkflowRunner workflowRunner = new WorkflowRunner();
        workflowRunner.executeCurrentStep(workflowInstance);
    }
}
