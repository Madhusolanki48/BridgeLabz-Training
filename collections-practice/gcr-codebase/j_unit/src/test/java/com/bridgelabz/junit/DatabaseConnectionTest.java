package com.bridgelabz.junit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class DatabaseConnectionTest {
	DatabaseConnection db;
	@BeforeEach
	void setUp() {
		db=new DatabaseConnection();
		db.connect();  //before each test
	}
	@AfterEach
	void tearDown() {
		db.disconnect();  //after each test
	}
	@Test
	void testConnectionEstablished() {
		assertTrue(db.connected);   //connected

	}
	@Test
	void testConnectionClosed() {
        db.disconnect();
        assertFalse(db.connected); //disconnected
    }
}
