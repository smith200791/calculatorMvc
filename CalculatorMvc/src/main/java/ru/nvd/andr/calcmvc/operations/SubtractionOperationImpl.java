package ru.nvd.andr.calcmvc.operations;

import org.springframework.stereotype.Service;

@Service("-")
public class SubtractionOperationImpl implements Operation {

    @Override
    public Long excecute(Long firstAgr, Long seconArg) {
        if (firstAgr != null && seconArg != null) {
            return (long) (firstAgr - seconArg);
        }
        return null;
    }

}
