package webscrapepratice;

import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MerojobScraping {

	private ArrayList<String> jobs = new ArrayList<String>() ;
	private HashMap<Integer, ArrayList<String>> jobdetails = new HashMap<Integer, ArrayList<String>>();

	public HashMap<Integer, ArrayList<String>> getJobdetails() {
		return jobdetails;
	}

	public void setJobdetails(HashMap<Integer, ArrayList<String>> jobdetails) {
		this.jobdetails = jobdetails;
	}

	public void Scrap() {
		int jobnumber = 0;
		HashMap<Integer, ArrayList<String>> alldata = new HashMap<Integer, ArrayList<String>>();
		final String url = "https://merojob.com";
		try
		{
			Document doc = Jsoup.connect(url).get();
			String link= "";
			for(Element element : doc.select("div.job-card"))
			{
				jobs = new ArrayList<String>();
				//get job link from merojob.com
				link = element.select("h2.h6.mb-1 a[href]").attr("href");
				
				if(link != "")
				{
					//getting detail of job 
					final String indjoblink = url+link;
					jobnumber++;
					JobDetail(indjoblink,jobnumber);
					alldata.put(jobnumber, jobs);
				}
			}
			
			//setting job detail to a veriable
			setJobdetails(alldata);
			//System.out.println(getJobdetails());
			System.out.println("sucessful");
		}
		catch(Exception ex)
		{
			System.out.println("error : "+ ex);
		}
	}
	
	public void JobDetail(String link,int jobnumber)
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
			jobs.add(description);
			jobs.add(jobTitle);
			
			for(Element element : elements.select("div.card-body div.card-group"))
			{
			
				for(Element subelement: element.select("table.table.table-hover.table-no-border.m-0 tbody tr"))
				{
					String information = subelement.text();
					
					String[] details = information.split(" : ");
					jobs.add(details[1]);
				}
			}			
			//System.out.println(jobs);
			//System.out.println(jobdetails);
			//System.out.print("\n\n");
		}
		catch(Exception ex)
		{
			System.out.println("error : "+ex);
		}
	}

}
