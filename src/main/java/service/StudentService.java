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

import model.student.Attendance;
import model.student.Grade;
import model.student.ReportCard;
import model.student.Student;
import model.teacher.ExamResult;
        
        

public class StudentService {
    // Simulasi database siswa menggunakan Map
    private Map<String, Student> studentDatabase = new HashMap<>();

    public Student registerStudent(Student student) {
        student.setStudentId(UUID.randomUUID().toString());
        studentDatabase.put(student.getStudentId(), student);
        System.out.println("Student registered: " + student.getStudentId());
        return student;
    }

    public boolean checkIn(String studentId, String subject) {
        Student student = studentDatabase.get(studentId);
        if (student != null) {
            Attendance attendance = new Attendance();
            attendance.setAttendanceId(UUID.randomUUID().toString());
            attendance.setClassName(student.getStudentClass());
            attendance.setSubject(subject);
            attendance.setDate(new Date());
            // Tandai status siswa sebagai "Hadir"
            attendance.getStudentStatus().put(studentId, "Hadir");
            student.getAttendanceRecords().add(attendance);
            System.out.println("Student " + studentId + " checked in for subject " + subject);
            return true;
        }
        return false;
    }

    public ReportCard printRaportCard(String studentId) {
        Student student = studentDatabase.get(studentId);
        if (student == null) {
            System.out.println("Student not found for id: " + studentId);
            return null;
        }
        // Ambil data nilai akademik dari properti student
        List<Grade> grades = student.getGrades();
        ReportCard reportCard = new ReportCard(student, grades);
        System.out.println("Report card generated for student " + studentId);
        return reportCard;
    }

    /**
     * Simulasi pengerjaan ujian oleh siswa.
     * @param studentId ID siswa
     * @param examId ID ujian
     * @param answers Map jawaban (misalnya, key=questionId, value=answer)
     * @param showScore Apakah guru memilih untuk menampilkan skor akhir
     * @return ExamResult yang berisi nilai ujian dan opsi tampilan skor
     */
    public ExamResult doExam(String studentId, String examId, Map<String, String> answers, boolean showScore) {
        double score = 0.0;
        int total = answers.size();
        int correct = 0;
        // Simulasi: misalnya jawaban "true" dianggap benar
        for (String answer : answers.values()) {
            if ("true".equalsIgnoreCase(answer)) {
                correct++;
            }
        }
        if (total > 0) {
            score = ((double) correct / total) * 100.0;
        }
        ExamResult result = new ExamResult();
        result.setExamId(examId);
        result.setStudentId(studentId);
        result.setScore(score);
        result.setShowScore(showScore);
        System.out.println("Exam result computed for student " + studentId + ": " + score);
        return result;
    }
}

