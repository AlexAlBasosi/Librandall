package model;

import java.util.ArrayList;

public class Library {
	
	private ArrayList<Book> books;
	private ArrayList<Member> members;
	
	public void addBook(Book book) {
		try {
			books.add(book);
			System.out.println("Book added to the library!");
		} catch(Error e) {
			System.out.println("There was an error adding book to the library. Error details: " + e);
		}
	}
	
	public void listBooks() {
		books.forEach(book -> {
			System.out.println(book.toString());
		});
	}
}
