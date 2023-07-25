package edu.jjms.validators.inter;

import edu.jjms.models.inter.IDto;
import edu.jjms.validators.models.DtoValidationResult;

public interface IDtoValidator {
    DtoValidationResult validate(IDto dto);
}
