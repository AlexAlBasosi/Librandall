package model;

public class Book {
	
	private String title;
	private String author;
	private String isbn;
	private boolean isBorrowed;
	private String status;
	// private Member member;
	
	String getTitle() {
		return this.title;
	}
	
	void setTitle(String title) {
		this.title = title;
	}
	
	String getAuthor() {
		return this.author;
	}
	
	void setAuthor(String author) {
		this.author = author;
	}
	
	String getIsbn() {
		return this.isbn;
	}
	
	void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	boolean getIsBorrowed() {
		return this.isBorrowed;
	}
	
	void setIsBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}
	
	String getStatus() {
		return this.isBorrowed ? "Unavailable" : "Available";
	}
	
	public String toString() {
		return "\n\nTitle: " + this.title
			+ "\nAuthor: " + this.author
			+ "\nISBN: " + this.isbn
			+ "\nStatus" + this.getStatus();
	}
}
