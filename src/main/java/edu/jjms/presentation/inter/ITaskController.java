package edu.jjms.presentation.inter;

import edu.jjms.models.dto.CreateTaskDto;
import edu.jjms.models.dto.DeleteTaskDto;
import edu.jjms.models.dto.TaskDto;
import edu.jjms.models.dto.UpdateTaskDto;

import java.util.List;

public interface ITaskController {
    List<TaskDto> findAll();
    List<TaskDto> findAllTaskByState(boolean isCompleted);
    TaskDto create(CreateTaskDto createTaskDto);
    TaskDto update(UpdateTaskDto updateTaskDto);
    Integer delete(DeleteTaskDto deleteTaskDto);
}
