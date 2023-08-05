package edu.jjms.business.services.inter;

import edu.jjms.models.dto.*;

import java.util.List;

public interface ITaskService {
    List<TaskDto> findAll();
    List<TaskDto> findAllTaskByState(StateTaskDto stateTaskDto);
    TaskDto create(CreateTaskDto createTaskDto);
    TaskDto update(UpdateTaskDto updateTaskDto);
    Integer delete(DeleteTaskDto deleteTaskDto);
}
