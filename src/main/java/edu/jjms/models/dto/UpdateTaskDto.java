package edu.jjms.models.dto;

import edu.jjms.models.inter.IDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTaskDto implements IDto {
    @NotNull(message = "Should not be null")
    private Integer id;
    @NotBlank(message = "Should not be blank")
    private String description;
    @NotNull(message = "Should no be null")
    private Date startDate;
    private Date endDate;
    @NotNull(message = "Should not be null.")
    private Boolean isCompleted;


    public UpdateTaskDto(TaskDto taskDto) {
        this.id = taskDto.getId();
        this.description = taskDto.getDescription();
        this.startDate = taskDto.getStartDate();
        this.endDate = taskDto.getEndDate();
        this.isCompleted = taskDto.getIsCompleted();
    }
}
