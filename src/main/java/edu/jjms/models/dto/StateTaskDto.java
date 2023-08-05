package edu.jjms.models.dto;

import edu.jjms.models.inter.ITaskDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StateTaskDto implements ITaskDto {
    private Boolean isCompleted;
}
