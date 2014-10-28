package ru.nvd.andr.calcmvc.operations;

public class SummOperationImpl implements Operation {

    @Override
    public Long excecute(Long firstAgr, Long seconArg) {
        if (firstAgr != null && seconArg != null) {
            return (long) (firstAgr + seconArg);
        }
        return null;
    }

}
