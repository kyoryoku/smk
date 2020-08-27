package lab.smk.controllers;

import lab.smk.services.journal.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @GetMapping("/project")
    public String getProject(Model model){
        model.addAttribute("projectList", projectService.findAll());
        return "project";
    }
}
