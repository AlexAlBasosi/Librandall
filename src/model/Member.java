package model;

public class Member {
	
	private int memberId;
	private String name;
	private String contactInfo;
	
	public int getMemberId() {
		return this.memberId;
	}
	
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getContactInfo() {
		return this.contactInfo;
	}
	
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	
	public Member() {
		this.memberId = 0;
		this.name = "";
		this.contactInfo = "";
	}
	
	public Member(int memberId, String name, String contactInfo) {
		this.memberId = memberId;
		this.name = name;
		this.contactInfo = contactInfo;
	}
	
	public String toString() {
		return "\n\nMember ID: " + this.memberId
				+ "\nName: " + this.name
				+ "\nContact Info: " + this.contactInfo + "\n\n";
	}
}
