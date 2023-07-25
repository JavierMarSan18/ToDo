package edu.jjms.models.dto;

import edu.jjms.models.inter.IDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTaskDto implements IDto {
    @NotBlank(message = "Should not be blank")
    private String description;
    @NotNull(message = "Should no be null")
    private Date startDate;
    private Date endDate;
    @NotNull(message = "Should not be null.")
    private Boolean isCompleted;
}
