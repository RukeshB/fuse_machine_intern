package ReadAndWriteFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		File file = new File("test.txt");
		FileReader readFile;
		BufferedReader bufferReader = null;
		try {
			readFile = new FileReader(file);
			bufferReader = new BufferedReader(readFile);
			
			String line ;
			
			while((line=bufferReader.readLine()) != null)
			{
				System.out.println(line);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found : "+file.toString());
		} catch (IOException e) {
			System.out.println("Unable to open File : "+file.toString());
		}
		
		finally
		{
			try {
				bufferReader.close();
			} catch (IOException e) {
				System.out.println("Unable to Close a File : "+ file.toString());
			}
		}
	}

}
