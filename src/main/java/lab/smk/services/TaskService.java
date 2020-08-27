package lab.smk.services;

import lab.smk.models.Task;
import lab.smk.models.system.Account;
import lab.smk.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public Iterable<Task> findAll() {
        return taskRepository.findAll();
    }
}
