package edu.jjms.models.dto;

import edu.jjms.models.inter.ITaskDto;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTaskDto implements ITaskDto{
    private String description;
    private Date startDate;
    private Date endDate;
    private Boolean isCompleted;
}
