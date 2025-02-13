/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.teacher;

/**
 *
 * @author Adam R
 */
import java.util.Date;

public class Exam {
    private String examId;
    private String title;
    private String subject;
    private Date examDate;
    private int duration; // dalam menit

    // Getters & Setters
    public String getExamId() { return examId; }
    public void setExamId(String examId) { this.examId = examId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public Date getExamDate() { return examDate; }
    public void setExamDate(Date examDate) { this.examDate = examDate; }
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
}

