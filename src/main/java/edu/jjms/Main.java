package edu.jjms;

import edu.jjms.business.services.impl.TaskService;
import edu.jjms.business.services.inter.ITaskService;
import edu.jjms.mappers.inter.ITaskMapper;
import edu.jjms.persistence.repositories.impl.TaskRepository;
import edu.jjms.persistence.repositories.inter.ITaskRepository;
import edu.jjms.presentation.impl.TaskController;
import edu.jjms.presentation.inter.ITaskController;
import edu.jjms.ui.ToDoApp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        ITaskMapper mapper = ITaskMapper.INSTANCE;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TaskPU");
        EntityManager entityManager = factory.createEntityManager();
        ITaskRepository repository = new TaskRepository(entityManager);
        ITaskService service = new TaskService(repository, mapper);
        ITaskController controller = new TaskController(service);
        ToDoApp toDoApp = new ToDoApp(controller);
        toDoApp.start();
    }
}