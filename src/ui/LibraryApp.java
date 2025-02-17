package ui;

import model.Book;
import model.Member;

public class LibraryApp {

	public static void main(String[] args) {
		Book book = new Book("1984", "George Orwell", "123", false);
		System.out.println(book.toString());
		
		Member member = new Member(14, "Stephen King", "somephonenumber");
		
		Book borrowedBook = new Book("The Green Mile", "Stephen King", "456", true, member);
		
		System.out.println(borrowedBook.toString());
	}
}
