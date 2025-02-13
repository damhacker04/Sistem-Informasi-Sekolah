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
import model.teacher.Assignment;
import model.teacher.ClassSchedule;
import model.teacher.Exam;
import model.teacher.ExamResult;
import model.teacher.Teacher;
import model.student.Attendance;
import model.student.AssignmentSubmission;

public class TeacherService {
    private Map<String, Teacher> teacherDatabase = new HashMap<>();
    private Map<String, Assignment> assignmentDatabase = new HashMap<>();
    private Map<String, Attendance> attendanceDatabase = new HashMap<>();
    private Map<String, Exam> examDatabase = new HashMap<>();
    // Simulasi penyimpanan hasil ujian (grade) di dalam map
    private Map<String, ExamResult> examResults = new HashMap<>();
    private Map<String, AssignmentSubmission> assignmentSubmissions = new HashMap<>();

    public Teacher registerTeacher(Teacher teacher) {
        teacher.setTeacherId(UUID.randomUUID().toString());
        teacherDatabase.put(teacher.getTeacherId(), teacher);
        System.out.println("Teacher registered: " + teacher.getTeacherId());
        return teacher;
    }

    public Assignment createAssignment(String title, String description, Date deadline) {
        Assignment assignment = new Assignment();
        assignment.setAssignmentId(UUID.randomUUID().toString());
        assignment.setTitle(title);
        assignment.setDescription(description);
        assignment.setDeadline(deadline);
        assignmentDatabase.put(assignment.getAssignmentId(), assignment);
        System.out.println("Assignment created: " + assignment.getAssignmentId());
        return assignment;
    }

    public Attendance createAttendance(String className, String subject, Date date, List<String> studentIds) {
        Attendance attendance = new Attendance();
        attendance.setAttendanceId(UUID.randomUUID().toString());
        attendance.setClassName(className);
        attendance.setSubject(subject);
        attendance.setDate(date);
        for (String studentId : studentIds) {
            attendance.getStudentStatus().put(studentId, "Not Marked");
        }
        attendanceDatabase.put(attendance.getAttendanceId(), attendance);
        System.out.println("Attendance created: " + attendance.getAttendanceId());
        return attendance;
    }

    public Exam createExam(String title, String subject, Date examDate, int duration) {
        Exam exam = new Exam();
        exam.setExamId(UUID.randomUUID().toString());
        exam.setTitle(title);
        exam.setSubject(subject);
        exam.setExamDate(examDate);
        exam.setDuration(duration);
        examDatabase.put(exam.getExamId(), exam);
        System.out.println("Exam created: " + exam.getExamId());
        return exam;
    }

    /**
     * Simulasi penyimpanan hasil ujian oleh guru ke "GradeDatabase".
     */
    public boolean saveExamResult(String studentId, String examId, double score, boolean showScore) {
        ExamResult result = new ExamResult();
        result.setExamId(examId);
        result.setStudentId(studentId);
        result.setScore(score);
        result.setShowScore(showScore);
        examResults.put(studentId + "_" + examId, result);
        System.out.println("Exam result saved for student " + studentId + " on exam " + examId);
        return true;
    }

    public boolean storeAssignmentSubmission(String studentId, String assignmentId, String fileUpload) {
        AssignmentSubmission submission = new AssignmentSubmission();
        submission.setSubmissionId(UUID.randomUUID().toString());
        submission.setStudentId(studentId);
        submission.setAssignmentId(assignmentId);
        submission.setFileUpload(fileUpload);
        submission.setSubmittedDate(new Date());
        assignmentSubmissions.put(submission.getSubmissionId(), submission);
        System.out.println("Assignment submitted: " + submission.getSubmissionId());
        return true;
    }
}

