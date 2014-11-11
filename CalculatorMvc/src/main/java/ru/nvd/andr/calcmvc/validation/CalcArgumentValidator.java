package ru.nvd.andr.calcmvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CalcArgumentValidator implements ConstraintValidator<CalcArgument, String> {

    @Override
    public void initialize(CalcArgument constraintAnnotation) {
    }

    @Override
    public boolean isValid(String argument, ConstraintValidatorContext context) {
        try {
            Long.parseLong(argument);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
