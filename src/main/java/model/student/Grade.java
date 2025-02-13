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

public class Grade {
    private String studentId;
    private String subjectId;
    private double knowledgeScore;
    private double skillScore;
    private String semester;
    private Date dateUpdated;

    // Getters & Setters
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public String getSubjectId() { return subjectId; }
    public void setSubjectId(String subjectId) { this.subjectId = subjectId; }
    public double getKnowledgeScore() { return knowledgeScore; }
    public void setKnowledgeScore(double knowledgeScore) { this.knowledgeScore = knowledgeScore; }
    public double getSkillScore() { return skillScore; }
    public void setSkillScore(double skillScore) { this.skillScore = skillScore; }
    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }
    public Date getDateUpdated() { return dateUpdated; }
    public void setDateUpdated(Date dateUpdated) { this.dateUpdated = dateUpdated; }
}

