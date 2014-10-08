package ru.atc.Calcula.operations;

import ru.atc.Calcula.intf.Operation;

public class Divivsion implements Operation {

    
    public Double operate(Double firstAgr, Double seconArg) {
        if (seconArg != null && firstAgr != null && seconArg != 0) {
            return (double) (firstAgr / seconArg);
        }
        return null;
    }

}
