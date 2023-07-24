package edu.jjms.persistence.repositories.inter;

import edu.jjms.models.dto.CreateTaskDto;
import edu.jjms.models.dto.DeleteTaskDto;
import edu.jjms.models.dto.UpdateTaskDto;
import edu.jjms.models.entities.Task;

import java.util.List;

public interface ITaskRepository {
    List<Task> findAll();
    List<Task> findAllTaskByState(boolean isCompleted);
    void create(Task task);
    void update(Task task);
    void delete(Task task);
}
