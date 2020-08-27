package lab.smk.controllers;

import lab.smk.models.journals.TestSample;
import lab.smk.services.journal.TestSampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.xml.ws.Action;

@Controller
public class TestSampleController {
    @Autowired
    TestSampleService testSampleService;

    @GetMapping("/testSample")
    public String getTestSample(Model model){
        model.addAttribute("testSampleList", testSampleService.findAll());
        return "testSample";
    }
}
