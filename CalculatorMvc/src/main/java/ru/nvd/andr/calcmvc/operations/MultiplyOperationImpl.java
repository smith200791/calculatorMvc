package ru.nvd.andr.calcmvc.operations;

import org.springframework.stereotype.Service;

@Service("*")
// сервис в спринге это частное от компонента
public class MultiplyOperationImpl implements Operation {

    @Override
    public Long excecute(Long firstAgr, Long seconArg) {
        if (firstAgr != null && seconArg != null) {
            return (long) (firstAgr * seconArg);
        }
        return null;
    }

}
