package calstatela.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class extraction {

	public static void extract(File url, URL website) throws IOException, SAXException, TikaException{
		
		
		/*InputStream input = new FileInputStream(url);
        ContentHandler textHandler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        AutoDetectParser parser = new AutoDetectParser();
        ParseContext context = new ParseContext();
        parser.parse(input, textHandler, metadata, context);*/
		
       
        JSONObject obj = new JSONObject();
        obj.put("Local path", url+"\n");
        obj.put("URL", website+"\n");
        obj.put("date", website.openConnection().getHeaderField(1)+"\n");
        
        File f = new File("file1.json");
        FileWriter file = new FileWriter(f, true);
        
        String website1 = website.toString();
       
    	Document doc1 = Jsoup.connect(website1).get();
		//.userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0").referrer("http://www.google.com").get();
Elements anchors1 = doc1.getElementsByTag("a");
//int size = anchors1.size();
//	System.out.println(size+"\n");

JSONArray links = new JSONArray();

for (org.jsoup.nodes.Element anchor1: anchors1){
	if(anchor1.hasAttr("abs:href")){
		
	//System.out.println("hiiiiii::"+anchor1.attr("abs:href"));
	//size--; 

        
        
        
        links.add("link: "+anchor1.attr("abs:href"));
        links.add("\n");
        
        
        
	}
}
obj.put("url", links);
        file.write(obj.toJSONString()+"\n");
        System.out.println("Successfully Copied JSON Object to File...");
        System.out.println("\nJSON Object: " + obj);
        
        
        
        
        file.flush();
		file.close();
	}
}
