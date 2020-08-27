package lab.smk.services.journal;

import lab.smk.models.*;
import lab.smk.models.journals.MINumber;
import lab.smk.models.journals.PINumber;
import lab.smk.models.journals.TestSample;
import lab.smk.models.system.Account;
import lab.smk.repo.TestSampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.SecondaryTable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TestSampleService {
    @Autowired
    TestSampleRepository testSampleRepository;

    public Iterable<TestSample> findAll() {
        return testSampleRepository.findAll();
    }

    public Optional<TestSample> findById(Long id){
        return testSampleRepository.findById(id);
    }

    public String generateTestSample(){

        TestSample testSample = new TestSample();
        Project project = new Project();
        Contract contract = new Contract();
        Customer customer = new Customer();
        Document document = new Document();
        MINumber miNumber = new MINumber();
        PINumber piNumber = new PINumber();
        Product product = new Product();
        Set<Task> tasks = new HashSet<>();
        Task task1 = new Task();

        miNumber.setDocument(document);
        miNumber.setDate(LocalDate.now());
        miNumber.setNumber("МИ.СКЛ 001");

        piNumber.setDocument(document);
        piNumber.setDate(LocalDate.now());
        piNumber.setNumber("ПИ 001");

        document.setMiNumber(miNumber);
        document.setPiNumber(piNumber);
        document.setTask(task1);

        product.setName("маршртузиатор");
        product.setSerialNumber("1234567890");
        product.setTask(task1);

        task1.setContract(contract);
        task1.setDocument(document);
        task1.setProduct(product);
        task1.setTask("провести испытания");

        tasks.add(task1);

        customer.setName("ООО Зеленоглазое такси");
        customer.setAddress("Минск, ул. Прикольная, д. 666");
        customer.setContract(contract);
        customer.setComment("ололо пыщ пыщ это комент для кастомера");

        contract.setCustomer(customer);
        contract.setDate(LocalDate.now());
        contract.setNumber("20/666-H-12");
        contract.setProject(project);
        contract.setStatus("в работе");
        contract.setTasks(tasks);

        project.setStatus("тестовый проект");
        project.setTestSample(testSample);
        project.setContract(contract);

        testSample.setEntryDate(LocalDate.now().minusDays(3));
        testSample.setReturnDate(LocalDate.now());
        testSample.setProject(project);

        testSampleRepository.save(testSample);
        return "";
    }

}
