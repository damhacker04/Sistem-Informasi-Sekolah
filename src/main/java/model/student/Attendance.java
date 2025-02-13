/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.student;

/**
 *
 * @author Adam R
 */
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Attendance {
    private String attendanceId;
    private String className;
    private String subject;
    private Date date;
    // Map: studentId -> status (misalnya "Hadir", "Izin", "Sakit", atau "Not Marked")
    private Map<String, String> studentStatus = new HashMap<>();

    // Getters & Setters
    public String getAttendanceId() { return attendanceId; }
    public void setAttendanceId(String attendanceId) { this.attendanceId = attendanceId; }
    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    public Map<String, String> getStudentStatus() { return studentStatus; }
    public void setStudentStatus(Map<String, String> studentStatus) { this.studentStatus = studentStatus; }
}

