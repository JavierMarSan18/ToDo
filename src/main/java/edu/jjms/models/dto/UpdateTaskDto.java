package edu.jjms.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTaskDto {
    private Integer id;
    private String description;
    private Date startDate;
    private Date endDate;
    private Boolean completed;
}
