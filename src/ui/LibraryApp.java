package ui;

import model.Book;

public class LibraryApp {

	public static void main(String[] args) {
		Book book = new Book("1984", "George Orwell", "123", false);
		System.out.println(book.toString());
	}

}
