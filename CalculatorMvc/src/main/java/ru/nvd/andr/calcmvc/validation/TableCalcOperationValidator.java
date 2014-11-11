package ru.nvd.andr.calcmvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import ru.nvd.andr.calcmvc.domain.TableCalcOperations;

public class TableCalcOperationValidator implements ConstraintValidator<TableCalcOperation, TableCalcOperations> {

    @Override
    public void initialize(TableCalcOperation arg0) {
    }

    @Override
    public boolean isValid(TableCalcOperations tableCalcOperations, ConstraintValidatorContext constraintValidatorContext) {
        if ("/".equalsIgnoreCase(tableCalcOperations.getOperation())) {
            return !"0".equals(tableCalcOperations.getSecondarg());
        }
        return false;
    }

}
