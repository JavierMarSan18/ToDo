package edu.jjms.mappers.inter;

import edu.jjms.models.dto.CreateTaskDto;
import edu.jjms.models.dto.DeleteTaskDto;
import edu.jjms.models.dto.TaskDto;
import edu.jjms.models.dto.UpdateTaskDto;
import edu.jjms.models.entities.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ITaskMapper {
    ITaskMapper INSTANCE = Mappers.getMapper(ITaskMapper.class);
    Task toEntity(TaskDto dto);
    Task toEntity(CreateTaskDto createTaskDto);
    Task toEntity(UpdateTaskDto updateTaskDto);
    Task toEntity(DeleteTaskDto deleteTaskDto);
    TaskDto toDto(Task task);
}