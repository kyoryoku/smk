package lab.smk.controllers;

import lab.smk.models.*;
import lab.smk.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.time.LocalDate;

@Controller
public class TestController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/test/add-random-project")
    public @ResponseBody String addRandomProject (Model model){

        Customer[] customers = new Customer[5];
        for (int i = 0; i < 5; i++){
            customers[i] = new Customer();
            customers[i].setName("Фирма " + i);
            customers[i].setAddress("улица " + i + ", дом " + i);
            customers[i].setComments("комент " + i);
        }

        for (int projectIdx = 0; projectIdx < 20; projectIdx++){
            Project project = new Project();

            Contract contract = new Contract();
            contract.setNumber("00" + projectIdx);
            contract.setDate(LocalDate.now().minusDays(projectIdx));
            project.addContract(contract);

            int customerIdx = (int)(Math.random() * 5);
            System.out.println("customerIdx: " + customerIdx);
            contract.addCustomer(customers[customerIdx]);

            for (int productIdx = 0; productIdx < 3; productIdx++) {

                Product product = new Product();
                product.setName("продукт "+ projectIdx + "_" + productIdx);
                product.setSerialNumber("sn " + projectIdx + "" + productIdx);
                contract.addProduct(product);

                for (int taskIdx = 0; taskIdx < 5; taskIdx++){
                    Task task = new Task();
                    task.setTask("Задача " + taskIdx + ": чтото сделать с продуктом " + product.getName());
                    product.addTask(task);
                }
            }
            projectRepository.save(project);
        }

        return "ok";
    }
}
