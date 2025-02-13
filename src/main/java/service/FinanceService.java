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
import model.finance.Payment;
import model.finance.Salary;

public class FinanceService {
    private Map<String, Payment> paymentDatabase = new HashMap<>();
    private Map<String, Salary> salaryDatabase = new HashMap<>();

    public Payment processPayment(String studentId, double amount, String paymentMethod) {
        Payment payment = new Payment();
        payment.setPaymentId(UUID.randomUUID().toString());
        payment.setStudentId(studentId);
        payment.setStudentName("StudentName"); // Biasanya diambil dari StudentDatabase
        payment.setAmount(amount);
        payment.setPaymentMethod(paymentMethod);
        payment.setStatus("PAID");
        paymentDatabase.put(payment.getPaymentId(), payment);
        System.out.println("Payment processed: " + payment.getPaymentId());
        return payment;
    }

    public Salary manageSalary(String teacherId, double basicSalary, double bonus) {
        Salary salary = new Salary();
        salary.setSalaryId(UUID.randomUUID().toString());
        salary.setTeacherId(teacherId);
        salary.setBasicSalary(basicSalary);
        salary.setBonus(bonus);
        salary.setPaymentDate(new Date());
        salary.setStatus("PAID");
        salaryDatabase.put(salary.getSalaryId(), salary);
        System.out.println("Salary managed for teacher: " + teacherId);
        return salary;
    }
}

