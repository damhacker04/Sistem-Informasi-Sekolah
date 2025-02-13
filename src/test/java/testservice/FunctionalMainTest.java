package testservice;














/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adam R
 */


import model.library.Book;
import model.student.Attendance;
import model.student.ReportCard;
import model.student.Student;
import model.teacher.Exam;
import model.teacher.ExamResult;
import model.teacher.Assignment;
import model.teacher.Teacher;
import service.TeacherService;
import service.StudentService;
import service.LibraryService;
import service.SecurityService;
import service.FinanceService;
import model.finance.Salary;
import model.finance.Payment;

import java.util.*;

public class FunctionalMainTest {
    public static void main(String[] args) {
        // Inisialisasi Service
        StudentService studentService = new StudentService();
        TeacherService teacherService = new TeacherService();
        FinanceService financeService = new FinanceService();
        LibraryService libraryService = new LibraryService();
        SecurityService securityService = new SecurityService();

        // **Pengujian Student Service**
        System.out.println("\n===== PENGUJIAN STUDENT SERVICE =====");
        Student student = new Student();
        student.setName("Alice");
        student.setStudentClass("10A");
        Student registeredStudent = studentService.registerStudent(student);
        System.out.println(" Siswa terdaftar dengan ID: " + registeredStudent.getStudentId());

        boolean checkInStatus = studentService.checkIn(registeredStudent.getStudentId(), "Matematika");
        System.out.println(" Status Absen: " + (checkInStatus ? "Berhasil" : "Gagal"));

        Map<String, String> answers = new HashMap<>();
        answers.put("q1", "true");
        answers.put("q2", "true");
        answers.put("q3", "false");
        answers.put("q4", "true");
        answers.put("q5", "false");

        boolean showScore = true;
        ExamResult examResult = studentService.doExam(registeredStudent.getStudentId(), "exam001", answers, showScore);
        System.out.println(" Hasil Ujian: " + (showScore ? examResult.getScore() : "Nilai disembunyikan"));

        ReportCard reportCard = studentService.printRaportCard(registeredStudent.getStudentId());
        System.out.println(" Raport: " + reportCard);

        // **Pengujian Teacher Service**
        System.out.println("\n===== PENGUJIAN TEACHER SERVICE =====");
        Teacher teacher = new Teacher();
        teacher.setName("Mr. Smith");
        teacher.setSubjectExpertise("Matematika");
        Teacher registeredTeacher = teacherService.registerTeacher(teacher);
        System.out.println(" Guru terdaftar dengan ID: " + registeredTeacher.getTeacherId());

        Assignment assignment = teacherService.createAssignment("Tugas Matematika", "Kerjakan soal 1-10", new Date());
        System.out.println(" Tugas dibuat dengan ID: " + assignment.getAssignmentId());

        Attendance attendance = teacherService.createAttendance("10A", "Matematika", new Date(), List.of(registeredStudent.getStudentId()));
        System.out.println(" Absen dibuat untuk kelas " + attendance.getClassName());

        Exam exam = teacherService.createExam("Ujian Matematika", "Matematika", new Date(), 90);
        System.out.println(" Ujian dibuat dengan ID: " + exam.getExamId());

        boolean resultSaved = teacherService.saveExamResult(registeredStudent.getStudentId(), exam.getExamId(), examResult.getScore(), showScore);
        System.out.println(" Hasil Ujian Tersimpan: " + (resultSaved ? "Sukses" : "Gagal"));

        // **Pengujian Finance Service**
        System.out.println("\n===== PENGUJIAN FINANCE SERVICE =====");
        Payment payment = financeService.processPayment(registeredStudent.getStudentId(), 1500000, "Bank Transfer");
        System.out.println(" Pembayaran SPP dengan ID: " + payment.getPaymentId());

        Salary salary = financeService.manageSalary(registeredTeacher.getTeacherId(), 5000000, 1000000);
        System.out.println(" Gaji Guru: " + salary.getBasicSalary() + " + Bonus: " + salary.getBonus());

        // **Pengujian Library Service**
        System.out.println("\n===== PENGUJIAN LIBRARY SERVICE =====");
        Book book = new Book();
        book.setBookId("book123");
        book.setTitle("Belajar Matematika");
        book.setAuthor("John Doe");
        book.setAvailable(true);
        libraryService.libraryDatabase.put(book.getBookId(), book);

        Book borrowedBook = libraryService.borrowBook(registeredStudent.getStudentId(), "book123");
        System.out.println(" Buku dipinjam: " + borrowedBook.getTitle());

        boolean returnStatus = libraryService.returnBook(registeredStudent.getStudentId(), "book123");
        System.out.println(" Status Pengembalian Buku: " + (returnStatus ? "Berhasil" : "Gagal"));

        // **Pengujian Security Service**
        System.out.println("\n===== PENGUJIAN SECURITY SERVICE =====");
        boolean verified = securityService.verifyIdentity("Valid Document");
        System.out.println(" Verifikasi Identitas: " + (verified ? "Sukses" : "Gagal"));

        securityService.addVisitor("John Doe - 2025-02-11 10:30 AM");
        securityService.addVisitor("Jane Doe - 2025-02-11 11:00 AM");

        List<String> visitorRecords = securityService.monitorEntrances();
        System.out.println(" Pengunjung yang masuk: " + visitorRecords);

        securityService.recordIncident("Unauthorized access detected at Gate A");
        List<String> incidents = securityService.getIncidentLogs();
        System.out.println(" Insiden Keamanan: " + incidents);
    }
}

