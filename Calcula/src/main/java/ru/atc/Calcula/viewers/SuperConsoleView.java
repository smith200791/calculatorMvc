package ru.atc.Calcula.viewers;

import ru.atc.Calcula.intf.Viewer;

public class SuperConsoleView implements Viewer {

	public void onView(Double result) {
		System.out.println("the super puper sping framework, \n and result is :" + result);

	}

}
