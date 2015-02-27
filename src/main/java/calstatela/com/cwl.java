package calstatela.com;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class cwl {
	public void start() throws IOException{
		crawl();
	}
	public void crawl() throws IOException{
		String crawlurl = this.getCrawlUrl();
		ArrayList<String> mylist = new ArrayList<String>();
			Document doc = Jsoup.connect(crawlurl).get();
			Elements anchors = doc.getElementsByTag("a");
			
			for(Element anchor : anchors)
			{
				 String result = anchor.attr("abs:href").trim();
				 
				 Document doc1 = Jsoup.connect(result).get();
					Elements anchors1 = doc1.select("a");
					for(Element anchor1 : anchors1)
					{
						 String result1 = anchor1.attr("abs:href").trim();
						 if(!mylist.contains(result1))
						 {
							 mylist.add(result1);
							// extraction.extract(result1);
							 
						 }
					}
				 
				if(!mylist.contains(result))
				{
					mylist.add(result);
					
				}
			}
			System.out.println(mylist.size()+"\n");
			
			Storage.save(mylist);
			for (String p : mylist)
			    {
				 System.out.println(p);
				 }
			
			}
	
	
	
	public String getCrawlUrl()
	{
	
		String url="http://www.facebook.com/";
		return url;
	}
}
