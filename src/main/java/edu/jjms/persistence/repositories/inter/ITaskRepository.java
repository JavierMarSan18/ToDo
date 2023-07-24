package edu.jjms.persistence.repositories.inter;

import edu.jjms.models.dto.CreateTaskDto;
import edu.jjms.models.dto.DeleteTaskDto;
import edu.jjms.models.dto.UpdateTaskDto;
import edu.jjms.models.entities.Task;

import java.util.List;

public interface ITaskRepository {
    List<Task> findAll();
    List<Task> findAllTaskByState(boolean isCompleted);
    Task create(Task task);
    Task update(Task task);
    Integer delete(Task task);
}
