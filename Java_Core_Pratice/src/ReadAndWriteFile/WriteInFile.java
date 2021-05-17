package ReadAndWriteFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteInFile {

	public static void main(String[] args) {
		File file = new File("D:\\fuse_machine_intern\\Java_Core_Pratice\\WriteTest.txt");
		try(BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(file,true)))
		{
			bufferWriter.write("1st Line");
			bufferWriter.newLine();
			bufferWriter.write("2nd Line \n3rd Line\n");
		}catch(IOException e) {
			System.out.println("Unable to Open a File : " + file.toString());
		}

	}

}
