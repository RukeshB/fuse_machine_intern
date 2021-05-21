package webscrapepratice;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class MerojobScraping {

	public static void main(String[] args) {
		final String url = "https://merojob.com";
		
		try
		{
			Document doc = Jsoup.connect(url).get();
			for(Element element : doc.select("div.job-card"))
			{
				String alldetail = element.select("h2.h6.mb-1").text();
				String link = element.select("h2.h6.mb-1 a[href]").attr("href");
				
				if(alldetail != "")
				{
					String[] details = alldetail.split(" • ");
					String company="";
					String job="";
					int index=0;
					for(String detail: details)
					{
						if(index==0)
						company = detail;
						
						if(job != "")
						job = job + ", "+ detail;
						
						job = detail;
						index++;
						//System.out.print(detail + "\t");
					}
					System.out.println(company + " => " + job +" => " + url+link);
					//System.out.print("\n");
				}
				
			}
			System.out.println("sucessful");
		}
		catch(Exception ex)
		{
			System.out.println("error : "+ ex);
		}
	}

}
