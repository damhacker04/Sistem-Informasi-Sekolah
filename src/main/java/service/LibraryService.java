/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author Adam R
 */
import java.util.*;
import java.util.concurrent.TimeUnit;
import model.library.Book;

public class LibraryService {
    // Simulasi database perpustakaan dengan Map
    public Map<String, Book> libraryDatabase = new HashMap<>();

    public Book borrowBook(String studentId, String bookId) {
        Book book = libraryDatabase.get(bookId);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            libraryDatabase.put(bookId, book);
            System.out.println("Student " + studentId + " borrowed book: " + book.getTitle());
            return book;
        }
        System.out.println("Book not available for borrowing.");
        return null;
    }

    public boolean returnBook(String studentId, String bookId) {
        Book book = libraryDatabase.get(bookId);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            libraryDatabase.put(bookId, book);
            System.out.println("Student " + studentId + " returned book: " + book.getTitle());
            return true;
        }
        System.out.println("Book return failed.");
        return false;
    }

    public double generateInvoiceDenda(Date dueDate, Date returnDate) {
        long diffInMillis = returnDate.getTime() - dueDate.getTime();
        long daysLate = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
        double denda = daysLate * 5000; // Contoh: 5000 per hari keterlambatan
        System.out.println("Generated denda: " + denda);
        return denda;
    }
}

