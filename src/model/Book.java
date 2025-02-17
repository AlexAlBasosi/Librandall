package model;

public class Book {
	
	private String title;
	private String author;
	private String isbn;
	private boolean isBorrowed;
	private String status;
	private Member member;
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getIsbn() {
		return this.isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public boolean getIsBorrowed() {
		return this.isBorrowed;
	}
	
	public void setIsBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}
	
	public String getStatus() {
		return this.isBorrowed ? "Unavailable" : "Available";
	}
	
	public Member getMember() {
		return this.member;
	}
	
	public void setMember(Member member) {
		this.member = member;
	}
	
	public Book() {
		this.title = "";
		this.author = "";
		this.isbn = "";
		this.isBorrowed = false;
		this.status = this.getStatus();
		this.member = null;
	}
	
	public Book(String title, String author, String isbn, boolean isBorrowed) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.isBorrowed = isBorrowed;
	}
	
	public Book(String title, String author, String isbn, boolean isBorrowed, Member member) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.isBorrowed = isBorrowed;
		this.member = member;
	}
	
	public String toString() {
		return "\n\nTitle: " + this.title
			+ "\nAuthor: " + this.author
			+ "\nISBN: " + this.isbn
			+ "\nStatus: " + this.getStatus() + "\n\n";
	}
}
