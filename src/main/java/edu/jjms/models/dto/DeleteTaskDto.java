package edu.jjms.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteTaskDto {
    private Integer id;

    public DeleteTaskDto(TaskDto taskDto) {
        this.id = taskDto.getId();
    }
}
