package webscrapepratice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class Excel {

	public void Write(HashMap<Integer, ArrayList<String>> details, String[] title) throws IOException {
	try (HSSFWorkbook workbook = new HSSFWorkbook()) {
		HSSFSheet spreadsheet = workbook.createSheet("job");
		
		HSSFRow row;
		
		//Adding header to first place in hashmap details
		ArrayList<String> header = new ArrayList<String>();
		Collections.addAll(header, title);
		HashMap<Integer, ArrayList<String>> temp= (HashMap<Integer, ArrayList<String>>) details.clone();
		details.clear();
		details.put(0, header);
		details.putAll(temp);
		
		Set<Integer> keyid = details.keySet();
		  
		int rowid = 0;

		// writing the data into the sheets...
		for (Integer key : keyid) {
		    row = spreadsheet.createRow(rowid++);
		    ArrayList<String> jobdetail = details.get(key);
		    int cellid = 0;

		    for (String detail : jobdetail) {
		        Cell cell = row.createCell(cellid++);
		        cell.setCellValue(detail);
		    }
		}

		// writing the workbook into the file...
		FileOutputStream out = new FileOutputStream(
		    new File("merojob.xlsx"));

		workbook.write(out);
		out.close();
	}
	}
}

