package calstatela.com.calstatela.com;

import java.io.File;

public class crawl {
	static String [] filelist ;
	//static File directory = new File("Documents");
public static void main(String args[])
{
	File dir = new File(args[0]);
	fileVisits(dir);
}


public static void fileVisits(File directory) throws NullPointerException{
	
	if(directory.isDirectory())
    {
      File afile[] = directory.listFiles();
       System.out.println("Directory: " + directory.getName());
       if(afile.length > 0)
       {
          for(int i = 0; i < afile.length; i++)
          {
             if(afile[i].isDirectory()){
                //System.out.println("Directory: " + afile[i].getName());
                File subdir = new File(afile[i].getPath());
                fileVisits(subdir);
             }
             else
                System.out.println("File: " + afile[i].getName());
          }
       }
    } else {
     System.out.println("File: " + directory.getName());
    }
}
}
