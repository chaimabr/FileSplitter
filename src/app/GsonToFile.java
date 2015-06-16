package app;

import com.google.gson.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class GsonToFile {

	static List<String> arrlist = new LinkedList<String>();
	static List<String> dateList = new LinkedList<String>();
	static List<Integer> countDate = new LinkedList<Integer>();
	
	static String str;
	private static final String TWITTER_DATE_FORMAT = "EEE MMM dd HH:mm:ss Z yyyy";

	static Gson gson = new Gson();
	

	public static void main(String[] args) {
	
		try
		{
			int i=0,j=0;
			    BufferedReader bufferRd = new BufferedReader(new FileReader("D:\\facup.json"));
			    
				FileWriter fileWrite = new FileWriter(new File("5_5_2012_16_15.json"));
				BufferedWriter bufferWr = new BufferedWriter(fileWrite);
				
				while((str = bufferRd.readLine()) != null) 
				{	
					  i++;
		              Tweet p = gson.fromJson(str, Tweet.class);
		            //  System.out.print(p.getCreated_at());
		            if (!(p==null)){
		            	 
		                SimpleDateFormat df = new SimpleDateFormat(TWITTER_DATE_FORMAT, Locale.ENGLISH);
		                if (!(p.getCreated_at()==null)){
		            	Date twiDate = df.parse(p.getCreated_at());
		            	Date date1 = df.parse("Sat May 05 16:14:59 +0000 2012");
		            	Date date2 = df.parse("Sat May 05 16:16:00 +0000 2012");
		            if (twiDate.after(date1) && twiDate.before(date2))
		            {
		            	bufferWr.write(str+"\n");
		            	j++;
		            }} }
				}
				bufferWr.close();
				bufferRd.close();
			  System.out.println("Number of lines read " + i);
			  System.out.println("Number of matched date " + j);
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        }
	}

}

