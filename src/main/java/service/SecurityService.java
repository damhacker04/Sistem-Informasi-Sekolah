/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author Adam R
 */


import java.util.ArrayList;
import java.util.List;

public class SecurityService {

    // Simulasi penyimpanan data log insiden dan rekaman pengunjung
    private List<String> incidentLogs = new ArrayList<>();
    private List<String> visitorRecords = new ArrayList<>();

    /**
     * Memverifikasi identitas menggunakan data dokumen.
     */
    public boolean verifyIdentity(String documentData) {
        if (documentData != null && !documentData.isEmpty()) {
            System.out.println("Identity verified.");
            return true;
        }
        System.out.println("Identity verification failed.");
        return false;
    }

    /**
     * Memantau pintu masuk dan mengembalikan daftar rekaman pengunjung.
     */
    public List<String> monitorEntrances() {
        System.out.println("Monitoring entrances. Current visitor records: " + visitorRecords);
        return visitorRecords;
    }

    /**
     * Mencatat insiden yang terjadi.
     */
    public void recordIncident(String incident) {
        incidentLogs.add(incident);
        System.out.println("Incident recorded: " + incident);
    }

    // Metode tambahan untuk keperluan testing atau tampilan data:

    public List<String> getIncidentLogs() {
        return incidentLogs;
    }

    public List<String> getVisitorRecords() {
        return visitorRecords;
    }

    public void addVisitor(String visitorInfo) {
        visitorRecords.add(visitorInfo);
        System.out.println("Visitor added: " + visitorInfo);
    }
}


