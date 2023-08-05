package edu.jjms.presentation.impl;

import edu.jjms.business.services.inter.ITaskService;
import edu.jjms.models.dto.*;
import edu.jjms.presentation.inter.ITaskController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TaskController implements ITaskController {

    private final ITaskService taskService;

    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }


    @Override
    public CompletableFuture<List<TaskDto>> findAll() {
        return CompletableFuture.supplyAsync(taskService::findAll);
    }

    @Override
    public CompletableFuture<List<TaskDto>> findAllTaskByState(StateTaskDto stateTaskDto) {
        return CompletableFuture.supplyAsync(() -> taskService.findAllTaskByState(stateTaskDto));

    }

    @Override
    public CompletableFuture<TaskDto> create(CreateTaskDto createTaskDto) {
        return CompletableFuture.supplyAsync(() -> taskService.create(createTaskDto));
    }

    @Override
    public CompletableFuture<TaskDto> update(UpdateTaskDto updateTaskDto) {
        return CompletableFuture.supplyAsync(() -> taskService.update(updateTaskDto));
    }

    @Override
    public CompletableFuture<Integer> delete(DeleteTaskDto deleteTaskDto) {
        return CompletableFuture.supplyAsync(() -> taskService.delete(deleteTaskDto));
    }
}
