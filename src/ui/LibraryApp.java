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
		
		// Finding Book
		
		System.out.println("Adding book...");
		books.add(new Book("A Hitchiker's Guide to the Galaxy", "Douglas Adams", "42", false));
		
		System.out.println("Finding books...");
		System.out.println(librandall.findBook("123"));
		System.out.println(librandall.findBook("456"));
		System.out.println(librandall.findBook("19"));
		System.out.println(librandall.findBook("42"));
		
		// Finding Member
		
		System.out.println("Adding member...");
		members.add(new Member(9458, "Shannon Randall", "11 Borland Close"));
		
		System.out.println(librandall.findMember(9458));
		
		// Borrowing Book
		
		System.out.println("\n\n***Alex Randall is a big of a space geek. He wants to read Hitchiker's Guide to the Galaxy. Let's simulate this transaction...***\n\n");
		
		System.out.println("Book to be borrowed: " + librandall.findBook("42"));
		
		System.out.println("Borrowing book...\n");
		librandall.borrowBook("42", 9626);
		
		System.out.println("The book now: " + librandall.findBook("42"));
		
		System.out.println("Testing case where book doesn't exist...\n");
		librandall.borrowBook("potato", 9626);
		
		System.out.println("Testing case where member doesn't exist...\n");
		librandall.borrowBook("19", 396);
		
		// Returning Book
		
		System.out.println("\n\n **Now, Alex Randall wants to return the book after completing it. Let's simulate this transaction...***\n\n");
		
		System.out.println("Book to be borrowed: " + librandall.findBook("42"));
		
		System.out.println("Returning book...\n");
		librandall.returnBook("42");
		
		System.out.println("The book now: " + librandall.findBook("42"));
		
		System.out.println("Testing case where book doesn't exist...\n");
		librandall.returnBook("49");
		
		// Listing Available Books
		
		System.out.println("\n\nAvailable Books: \n");
		librandall.listAvailableBooks();
		
		// Listing Borrowed Books
		
		System.out.println("\n\nBorrowed Books: \n");
		librandall.listBorrowedBooks();
	}
}
