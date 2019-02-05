package helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br_console = new BufferedReader(
				new InputStreamReader (System.in));
		
		System.out.println("Enter 'stop' to quit.");
		
		String str = null;
		do {
			
			str = br_console.readLine();
			System.out.println(str);
			
		}while(!str.equals("stop"));
	}
}
