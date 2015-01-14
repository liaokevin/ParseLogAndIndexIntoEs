import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import Indexing.IndexInES;

import com.google.gson.Gson;

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
			System.out.println("folder is "+folderPath+","+ES_index+","+ES_port+","+ES_server);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		String data=args[0];
		System.out.println(data);
		Scanner lines =new Scanner(data);
		lines.useDelimiter("\n");
		while(lines.hasNext())
		{
			//String data1=scan.next();
			String[] words=lines.next().split(" ");
			Model model=new Model(words);
	        modelList.add(model);
		}
		Gson gson = new Gson();
        String json = gson.toJson(modelList); 
        String modify_json="{\"data\":"+json+"}";
        System.out.println(modify_json);
        
        //Index in Elastic Search
        IndexInES es=new IndexInES(ES_server,ES_port,ES_index,modify_json);
	}

}
