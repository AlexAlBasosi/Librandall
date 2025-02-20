package ui;

import java.util.ArrayList;

import model.Book;
import model.Library;
import model.Member;

public class LibraryApp {

	public static void main(String[] args) {
		
		// Book with no members
		
		Book book = new Book("1984", "George Orwell", "123", false);
		System.out.println(book.toString());
		
		// Book with members
		
		Member member = new Member(14, "Stephen King", "somephonenumber");
		
		Book borrowedBook = new Book("The Green Mile", "Stephen King", "456", true, member);
		
		System.out.println(borrowedBook.toString());
		
		// Using Library
		
		// Adding existing books to library
		
		ArrayList<Book> books = new ArrayList<Book>();
		
		books.add(book);
		books.add(borrowedBook);
		
		// Adding existing members to library
		
		ArrayList<Member> members = new ArrayList<Member>();
		
		members.add(member);
		
		// Creating Library
		
		Library librandall = new Library(books, members);
		
		System.out.println("Welcome to Librandall!\n");
		
		System.out.println("Your books: \n");
		librandall.listBooks();
		
		System.out.println("Your members: \n");
		
		librandall.listMembers();
		
		// Adding Book
		
		System.out.println("Adding book...\n");
		librandall.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "19", false));
		
		System.out.println("Your books: \n");
		librandall.listBooks();
		
		// Adding Member
		
		System.out.println("Adding member...");
		librandall.addMember(new Member(9626, "Alex Randall", "11 Borland Close"));
		
		System.out.println("Your members: \n");
		librandall.listMembers();
	}
}
