package com.clinic;

import com.clinic.config.HikariConnectionPool;
import com.clinic.ui.ConsoleMenu;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Health Clinic Management System...");
        try {
            new ConsoleMenu().start();
        } finally {
            HikariConnectionPool.closePool();
        }
    }
}
