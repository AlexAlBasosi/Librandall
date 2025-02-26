package ui;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import model.Book;
import model.Library;
import model.Member;

public class Librandall {

	public static void main(String[] args) {
		
		Library librandall = new Library();
		
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		
		while(choice != 9) {
			System.out.println("\n\n*** Welcome to Librandall. ***\n\n");
			
			System.out.println("Please select from the following options: \n");
			System.out.println("1. Borrow book.");
			System.out.println("2. Return book.");
			System.out.println("3. List available books.");
			System.out.println("4. List borrowed books.");
			System.out.println("5. Add book.");
			System.out.println("6. Add member.");
			System.out.println("7. Find book.");
			System.out.println("8. Find member.");
			System.out.println("9. Exit program.\n\n");
			
			System.out.println("Enter your choice (1-9): \n");
			
			try {
				choice = scanner.nextInt();
				
				scanner.nextLine();
									
				switch(choice) {
				case 1:
					borrowBookHandler(librandall, scanner);
										
					break;
				case 2:
					returnBookHandler(librandall, scanner);
					
					break;
				case 3:
					listAvailableBooksHandler(librandall, scanner);
					
					break;
				case 4:
					System.out.println("\nYou selected 4!");
					break;
				case 5:
					addBookHandler(librandall, scanner);
					
					break;
				case 6: 
					addMemberHandler(librandall, scanner);
					
					break;
				case 7: 
					findBookHandler(librandall, scanner);
					
					break;
				case 8:
					findMemberHandler(librandall, scanner);
					
					break;
				case 9:
					System.out.println("\n\n*** Thank you for using Librandall. I bid you a pleasant day! ***\n\n");
					return;
				}
					
				
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter the format specified.");
				scanner.next();
				
			} catch (NoSuchElementException | IllegalStateException e) {
				System.out.println("Error reading input. Please try again.");
			}
		}
		
		scanner.close();
		
	}
	
	private static void borrowBookHandler(Library librandall, Scanner scanner) {
		System.out.println("\nThese are the books available: \n");
		librandall.listAvailableBooks();
		
		System.out.println("\n\n1. Proceed to borrow book.");
		System.out.println("2. Return to previous menu.\n");
		
		int choiceCase1 = scanner.nextInt();
		
		scanner.nextLine();
		
		if (choiceCase1 == 1) {
			System.out.println("\nThese are the books available: \n");
			librandall.listAvailableBooks();
			
			System.out.println("\nPlease enter the isbn of the book you would like to borrow (string): \n");
			
			String isbn = scanner.nextLine();
			
			System.out.println("\nPlease enter the ID of the member borrowing the book: \n");
			
			int memberId = scanner.nextInt();
			
			if (librandall.borrowBook(isbn, memberId)) {
				System.out.println("\nBook borrowed!\n");
			} else {
				System.out.println("\nError borrowing book.\n");
			}
		}
	}
	
	private static void addBookHandler(Library librandall, Scanner scanner) {
		System.out.println("\nPlease enter the Book's Title: \n" );
		String title = scanner.nextLine();
		
		System.out.println("\nPlease enter the Book's Author: \n" );
		String author = scanner.nextLine();
		
		System.out.println("\nPlease enter the Book's ISBN: \n" );
		String isbn = scanner.nextLine();
		
		Book book = new Book(title, author, isbn, false);
		
		librandall.addBook(book);
	}
	
	private static void listAvailableBooksHandler(Library librandall, Scanner scanner) {
		System.out.println("\nThese are the books available: \n");
		librandall.listAvailableBooks();
	}
	
	private static void addMemberHandler(Library librandall, Scanner scanner) {
		System.out.println("\nPlease enter the Member ID: \n");
		int memberId = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("\nPlease enter the Member's Name: \n");
		String name = scanner.nextLine();
		
		System.out.println("\nPlease enter the Member's Contact Info: \n");
		String contactInfo = scanner.nextLine();
		
		Member member = new Member(memberId, name, contactInfo);
		
		librandall.addMember(member);
	}
	
	private static void findBookHandler(Library librandall, Scanner scanner) {
		System.out.println("\nPlease enter the Book's ISBN: \n");
		String isbn = scanner.nextLine();
		
		Book book = librandall.findBook(isbn);
		
		if(book != null) {
			System.out.println("\nRequested Book: \n");
			System.out.println(book);
		} else { 
			System.out.println("\nLibrandall has not found your book in its structures.\n");
		}
	}
	
	private static void findMemberHandler(Library librandall, Scanner scanner) {
		System.out.println("\nPlease enter the Member's ID: \n");
		int memberId = scanner.nextInt();
		scanner.nextLine();
		
		Member member = librandall.findMember(memberId);
		
		if(member != null) {
			System.out.println("\nRequested Member: \n");
			System.out.println(member);
		} else {
			System.out.println("\nLibrandall has not found your member in its structures.\n");
		}
	}
	
	private static void returnBookHandler(Library librandall, Scanner scanner) {
		System.out.println("\nPlease enter the Book's ISBN: \n");
		String isbn = scanner.nextLine();
		
		librandall.returnBook(isbn);
	}
}
