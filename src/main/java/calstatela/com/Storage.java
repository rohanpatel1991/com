package calstatela.com;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Storage {

	public static void save(ArrayList<String> mylist) throws IOException {
		
		 BufferedWriter output=null;
		try {
			
			/*
			 * http://stackoverflow.com/questions/2885173/java-how-to-create-a-file-and-write-to-a-file
			 */
			
			File file = new File("hw.txt");
			file.createNewFile();
	       output = new BufferedWriter(new FileWriter(file,true));
	     /*  for(int i=0;i<=mylist.size();i++)
	       {
	        output.write(mylist.get(i)+ "\t");*/
	       for (String s : mylist)
		    {
			 output.write(s);
			 output.newLine();
			 }
	       
	        
	       
	        //output.write("date:"+metadata.values().toString()+"\n");
	      //  output.write("Author:"+ metadata.keySet().toString()+"\t\n");
	        output.close();
				
		}
	catch(Exception e)
		{
		
		}
	}
}
