package lab.smk.controllers;

import lab.smk.models.Project;
import lab.smk.services.ProjectService;
import lab.smk.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    TaskService taskService;

    @GetMapping("/project")
    public String getProject (Model model){

        model.addAttribute("taskList", taskService.findAll());

        return "project";
    }

}
