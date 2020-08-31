package lab.smk.controllers;

import lab.smk.models.Contract;
import lab.smk.models.Project;

import lab.smk.models.Task;
import lab.smk.repo.ContractRepository;
import lab.smk.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class TestController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ContractRepository contractRepository;


    @GetMapping("/test/add-project")
    public @ResponseBody Project addProject (Model model){

        Project project = new Project();
        projectRepository.save(project);
        return project;
    }

    @PostMapping("/test/edit-project")
    public @ResponseBody Project editProject (Model model,
                                              @RequestParam Long projectId,
                                              @RequestParam Long contractId){

        Project project = projectRepository.findById(projectId).get();
        Contract contract = contractRepository.findById(contractId).get();
        project.setContract(contract);
        contract.setProject(project);
        projectRepository.save(project);
        return project;
    }


    @GetMapping("/test/add-contract")
    public @ResponseBody Contract addContract (Model model){

        Contract contract = new Contract();
        contractRepository.save(contract);
        return contract;
    }

    @GetMapping("/test/add-project-full")
    public @ResponseBody Project addProjectFull (Model model){

        Project project = new Project();
        Contract contract = new Contract();
        project.setContract(contract);
        contract.setProject(project);

        Task task1 = new Task();
        task1.setContract(contract);
        task1.setTask("task 1");

        Task task2 = new Task();
        task2.setContract(contract);
        task2.setTask("task 2");

        List<Task> tasks = new ArrayList<Task>();
        tasks.add(task1);
        tasks.add(task2);

        contract.setTasks(tasks);



        projectRepository.save(project);

        return project;
    }



}
