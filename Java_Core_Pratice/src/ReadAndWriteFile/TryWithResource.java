package ReadAndWriteFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResource {

	public static void main(String[] args) {
		File file = new File("test.txt");
		try(BufferedReader bufferReader = new BufferedReader(new FileReader(file))) {
			
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

	}

}
