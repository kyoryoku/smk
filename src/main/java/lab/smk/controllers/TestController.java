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



        for(int projectCount = 0; projectCount < 10; projectCount++){

            Project project = new Project();
            Customer customer = new Customer();
            List<Contract> contractList = new ArrayList<Contract>();
            for(int contractCount = 0; contractCount < 3; contractCount++){
                Contract contract = new Contract();
                List<Product> productList = new ArrayList<Product>();

                for (int productCount = 0; productCount < 5; productCount++){
                    Product product = new Product();
                    List<Task> taskList = new ArrayList<Task>();

                    for (int taskCount = 0; taskCount < 4; taskCount++){
                        Task task = new Task();
                        task.setTask("задача " + taskCount +
                                " для продукта " + productCount +
                                " под договор " + contractCount +
                                " в проекте " + projectCount);
                        task.setProduct(product);
                        taskList.add(task);
                    }
                    product.setName("продукт " + productCount);
                    product.setSerialNumber("00000" + productCount);
                    product.setTasks(taskList);
                    product.setContract(contract);
                    productList.add(product);
                }
                contract.setNumber("00" + contractCount);
                contract.setDate(LocalDate.now().minusDays(contractCount));
                contract.setProducts(productList);
                contract.setCustomer(customer);
                contract.setProject(project);

                project.setContract(contract);
            }
            customer.setName("фирма " + projectCount);
            customer.setAddress("город, улица, дом");
            customer.setComments("коментарий");
            customer.setContracts(contractList);

        }


        for(int projectCount = 0; projectCount < 10; projectCount++){

            Project project = new Project();
            List<Contract> contractList = new ArrayList<Contract>();
            Customer customer = new Customer();
            List<Product> productList = new ArrayList<Product>();

            project.setContract(contract);

            contract.setProject(project);
            contract.setCustomer(customer);
            contract.setProducts(productList);
            contract.setNumber("000" + projectCount);
            contract.setDate(LocalDate.now().minusDays(projectCount));

            customer.setContract(contract);
            customer.setName("Фирма_" + projectCount);
            customer.setAddress("Какойто город_" + projectCount
                    + ", какая улица_" + projectCount
                    + ", какойто дом_" + projectCount);
            customer.setComments("просто коментарий ололо..");

            for(int i = 0; i < 1 + (int)(Math.random() * 3 * 10); i++){

                Product product = new Product();
                List<Task> taskList = new ArrayList<Task>();

                for(int j = 0; j < 1 + (int)(Math.random() * 5 * 10); j++){
                    Task task = new Task();
                    task.setProduct(product);
                    task.setTask("Выполнить ченить   " + j + "   для продукта   " + i);
                    taskList.add(task);
                }
                product.setTasks(taskList);
                product.setName("Продукт  " + i);
                product.setContract(contract);
                product.setSerialNumber(Integer.toString((int)(Math.random() * 100000)));

                productList.add(product);
            }

            projectRepository.save(project);


        }

        return projectRepository.count();
    }



}
