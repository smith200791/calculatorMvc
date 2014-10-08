package ru.atc.Calcula.operations;

import ru.atc.Calcula.intf.Operation;

public class Multiply implements Operation {


	public Double operate(Double firstAgr, Double seconArg) {
		if (firstAgr!=null && seconArg!=null) {
			return (double) (firstAgr*seconArg);			
		}
		return null;
	}

}
