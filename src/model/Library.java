package model;

import java.util.ArrayList;

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
}
