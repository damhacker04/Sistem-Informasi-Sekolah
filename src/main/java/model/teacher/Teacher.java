/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.teacher;

/**
 *
 * @author Adam R
 */
import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private String teacherId;
    private String name;
    private String subjectExpertise;
    private List<ClassSchedule> schedule = new ArrayList<>();

    // Getters & Setters
    public String getTeacherId() { return teacherId; }
    public void setTeacherId(String teacherId) { this.teacherId = teacherId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSubjectExpertise() { return subjectExpertise; }
    public void setSubjectExpertise(String subjectExpertise) { this.subjectExpertise = subjectExpertise; }
    public List<ClassSchedule> getSchedule() { return schedule; }
    public void setSchedule(List<ClassSchedule> schedule) { this.schedule = schedule; }
}

