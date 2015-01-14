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
	String parent;
	String ip;
	String jpeg;
	
	
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
		this.parent = data[14];
		this.ip = data[15];
		this.jpeg = data[16];
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getNum1() {
		return num1;
	}
	public void setNum1(String num1) {
		this.num1 = num1;
	}
	public String getServer1() {
		return server1;
	}
	public void setServer1(String server1) {
		this.server1 = server1;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public String getNum2() {
		return num2;
	}
	public void setNum2(String num2) {
		this.num2 = num2;
	}
	public String getNum3() {
		return num3;
	}
	public void setNum3(String num3) {
		this.num3 = num3;
	}
	public String getReq_type() {
		return req_type;
	}
	public void setReq_type(String req_type) {
		this.req_type = req_type;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getServer2() {
		return server2;
	}
	public void setServer2(String server2) {
		this.server2 = server2;
	}
	public String getSuburl() {
		return suburl;
	}
	public void setSuburl(String suburl) {
		this.suburl = suburl;
	}
	public String getDel1() {
		return del1;
	}
	public void setDel1(String del1) {
		this.del1 = del1;
	}
	public String getDel2() {
		return del2;
	}
	public void setDel2(String del2) {
		this.del2 = del2;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getJpeg() {
		return jpeg;
	}
	public void setJpeg(String jpeg) {
		this.jpeg = jpeg;
	}
	
	
}
