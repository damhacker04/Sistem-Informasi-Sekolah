package testservice;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adam R
 */


import model.student.Attendance;
import model.teacher.Exam;
import model.teacher.Assignment;
import model.teacher.Teacher;
import service.TeacherService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

public class TeacherServiceTest {
    
    private TeacherService teacherService;
    
    @BeforeEach
    public void setup() {
        teacherService = new TeacherService();
    }
    
    @Test
    public void testRegisterTeacher() {
        Teacher teacher = new Teacher();
        teacher.setName("Mr. Smith");
        teacher.setSubjectExpertise("Matematika");
        Teacher registeredTeacher = teacherService.registerTeacher(teacher);
        
        assertNotNull(registeredTeacher.getTeacherId(), "Teacher ID harus tidak null");
        assertEquals("Mr. Smith", registeredTeacher.getName(), "Nama guru harus sesuai");
        assertEquals("Matematika", registeredTeacher.getSubjectExpertise(), "Bidang keahlian harus sesuai");
    }
    
    @Test
    public void testCreateAssignment() {
        Assignment assignment = teacherService.createAssignment("Tugas Matematika", "Kerjakan soal 1-10", new Date());
        assertNotNull(assignment.getAssignmentId(), "Assignment ID harus tidak null");
        assertEquals("Tugas Matematika", assignment.getTitle(), "Judul tugas harus sesuai");
    }
    
    @Test
    public void testCreateAttendance() {
        List<String> studentIds = new ArrayList<>();
        studentIds.add("S123"); // Simulasi ID siswa
        Attendance attendance = teacherService.createAttendance("10A", "Bahasa", new Date(), studentIds);
        assertNotNull(attendance.getAttendanceId(), "Attendance ID harus tidak null");
        assertEquals("Not Marked", attendance.getStudentStatus().get("S123"), "Status awal harus 'Not Marked'");
    }
    
    @Test
    public void testCreateExam() {
        Exam exam = teacherService.createExam("Ujian Bahasa", "Bahasa", new Date(), 60);
        assertNotNull(exam.getExamId(), "Exam ID harus tidak null");
        assertEquals("Ujian Bahasa", exam.getTitle(), "Judul ujian harus sesuai");
        assertEquals(60, exam.getDuration(), "Durasi ujian harus sesuai");
    }
    
    @Test
    public void testStoreAssignmentSubmission() {
        boolean submissionStatus = teacherService.storeAssignmentSubmission("S456", "A789", "file_path/tugas.pdf");
        assertTrue(submissionStatus, "Submission tugas harus berhasil");
    }
    
    @Test
    public void testSaveExamResult() {
        boolean resultSaved = teacherService.saveExamResult("S123", "E123", 95.0, true);
        assertTrue(resultSaved, "Hasil ujian harus tersimpan");
    }
}

