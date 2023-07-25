package edu.jjms.validators.impl;

import edu.jjms.models.inter.IDto;
import edu.jjms.validators.inter.IDtoValidator;
import edu.jjms.validators.models.DtoValidationResult;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;
public class DtoValidator implements IDtoValidator{

    @Override
    public DtoValidationResult validate(IDto dto) {
        try(ValidatorFactory factory = Validation.buildDefaultValidatorFactory()){
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<IDto>> violations= validator.validate(dto);
            return new DtoValidationResult(violations.isEmpty(), violations);
        }
    }
}
