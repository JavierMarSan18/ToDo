package edu.jjms.models.dto;

import edu.jjms.models.inter.ITask;
import edu.jjms.models.inter.ITaskDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteTaskDto implements ITaskDto {
    private Integer id;

    public DeleteTaskDto(TaskDto taskDto) {
        this.id = taskDto.getId();
    }
}
