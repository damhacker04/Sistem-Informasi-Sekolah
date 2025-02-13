/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.teacher;

/**
 *
 * @author Adam R
 */
public class ExamResult {
    private String examId;
    private String studentId;
    private double score;
    private boolean showScore;

    public String getExamId() {
        return examId;
    }
    public void setExamId(String examId) {
        this.examId = examId;
    }
    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }
    public boolean isShowScore() {
        return showScore;
    }
    public void setShowScore(boolean showScore) {
        this.showScore = showScore;
    }
    @Override
    public String toString() {
        if (showScore) {
            return "ExamResult: examId=" + examId + ", studentId=" + studentId + ", score=" + score;
        } else {
            return "ExamResult: examId=" + examId + ", studentId=" + studentId + ", score not displayed";
        }
    }
}

