package helloworld;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileApplicationTester  {
	public static void main(String[] args) {
		
		TextFileHandler txt_reader = new TextFileHandler("H:\\My Documents\\Extfiles\\my_new_file.text");
		
		try {
			txt_reader.readFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			txt_reader.writeFile("H:\\My Documents\\Extfiles\\my_new_file2.text");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	

}
