package lab.smk.services;

import lab.smk.models.Project;
import lab.smk.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }
}
