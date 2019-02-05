package helloworld;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileHandler extends FileHandler {
	
	FileReader file_reader = null;
	FileWriter file_writer = null;
	File fp;
	char file_data[];
	
	public TextFileHandler() {}
	
	public TextFileHandler(String read_file_name) {
		super(read_file_name);
		this.fp = this.getFp();
		file_data = new char[(int) this.fp.length()];
		super.setFile_size((int) this.fp.length());
		
	}
	
	public TextFileHandler(String read_file_name, String write_file_name) {
		super(read_file_name, write_file_name);
	}

	@Override
	public void writeFile(String file_name) throws IOException {
		// TODO Auto-generated method stub
		
		try {
			file_writer = new FileWriter(file_name);
			int character_count = 0;
			while(character_count < super.getFile_size()) {
				file_writer.write(file_data[character_count++]);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		finally {
			if (file_writer != null) {
				file_writer.close();
				
			}
		}
		
		
	}
	@Override	
	public void readFile() throws IOException {
		
//		if(fp.isFile() && fp.exists()) {
//			try { 
//				file_reader = new FileReader(this.fp);
//				int character_count = 0;
//				int c;
//					while((c = file_reader.read()) != -1) {
//						file_data[character_count++] = (char) c;
//					}
//			}catch (FileNotFoundException e) {
//				e.printStackTrace();					
//			}
//			finally {
//				if(file_reader!= null)
//					file_reader.close();
//			}
//		}
		
		
		
		
		
		
	}
	
	
	

}
