package operations;

import intf.Operation;

public class Divivsion implements Operation {

    @Override
    
    public Double operate(Double firstAgr, Double seconArg) {
        if (seconArg != null && firstAgr != null && seconArg != 0) {
            return (double) (firstAgr / seconArg);
        }
        return null;
    }

}
