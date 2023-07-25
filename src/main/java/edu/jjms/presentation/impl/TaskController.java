package edu.jjms.presentation.impl;

import edu.jjms.business.services.inter.ITaskService;
import edu.jjms.models.dto.CreateTaskDto;
import edu.jjms.models.dto.DeleteTaskDto;
import edu.jjms.models.dto.TaskDto;
import edu.jjms.models.dto.UpdateTaskDto;
import edu.jjms.presentation.inter.ITaskController;

import jakarta.validation.Valid;
import java.util.List;

public class TaskController implements ITaskController {

    private final ITaskService taskService;

    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public List<TaskDto> findAll() {
        return taskService.findAll();
    }

    @Override
    public List<TaskDto> findAllTaskByState(boolean isCompleted) {
        return taskService.findAllTaskByState(isCompleted);
    }

    @Override
    public TaskDto create(@Valid CreateTaskDto createTaskDto) {
        return taskService.create(createTaskDto);
    }

    @Override
    public TaskDto update(@Valid UpdateTaskDto updateTaskDto) {
        return taskService.update(updateTaskDto);
    }

    @Override
    public Integer delete(@Valid DeleteTaskDto deleteTaskDto) {
        return taskService.delete(deleteTaskDto);
    }
}
