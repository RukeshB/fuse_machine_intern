package ReadAndWriteFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class EditCsvFile {

	public static Scanner input;
	public static void main(String[] args) {
		String filename = "records.txt";
		String editTerm = "2222";
		String newID = "4444";
		String newName = "season";
		String newAge = "25";
		
		editRecord(filename,editTerm,newID,newName,newAge);
	}

	public static void editRecord(String fileName,String editTerm, String newID,String newName, String newAge)
	{
		String tempFile = "temp.txt";
		File oldFile = new File(fileName);
		File newFile = new File(tempFile);
		String id,name,age;
		
		try {
			FileWriter writer = new FileWriter(tempFile,true);
			BufferedWriter bWriter = new BufferedWriter(writer);
			PrintWriter pWriter = new PrintWriter(bWriter);
			input = new Scanner(new File(fileName));
			input.useDelimiter("[,\n]");
			
			while(input.hasNext())
			{
				id = input.next();
				name = input.next();
				age = input.next();
				
				if(id.equals(editTerm))
				{
					pWriter.println(newID+","+newName+","+newAge);
				}
				else
				{
					pWriter.println(id+","+name+","+age);
				}
			}
			input.close();
			pWriter.flush();
			pWriter.close();
			oldFile.delete();
			File copy = new File(fileName);
			newFile.renameTo(copy);
		}
		catch(Exception e)
		{
			System.out.println("error"+e);
		}
		
	}
}
