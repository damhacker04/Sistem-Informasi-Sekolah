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
import service.StudentService;
import model.student.Student;
import model.student.Attendance;
import model.student.ReportCard;
import model.student.Grade;
import model.teacher.ExamResult; // ExamResult berada di package teacher
import java.util.*;


public class StudentServiceTest {
    
    private StudentService studentService;
    
    @BeforeEach
    public void setup() {
        studentService = new StudentService();
    }
    
    @Test
    public void testRegisterStudent() {
        Student student = new Student();
        student.setName("Alice");
        student.setStudentClass("10A");
        Student registeredStudent = studentService.registerStudent(student);
        
        assertNotNull(registeredStudent.getStudentId(), "Student ID harus tidak null");
        assertEquals("Alice", registeredStudent.getName(), "Nama harus sesuai");
        assertEquals("10A", registeredStudent.getStudentClass(), "Kelas harus sesuai");
    }
    
    @Test
    public void testCheckIn() {
        Student student = new Student();
        student.setName("Bob");
        student.setStudentClass("10B");
        Student registeredStudent = studentService.registerStudent(student);
        
        boolean checkInResult = studentService.checkIn(registeredStudent.getStudentId(), "Matematika");
        assertTrue(checkInResult, "Check-in harus berhasil");
        
        List<Attendance> attendanceRecords = registeredStudent.getAttendanceRecords();
        assertFalse(attendanceRecords.isEmpty(), "Attendance records tidak boleh kosong");
        Attendance attendance = attendanceRecords.get(0);
        assertEquals("Hadir", attendance.getStudentStatus().get(registeredStudent.getStudentId()), "Status absensi harus 'Hadir'");
    }
    
    @Test
    public void testPrintReportCard() {
        Student student = new Student();
        student.setName("Charlie");
        student.setStudentClass("10C");
        Student registeredStudent = studentService.registerStudent(student);
        
        // Tambahkan grade ke data siswa
        Grade grade = new Grade();
        grade.setStudentId(registeredStudent.getStudentId());
        grade.setSubjectId("Matematika");
        grade.setKnowledgeScore(90);
        grade.setSkillScore(85);
        grade.setSemester("Genap");
        grade.setDateUpdated(new Date());
        registeredStudent.getGrades().add(grade);
        
        ReportCard reportCard = studentService.printRaportCard(registeredStudent.getStudentId());
        assertNotNull(reportCard, "ReportCard tidak boleh null");
        assertEquals(1, reportCard.getGrades().size(), "ReportCard harus memiliki 1 grade");
    }
    
    @Test
    public void testDoExam() {
        Student student = new Student();
        student.setName("David");
        student.setStudentClass("10D");
        Student registeredStudent = studentService.registerStudent(student);
        
        // Simulasi jawaban: 5 soal semua dijawab "true"
        Map<String, String> answers = new HashMap<>();
        answers.put("q1", "true");
        answers.put("q2", "true");
        answers.put("q3", "true");
        answers.put("q4", "true");
        answers.put("q5", "true");
        
        boolean showScore = true;
        ExamResult examResult = studentService.doExam(registeredStudent.getStudentId(), "exam001", answers, showScore);
        
        assertNotNull(examResult, "ExamResult tidak boleh null");
        assertTrue(examResult.isShowScore(), "Seharusnya skor ditampilkan");
        assertEquals(100.0, examResult.getScore(), "Skor ujian harus 100");
    }
}

