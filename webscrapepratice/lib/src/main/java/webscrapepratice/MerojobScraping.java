package webscrapepratice;

import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MerojobScraping {

	public static ArrayList<String> jobs ;
	public static HashMap<Integer, ArrayList<String>> jobdetails = new HashMap<Integer, ArrayList<String>>();
	
	public static void main(String[] args) {
		int jobnumber = 0;
		final String url = "https://merojob.com";
		try
		{
			Document doc = Jsoup.connect(url).get();
			String link= "";
			for(Element element : doc.select("div.job-card"))
			{
				jobs = new ArrayList<String>();
				String alldetail = element.select("h2.h6.mb-1").text();
				link = element.select("h2.h6.mb-1 a[href]").attr("href");
				
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
					
					//getting detail of job 
					final String indjoblink = url+link;
					jobnumber++;
					JobDetail(indjoblink,jobnumber);
				}
				
			}
			
			System.out.println("sucessful");
		}
		catch(Exception ex)
		{
			System.out.println("error : "+ ex);
		}
	}
	
	public static void JobDetail(String link,int jobnumber)
	{
		
		try
		{
			Document doc = Jsoup.connect(link).get();
			Elements elements = doc.select("div.container.my-3 div.row.my-3 div.col-md-8");
			String companyName = elements.select("div.media div.media-body.mt-4 h2.h5.my-0 a.text-white span").text();
			String jobCatagory = elements.select("div.media div.media-body.mt-4 h2.h5.my-0 div.text-white.h6").text();
			String description = elements.select("div#short-description").text();
			String jobTitle = elements.select("div.card div.card-header div.float-left h1.h4.mb-0.text-primary").text();
			
			jobs.add(link);
			jobs.add(companyName);
			jobs.add(jobCatagory);
			//jobs.add(description);
			jobs.add(jobTitle);
			//System.out.println("company Name => "+companyName);
			//System.out.println("job Catagory => "+jobCatagory);
			//System.out.println("description => "+description);
			//System.out.println("jobTitle => "+jobTitle);
			
			//System.out.println("");
			for(Element element : elements.select("div.card-body div.card-group"))
			{
				String header = element.select("div.card-header.p-2 h3.mb-1.h6 strong").text();
				//System.out.println(header);
				
				for(Element subelement: element.select("table.table.table-hover.table-no-border.m-0 tbody tr"))
				{
					String information = subelement.text();
					
					String[] details = information.split(" : ");
					jobs.add(details[1]);
					
					//System.out.println(information);
				}
				//System.out.println("");
			}
			
			System.out.println(jobs);
			jobdetails.put(jobnumber, jobs);
			System.out.println(jobdetails);
			System.out.print("\n\n");
			
			
		}
		catch(Exception ex)
		{
			System.out.println("error : "+ex);
		}
	}

}
