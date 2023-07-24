package edu.jjms.business.services.impl;

import edu.jjms.business.services.inter.ITaskService;
import edu.jjms.mappers.inter.ITaskMapper;
import edu.jjms.models.dto.CreateTaskDto;
import edu.jjms.models.dto.DeleteTaskDto;
import edu.jjms.models.dto.TaskDto;
import edu.jjms.models.dto.UpdateTaskDto;
import edu.jjms.persistence.repositories.inter.ITaskRepository;

import java.util.List;

public class TaskService implements ITaskService {

    private final ITaskRepository taskRepository;
    private final ITaskMapper taskMapper;

    public TaskService(ITaskRepository taskRepository, ITaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public List<TaskDto> findAll() {
        return taskRepository.findAll()
                            .stream().map(taskMapper::toDto).toList();
    }

    @Override
    public List<TaskDto> findAllTaskByState(boolean isCompleted) {
        return taskRepository.findAllTaskByState(isCompleted)
                                .stream().map(taskMapper::toDto).toList();
    }

    @Override
    public TaskDto create(CreateTaskDto createTaskDto) {
        return taskMapper.toDto(taskRepository.create(taskMapper.toEntity(createTaskDto)));
    }

    @Override
    public TaskDto update(UpdateTaskDto updateTaskDto) {
        return taskMapper.toDto(taskRepository.update(taskMapper.toEntity(updateTaskDto)));
    }

    @Override
    public Integer delete(DeleteTaskDto deleteTaskDto) {
        return taskRepository.delete(taskMapper.toEntity(deleteTaskDto));
    }
}
