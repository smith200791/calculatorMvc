package viewers;

import intf.Viewer;

public class ConsoleViewer implements Viewer {

	public void onView(Double result) {
		System.out.println("console viewer - the result is :" + result);	
	}

}
