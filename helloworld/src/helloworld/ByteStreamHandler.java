package helloworld;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamHandler {

	public static void main(String[] args) throws IOException {
		
		FileInputStream in_stream = null;
		FileOutputStream out_stream = null;
		
		
		try {
			in_stream = new FileInputStream("H:\\My Documents\\Extfiles/my_text_file.text");
			out_stream = new FileOutputStream("H:\\My Documents\\Extfiles/my_new_file.text");
			
			int c;
			while((c = in_stream.read()) != -1) {
				out_stream.write(c);
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			
		}
		finally {
			if (in_stream !=null) {
				in_stream.close();
				
			}
			if(out_stream != null) {
				out_stream.close();
			}
		}
	}
	
	
	
}
