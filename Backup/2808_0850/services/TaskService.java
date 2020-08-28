package lab.smk.services;

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
