package home;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import Indexing.IndexInES;

import com.google.gson.Gson;
import com.opencsv.CSVReader;

import model.Model;


public class ReadContent {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Model> modelList=new ArrayList<Model>();
		
		Properties properties=new Properties();
		 String folderPath="";
		 String ES_server="";
		 String ES_port="";
		 String ES_index="";
		 try {
			properties.load(new FileInputStream(new File("api.properties")));
			
			folderPath=properties.getProperty("Folder");
			ES_server=properties.getProperty("ES_server");
			ES_port=properties.getProperty("ES_port");
			ES_index=properties.getProperty("ES_index");
			//System.out.println("folder is "+folderPath+","+ES_index+","+ES_port+","+ES_server);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		System.out.println(args.length);
		String data="";
		for(int i=0;i<args.length;i++)
		{
			data+=args[i];
		}
		System.out.println(data);

		Scanner lines =new Scanner(data);
		lines.useDelimiter("\n");char seperator=' ';
		while(lines.hasNext())
		{
			
			/*String[] words=lines.next().split(" ");
			Model model=new Model(words);
	        modelList.add(model);*/
			
			 
       	  CSVReader reader = new CSVReader(new StringReader(lines.next()),seperator);

       	  String [] tokens;
       	  try {
			while ((tokens = reader.readNext()) != null) {
			      System.out.println(tokens[0]); // value1
			      
			      Model model=new Model(tokens);
			      modelList.add(model);
			  }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}
		Gson gson = new Gson();
        String json = gson.toJson(modelList); 
        String modify_json="{\"data\":"+json+"}";
        System.out.println(modify_json);
        
        //Index in Elastic Search
        IndexInES es=new IndexInES(ES_server,ES_port,ES_index,modify_json);
	}

}
