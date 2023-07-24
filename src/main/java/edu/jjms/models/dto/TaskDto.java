package edu.jjms.models.dto;

import lombok.*;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private Integer id;
    private String description;
    private Date startDate;
    private Date endDate;
    private Boolean isCompleted;
}
