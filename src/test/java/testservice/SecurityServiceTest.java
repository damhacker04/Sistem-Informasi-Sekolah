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
import service.SecurityService;
import java.util.List;

public class SecurityServiceTest {
    
    private SecurityService securityService;

    @BeforeEach
    public void setup() {
        securityService = new SecurityService();
    }

    @Test
    public void testVerifyIdentity_Success() {
        boolean verified = securityService.verifyIdentity("Valid Document Data");
        assertTrue(verified, "Verifikasi identitas harus berhasil jika dokumen valid.");
    }

    @Test
    public void testVerifyIdentity_Failure() {
        boolean notVerified = securityService.verifyIdentity("");
        assertFalse(notVerified, "Verifikasi identitas harus gagal jika dokumen kosong.");
    }

    @Test
    public void testMonitorEntrances_Empty() {
        List<String> visitors = securityService.monitorEntrances();
        assertTrue(visitors.isEmpty(), "Daftar pengunjung harus kosong di awal.");
    }

    @Test
    public void testMonitorEntrances_WithVisitors() {
        securityService.addVisitor("John Doe - 2025-02-11 10:30 AM");
        securityService.addVisitor("Jane Doe - 2025-02-11 11:00 AM");

        List<String> visitors = securityService.monitorEntrances();
        assertEquals(2, visitors.size(), "Daftar pengunjung harus memiliki dua entri.");
        assertTrue(visitors.contains("John Doe - 2025-02-11 10:30 AM"), "Harus berisi data pengunjung pertama.");
        assertTrue(visitors.contains("Jane Doe - 2025-02-11 11:00 AM"), "Harus berisi data pengunjung kedua.");
    }

    @Test
    public void testRecordIncident() {
        securityService.recordIncident("Unauthorized access detected at Gate A");
        securityService.recordIncident("Fire alarm triggered at Science Lab");

        List<String> incidents = securityService.getIncidentLogs();
        assertEquals(2, incidents.size(), "Log insiden harus memiliki dua entri.");
        assertEquals("Unauthorized access detected at Gate A", incidents.get(0), "Insiden pertama harus sesuai.");
        assertEquals("Fire alarm triggered at Science Lab", incidents.get(1), "Insiden kedua harus sesuai.");
    }
}
