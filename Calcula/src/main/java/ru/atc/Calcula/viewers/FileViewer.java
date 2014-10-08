package ru.atc.Calcula.viewers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import ru.atc.Calcula.intf.Viewer;


public class FileViewer implements Viewer {

	public void onView(Double result) {
		try {
			File file = new File("/Users/macbookretina/Downloads/example.txt");
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			output.write("result is :" + result.toString());
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
