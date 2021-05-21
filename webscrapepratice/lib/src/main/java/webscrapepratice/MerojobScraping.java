package webscrapepratice;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MerojobScraping {

	public static void main(String[] args) {
		final String url = "https://merojob.com/";
		
		try
		{
			Document doc = Jsoup.connect(url).get();
			for(Element job : doc.select("div.job-card"))
			{
				String alldetaial = job.select("h2.h6.mb-1").text();
				String[] details = alldetaial.split(" • ");
				for(String detail: details)
				{
					System.out.print(detail + "\t");
				}
				System.out.print("\n");
			}
			System.out.println("sucessful");
		}
		catch(Exception ex)
		{
			System.out.println("error : "+ ex);
		}
	}

}
