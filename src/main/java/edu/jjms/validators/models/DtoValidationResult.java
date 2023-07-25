package edu.jjms.validators.models;

import edu.jjms.models.inter.IDto;
import jakarta.validation.ConstraintViolation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoValidationResult {
    private Boolean isValid;
    private Set<ConstraintViolation<IDto>> violations;
}
