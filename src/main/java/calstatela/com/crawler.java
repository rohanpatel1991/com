package calstatela.com;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.tika.exception.TikaException;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.xml.sax.SAXException;

public class crawler {
	
	
	
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException, SAXException, TikaException{
		Validate.isTrue(args.length == 1, "usage: supply url to fetch");
		TrustManager[] trustAllCerts = new TrustManager[] {
			       new X509TrustManager() {
					
					public X509Certificate[] getAcceptedIssuers() {
						// TODO Auto-generated method stub
						return null;
					}
					
					public void checkServerTrusted(X509Certificate[] chain, String authType)
							throws CertificateException {
						// TODO Auto-generated method stub
						
					}
					
					public void checkClientTrusted(X509Certificate[] chain, String authType)
							throws CertificateException {
						// TODO Auto-generated method stub
						
					}
			       }
				}; 
		SSLContext sc = SSLContext.getInstance("SSL");
	    sc.init(null, trustAllCerts, new java.security.SecureRandom());
	    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

	    // Create all-trusting host name verifier
	    HostnameVerifier allHostsValid = new HostnameVerifier() {
	        public boolean verify(String arg0, SSLSession arg1) {
				// TODO Auto-generated method stub
				return false;
			}
	    };
	    // Install the all-trusting host verifier
	    HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	    
	    
	    
	    File f = new File("file1.json");
	    
	    if(f.exists()){
	    	f.delete();
	    }
	    
	    
	    
	  
	    
		String link = null ;
		Document doc = Jsoup.connect("http://www.facebook.com").get();
		
		Elements anchors = doc.getElementsByTag("a");
		//Elements anchors = doc.select("#mp-itn b a");
		//Elements images = doc.getElementsByTag("img");
		 
		String title = doc.title();
		System.out.println("title:::"+title);
		
		//String txt=null;
				
		if(!anchors.isEmpty()){
			
			Elements media = doc.select("img");
			for (Element src : media) {
	            if (src.tagName().equals("img")){
	            	System.out.println(src.tagName()+"\t"+src.attr("abs:src"));
	            }
	        }
			int i=0;
		
		for (org.jsoup.nodes.Element anchor: anchors){
			
			System.out.println(anchor.attr("abs:href"));
		
			
			
			
			
			
			URL website = new URL(anchor.attr("abs:href"));
			
			String u = website.openConnection().getContentType();
			
			String d = website.openConnection().getHeaderField("Last-Modified");
			
			if(u.equals("application/pdf")){
				System.out.println("PDF>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+website);
			}
			
			System.out.println(u);
			System.out.println(d);
			
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream("/Users/rohanpatel/Documents/workspace1/com/html/information"+i+".html");
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			
		
			File htm = new File("/Users/rohanpatel/Documents/workspace1/com/html/information"+i+".html");
			
			extraction.extract(htm,website);
			i++;
			link = (String)anchor.attr("abs:href");
			
		//	txt = anchor.text();
			//System.out.println("text:"+txt);
					
			//i++;
		
		//for(int j=0; j<i; j++){
		//if(!link.isEmpty()){
			
			Document doc1 = Jsoup.connect(link).get();
					//.userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0").referrer("http://www.google.com").get();
			Elements anchors1 = doc1.getElementsByTag("a");
			//int size = anchors1.size();
		//	System.out.println(size+"\n");
			
			for (org.jsoup.nodes.Element anchor1: anchors1){
				if(anchor1.hasAttr("abs:href")){
					
				//System.out.println("hiiiiii::"+anchor1.attr("abs:href"));
				//size--; 
					
					
					
					
			}
				
			}
			//}
		//	}
	//	else{
			//System.out.println("link:"+link);
		//}
		
			}
		}
	}
	
	
	

}
