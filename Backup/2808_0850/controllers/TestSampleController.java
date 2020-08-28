package lab.smk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class TestSampleController {
    @Autowired
    TestSampleService testSampleService;

//    @GetMapping("/testSample")
//    public @ResponseBody Iterable<TestSample> getTestSample(Model model){
//        return testSampleService.findAll();
//    }

    @GetMapping("/testSample")
    public @ResponseBody Optional<TestSample> getTestSample(Model model){
        return testSampleService.findById(17L);
    }


    @GetMapping("/testSample-generate")
    public @ResponseBody String generateTestSample(Model model){

        return "ok";
    }

}
