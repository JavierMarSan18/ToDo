package edu.jjms.models.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTaskDto {
    private String description;
    private Date startDate;
    private Date endDate;
    private Boolean isCompleted;

}
