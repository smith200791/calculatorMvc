package ru.nvd.andr.calcmvc.operations;

import org.springframework.stereotype.Service;

@Service("/")//сервис в спринге это частное от компонента
public class DivisionOperationImpl implements Operation {

    @Override
    public Long excecute(Long firstAgr, Long seconArg) {
        if (seconArg != null && firstAgr != null && seconArg != 0) {
            return (long) (firstAgr / seconArg);
        }
        return null;
    }

}
