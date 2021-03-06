package coderbyte.basicwebapp.model;


/** 
 * Bean stores ip address, and its rank of the order of visit/hit 
 * @author venkater
 *
 */

public class BasicWebAppBean {

	private int SNo;
	private String ipAddress;
	
	
	public BasicWebAppBean(int sNo, String ipAddress) {
		super();
		SNo = sNo;
		this.ipAddress = ipAddress;
	}
	public int getSNo() {
		return SNo;
	}
	public void setSNo(int sNo) {
		SNo = sNo;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	@Override
	public String toString() {
		return "BasicWebAppBean [SNo=" + SNo + ", ipAddress=" + ipAddress + "]";
	}
	
	
	
}
