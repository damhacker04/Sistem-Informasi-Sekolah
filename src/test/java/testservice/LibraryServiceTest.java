package testservice;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adam R
 */


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.LibraryService;
import model.library.Book;
import java.util.Calendar;
import java.util.Date;

public class LibraryServiceTest {
    
    private LibraryService libraryService;
    
    @BeforeEach
    public void setup() {
        libraryService = new LibraryService();
    }
    
    @Test
    public void testBorrowAndReturnBook() {
        Book book = new Book();
        book.setBookId("book001");
        book.setTitle("Belajar Matematika");
        book.setAuthor("John Doe");
        book.setAvailable(true);
        libraryService.libraryDatabase.put(book.getBookId(), book);
        
        Book borrowedBook = libraryService.borrowBook("S101", "book001");
        assertNotNull(borrowedBook, "Buku yang dipinjam tidak boleh null");
        assertFalse(borrowedBook.isAvailable(), "Buku harus berstatus tidak tersedia");
        
        boolean returnStatus = libraryService.returnBook("S101", "book001");
        assertTrue(returnStatus, "Pengembalian buku harus berhasil");
        Book returnedBook = libraryService.libraryDatabase.get("book001");
        assertTrue(returnedBook.isAvailable(), "Buku harus berstatus tersedia setelah dikembalikan");
    }
    
    @Test
    public void testGenerateInvoiceDenda() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -3); // due date 3 hari yang lalu
        Date dueDate = cal.getTime();
        Date returnDate = new Date();
        double denda = libraryService.generateInvoiceDenda(dueDate, returnDate);
        assertTrue(denda > 0, "Denda harus lebih besar dari 0 untuk keterlambatan");
    }
}

