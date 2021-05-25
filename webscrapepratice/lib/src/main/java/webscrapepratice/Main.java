package webscrapepratice;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		String[] title = {"Link","Company Name","Company Category","Company Discription","Job Title",
				"Job Category","Job Level","No. of Vacancy/s","Employment Type","Job Location",
				"Offered Salary","Apply Before(Deadline)","Education Level","Experience Required",
				"Professional Skill Required"};
		
		//scraping merojob website
		MerojobScraping meroJob = new MerojobScraping();
		meroJob.Scrap();
		
		//exporting scraped data to excel
		Excel writeToExcel = new Excel();
		writeToExcel.Write(meroJob.getJobdetails(),title);
		
		System.out.println(meroJob.getJobdetails());
	}

}
