/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.student;

/**
 *
 * @author Adam R
 */
import java.util.ArrayList;
import java.util.List;

public class ReportCard {
    private Student student;
    private List<Grade> grades;

    public ReportCard() {
        this.grades = new ArrayList<>();
    }

    public ReportCard(Student student, List<Grade> grades) {
        this.student = student;
        this.grades = grades;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Report Card for ").append(student.getName())
          .append(" (ID: ").append(student.getStudentId()).append(")\n");
        sb.append("Class: ").append(student.getStudentClass()).append("\n");
        sb.append("Grades:\n");
        for (Grade grade : grades) {
            sb.append("Subject: ").append(grade.getSubjectId())
              .append(" | Knowledge: ").append(grade.getKnowledgeScore())
              .append(" | Skill: ").append(grade.getSkillScore()).append("\n");
        }
        return sb.toString();
    }
}

