package operations;

import intf.Operation;

public class Multiply implements Operation {


    @Override
	public Double operate(Double firstAgr, Double seconArg) {
		if (firstAgr!=null && seconArg!=null) {
			return (double) (firstAgr*seconArg);			
		}
		return null;
	}

}
