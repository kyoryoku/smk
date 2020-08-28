package lab.smk.controllers;

import lab.smk.models.Project;
import lab.smk.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/test/add-project")
    public @ResponseBody Project addProject (Model model){

        Project project = new Project();
        projectRepository.save(project);
        return project;
    }


}
