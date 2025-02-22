package ui;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import model.Book;
import model.Library;

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
					System.out.println("\nYou selected 2!");
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
					System.out.println("\nYou selected 6!");
					break;
				case 7: 
					System.out.println("\nYou selected 7!");
					break;
				case 8:
					System.out.println("\nYou selected 8!");
					break;
				case 9:
					System.out.println("\nYou selected 9!");
					break;
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
				System.out.println("\nBook borrowed\n");
			} else {
				System.out.println("\nError borrowing book.\n");
			}
		}
	}
	
	private static void addBookHandler(Library librandall, Scanner scanner) {
		System.out.println("\nPlease enter the Book Title: \n" );
		String title = scanner.nextLine();
		
		System.out.println("\nPlease enter the Book Author: \n" );
		String author = scanner.nextLine();
		
		System.out.println("\nPlease enter the Book ISBN: \n" );
		String isbn = scanner.nextLine();
		
		Book book = new Book(title, author, isbn, false);
		
		librandall.addBook(book);
	}
	
	private static void listAvailableBooksHandler(Library librandall, Scanner scanner) {
		System.out.println("\nThese are the books available: \n");
		librandall.listAvailableBooks();
	}

}
