import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import Indexing.IndexInES;

import com.google.gson.Gson;
import com.opencsv.CSVReader;

import model.Model;

public class ReadCsv {  
 public static void main(String args[]) {  
	 
	 
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
	 
	 
	 
	 File folder = new File(folderPath);
	 File[] listOfFiles = folder.listFiles();

	 for (File file : listOfFiles) {
	     if (file.isFile()) {
	         
	    	 System.out.println(file.getName());
	         //String csvFileToRead = "F:\\SPARK\\data\\antwerpen-proxy_basfmain_1311060054.log";
	         List<Model> modelList=new ArrayList<Model>();
	         BufferedReader br = null;  
	         String line = "";  
	         String splitBy = " ";  
	         
	         try {  
	         
	          br = new BufferedReader(new FileReader(file));  
	          while ((line = br.readLine()) != null) {  
	         
	           //String[] data = line.split(splitBy);  
	        	  char seperator=' ';
	        	  CSVReader reader = new CSVReader(new StringReader(line),seperator);

	        	  String [] tokens;
	        	  while ((tokens = reader.readNext()) != null) {
	        	      System.out.println(tokens[0]); // value1
	        	      
	        	      Model model=new Model(tokens);
	    	          modelList.add(model);
	        	  }
	                    
	          
	          
	           
	          } 
	          Gson gson = new Gson();
	          String json = gson.toJson(modelList); 
	          String modify_json="{\"data\":"+json+"}";
	          System.out.println(modify_json);
	          
	          //Index in Elastic Search
	          IndexInES es=new IndexInES(ES_server,ES_port,ES_index,modify_json);
	         
	         } catch (FileNotFoundException e) {  
	          e.printStackTrace();  
	         } catch (IOException e) {  
	          e.printStackTrace();  
	         } finally {  
	          if (br != null) {  
	           try {  
	            br.close();  
	           } catch (IOException e) {  
	            e.printStackTrace();  
	           }  
	          }  
	         }
	     }
	 }
  
  
  System.out.println("Done with reading CSV");  
 }  
}  