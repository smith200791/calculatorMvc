package ru.nvd.andr.calcmvc.operations;

public class DivisionOperationImpl implements Operation {

    @Override
    public Long excecute(Long firstAgr, Long seconArg) {
        if (seconArg != null && firstAgr != null && seconArg != 0) {
            return (long) (firstAgr / seconArg);
        }
        return null;
    }

}
