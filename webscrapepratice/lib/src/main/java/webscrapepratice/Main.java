package webscrapepratice;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

	public static void main(String[] args) {
		final String url = "https://www.google.com/";
		try
		{
			//performs an HTTP request to the given URL
			final Document document = Jsoup.connect(url).get();
			
			//get the title
			final String title = document.title();
			
			//get all the link on the page
			Elements links = document.select("a[href]");
			for(Element link : links)
			{
				//get value from href attributes
				System.out.println("link : " + link.attr("href"));
				System.out.println("Name : " + link.text());
			}
		}
		catch(Exception ex)
		{
			System.out.println("error : " +ex);
		}
	}

}
