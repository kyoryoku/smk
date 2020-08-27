package lab.smk.controllers;

import lab.smk.services.journal.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("/task")
    public String getTask(Model model){
        model.addAttribute("taskList", taskService.findAll());
        return "task";
    }
}
