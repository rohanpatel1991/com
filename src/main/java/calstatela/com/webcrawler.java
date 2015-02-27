package calstatela.com;

import java.io.File;
import java.io.IOException;
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

public class webcrawler {
	
	

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException {
		
		
		//Validate.isTrue(args.length == 1, "usage: supply url to fetch");
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
		
		
		
		File v = new File("hw.txt");
    	if(v.exists())
    	{
    		v.delete();
    	}
    	
		
	new cwl().start();
	}
}
