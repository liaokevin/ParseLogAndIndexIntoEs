package model;

public class Model {

	String date;
	String time;
	String num1;
	String server1;
	String status;
	String hit;
	String num2;
	String num3;
	String req_type;
	String protocol;
	String server2;
	String suburl;;
	String del1;
	String del2;
	public String port;
	String unknown1;
	String unknown2;
	String parent;
	String ip;
	String jpeg;
	String browser = "";
	String observed = "";
	String contentServer ="";
	String  js_jpg_bmp = "";
	String ip1 = "";
	String ip2 = "";
	String unknown3="";
	
	
	public Model(String[] data) {
		super();
		 
		this.date = data[0];
		this.time = data[1];
		this.num1 = data[2];
		this.server1 = data[3];
		this.status = data[4];
		this.hit = data[5];
		this.num2 = data[6];
		this.num3 = data[7];
		this.req_type = data[8];
		this.protocol = data[9];
		this.server2 = data[10];
		this.suburl = data[11];
		this.del1 = data[12];
		//this.del2 = data[13];
		this.port = data[13];
		this.unknown1=data[14];
		this.unknown2=data[15];		
		this.parent = data[16];
		this.ip = data[17];
		this.jpeg = data[18];
		this.browser = data[19];
		this.observed = data[20];
		this.contentServer = data[21];
		this.js_jpg_bmp = data[22];
		this.ip1 = data[23];
		this.ip2 = data[24];
		this.unknown3 = data[25];
		
	}	
}
