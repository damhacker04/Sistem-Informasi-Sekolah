package testservice;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adam R
 */


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.FinanceService;
import model.finance.Payment;
import model.finance.Salary;

public class FinanceServiceTest {
    
    private FinanceService financeService;
    
    @BeforeEach
    public void setup() {
        financeService = new FinanceService();
    }
    
    @Test
    public void testProcessPayment() {
        Payment payment = financeService.processPayment("S789", 1500000, "Bank Transfer");
        assertNotNull(payment.getPaymentId(), "Payment ID harus tidak null");
        assertEquals("PAID", payment.getStatus(), "Status pembayaran harus 'PAID'");
        assertEquals(1500000, payment.getAmount(), "Jumlah pembayaran harus sesuai");
    }
    
    @Test
    public void testManageSalary() {
        Salary salary = financeService.manageSalary("T001", 5000000, 1000000);
        assertNotNull(salary.getSalaryId(), "Salary ID harus tidak null");
        assertEquals("T001", salary.getTeacherId(), "Teacher ID harus sesuai");
        assertEquals(5000000, salary.getBasicSalary(), "Basic salary harus sesuai");
        assertEquals(1000000, salary.getBonus(), "Bonus harus sesuai");
        assertEquals("PAID", salary.getStatus(), "Status gaji harus 'PAID'");
    }
}

