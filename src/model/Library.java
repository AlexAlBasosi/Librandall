package model;

import java.util.ArrayList;
import java.util.Objects;

public class Library {
	
	private ArrayList<Book> books;
	private ArrayList<Member> members;
	
	public Library() {
		this.books = new ArrayList<Book>();
		this.members = new ArrayList<Member>();
	}
	
	public Library(ArrayList<Book> books, ArrayList<Member> members) {
		this.books = books;
		this.members = members;
	}
	
	public void listBooks() {
		this.books.forEach(book -> {
			System.out.println(book.toString());
		});
	}
	
	public void listMembers() {
		this.members.forEach(member -> {
			System.out.println(member.toString());
		});
	}
	
	public void addBook(Book book) {
		try {
			books.add(book);
			System.out.println("Book added to Librandall!\n");
		} catch(Error e) {
			System.out.println("There was an error adding book to the library. Error details: " + e + "\n");
		}
	}
	
	public void addMember(Member member) {
		try {
			members.add(member);
			System.out.println("Member added!\n");
		} catch(Error e) {
			System.out.println("There was an error adding member. Error details: " + e + "\n");
		}
	}
	
	public Book findBook(String isbn) {
		for (Book book : books) {
			if (book.getIsbn().equals(isbn)) {
				return book;
			}
		}
		
		return null;
	}
	
	public Member findMember(int memberId) {
		for (Member member : members) {
			if (member.getMemberId() == memberId) {
				return member;
			}
		}
		
		return null;
	}
	
	public boolean borrowBook(String isbn, int memberId) {
						
		Book currentBook = null;
		
		// If book doesn't exist, return false.
		
		for (Book book : books) {
			if (Objects.equals(findBook(isbn), null)) {
				System.out.println("Error borrowing book: Book not found.\n");
				
				return false;
			} else { 
				currentBook = book;
			}
		}
		
		// If member doesn't exist, return false.
		// Otherwise, set isBorrowed in book to true and setMember to member,
		// and return true.
		
		for (Member member : members) {
			if (this.findMember(memberId) == null) {
				System.out.println("Error borrowing book: Member not found.\n");
				
				return false;
			} else if (member.getMemberId() == memberId) {
				
				currentBook.setIsBorrowed(true);
				currentBook.setMember(member);
				
				System.out.println("Borrowing process complete. Enjoy your book!\n");
				
				return true;
			}
		}
		
		// Otherwise, return false.
		
		return false;
	}
	
	public boolean returnBook(String isbn) {
		
		// If book doesn't exist, return false.
		
		for (Book book : books) {
			if (this.findBook(isbn) == null) {
				System.out.println("Error returning book: Book not found.");
				
				return false;
			} else if (book.getIsbn().equals(isbn)) {
				
				book.setIsBorrowed(false);
				book.setMember(null);
				
				System.out.println("Returning process complete. I hope you enjoyed the book!");
				
				return true;
			} 
		}
		
		return false;
	}
	
	public void listAvailableBooks() {
		// Print books that have isBorrowed set to false.
		
		for (Book book : books) {
			if(!book.getIsBorrowed()) {
				System.out.println(book);
			}
		}
	}
	
	public void listBorrowedBooks() {
		// Print books that have isBorrowed set to true.
		
		for(Book book : books) {
			if(book.getIsBorrowed()) {
				System.out.println(book);
			}
		}
	}
}
