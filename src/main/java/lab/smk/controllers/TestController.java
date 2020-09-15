package lab.smk.controllers;

import lab.smk.models.*;
import lab.smk.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/test/add-random-project")
    public @ResponseBody Long addRandomProject (Model model){


        for (int projectIdx = 0; projectIdx < 20; projectIdx++){
            Project project = new Project();

            Contract contract = new Contract();
            contract.setNumber("00" + projectIdx);
            contract.setDate(LocalDate.now().minusDays(projectIdx));
            project.addContract(contract);

            Customer customer = new Customer();
            customer.setName("Фирма " + projectIdx);
            customer.setAddress("улица " + projectIdx + " дом " + projectIdx);
            customer.setComments("комент " + projectIdx);
            contract.addCustomer(customer);

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


        return 0L;

//        int projectCount = 0;
//        while (projectCount < 50) {
//            Customer customer = new Customer();
//            List<Contract> contractList = new ArrayList<Contract>();
//            customer.setName("фирма " + projectCount);
//            customer.setAddress("город, улица, дом");
//            customer.setComments("коментарий");
//            customer.setContracts(contractList);
//            for (int contractCount = 0; contractCount < 3; contractCount++) {
//                Project project = new Project();
//                Contract contract = new Contract();
//                List<Product> productList = new ArrayList<Product>();
//
//                for (int productCount = 0; productCount < 5; productCount++) {
//                    Product product = new Product();
//                    List<Task> taskList = new ArrayList<Task>();
//
//                    for (int taskCount = 0; taskCount < 4; taskCount++) {
//                        Task task = new Task();
//                        task.setTask("задача " + taskCount +
//                                " для продукта " + productCount +
//                                " под договор " + contractCount +
//                                " в проекте " + projectCount);
//                        task.setProduct(product);
//                        taskList.add(task);
//                    }
//                    product.setName("продукт " + productCount);
//                    product.setSerialNumber("00000" + productCount);
//                    product.setTasks(taskList);
//                    product.setContract(contract);
//                    productList.add(product);
//                }
//                contract.setNumber("00" + contractCount);
//                contract.setDate(LocalDate.now().minusDays(contractCount));
//                contract.setProducts(productList);
//                contract.setCustomer(customer);
//                contract.setProject(project);
//
//                project.setContract(contract);
//                projectCount++;
//                projectRepository.save(project);
//            }
//        }
//        return projectRepository.count();
    }



}
