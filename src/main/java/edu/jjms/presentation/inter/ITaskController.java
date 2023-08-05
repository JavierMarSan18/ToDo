package edu.jjms.presentation.inter;
import edu.jjms.models.dto.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ITaskController {
    CompletableFuture<List<TaskDto>> findAll();
    CompletableFuture<List<TaskDto>> findAllTaskByState(StateTaskDto stateTaskDto);
    CompletableFuture<TaskDto> create(CreateTaskDto createTaskDto);
    CompletableFuture<TaskDto> update(UpdateTaskDto updateTaskDto);
    CompletableFuture<Integer> delete(DeleteTaskDto deleteTaskDto);
}
