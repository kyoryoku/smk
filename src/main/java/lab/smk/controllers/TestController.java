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

    @GetMapping("/test/add-project")
    public @ResponseBody Project addProject (Model model){

        Project project = new Project();
        Contract contract = new Contract();
        Customer customer = new Customer();
        Product product1 = new Product();
        Product product2 = new Product();
        Task task11 = new Task();
        Task task12 = new Task();
        Task task21 = new Task();
        Task task22 = new Task();

        project.setContract(contract);
        contract.setProject(project);

        contract.setCustomer(customer);
        customer.setContract(contract);

        List<Product> productList = new ArrayList<Product>();
        productList.add(product1);
        productList.add(product2);
        contract.setProducts(productList);
        product1.setContract(contract);
        product2.setContract(contract);

        List<Task> taskList1 = new ArrayList<Task>();
        taskList1.add(task11);
        taskList1.add(task12);

        List<Task> taskList2 = new ArrayList<Task>();
        taskList1.add(task21);
        taskList1.add(task22);

        product1.setTasks(taskList1);
        product2.setTasks(taskList2);
        task11.setProduct(product1);
        task12.setProduct(product1);
        task21.setProduct(product2);
        task22.setProduct(product2);

        product1.setName("router 1");
        product2.setName("switch 2");

        task11.setTask("разработать МИ");
        task12.setTask("испытать");

        task21.setTask("испытать");
        task22.setTask("оформить ТО");

        customer.setName("OOO Зеленоглазое такси");
        customer.setAddress("Минск");

        contract.setNumber(Integer.toString((int)(Math.random() * 3000)));
        contract.setDate(LocalDate.now());

        projectRepository.save(project);

        return project;
    }

    @GetMapping("/test/add-random-project")
    public @ResponseBody Long addRandomProject (Model model){

        for(int projectCount = 0; projectCount < 10; projectCount++){

            Project project = new Project();
            Contract contract = new Contract();
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
