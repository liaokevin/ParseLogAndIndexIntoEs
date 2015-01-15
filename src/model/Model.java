package model;

public class Model {

	String date;
	String time;
	String time_taken;
	String x_cs_dns;
	String sc_status;
	String s_action;
	String sc_bytes;
	String cs_bytes;
	String cs_method;
	String cs_uri_scheme;
	String cs_host;
	String cs_uri_path;;
	String cs_uri_query;
	String del2;
	public String cs_uri_port;
	String cs_username;
	String cs_auth_group;
	String s_hierarchy;
	String s_supplier_name;
	String rs_Content_Type;
	String cs_User_Agent = "";
	String sc_filter_result = "";
	String cs_categories ="";
	String  cs_uri_extension = "";
	String c_ip = "";
	String s_ip = "";
	String x_exception_id="";
	
	
	public Model(String[] data) {
		super();
		 
		this.date = data[0];
		this.time = data[1];
		this.time_taken = data[2];
		this.x_cs_dns = data[3];
		this.sc_status = data[4];
		this.s_action = data[5];
		this.sc_bytes = data[6];
		this.cs_bytes = data[7];
		this.cs_method = data[8];
		this.cs_uri_scheme = data[9];
		this.cs_host = data[10];
		this.cs_uri_path = data[11];
		this.cs_uri_query = data[12];
		//this.del2 = data[13];
		this.cs_uri_port = data[13];
		this.cs_username=data[14];
		this.cs_auth_group=data[15];		
		this.s_hierarchy = data[16];
		this.s_supplier_name = data[17];
		this.rs_Content_Type = data[18];
		this.cs_User_Agent= data[19];
		this.sc_filter_result = data[20];
		this.cs_categories = data[21];
		this.cs_uri_extension = data[22];
		this.c_ip = data[23];
		this.s_ip = data[24];
		this.x_exception_id = data[25];
		
	}	
}
