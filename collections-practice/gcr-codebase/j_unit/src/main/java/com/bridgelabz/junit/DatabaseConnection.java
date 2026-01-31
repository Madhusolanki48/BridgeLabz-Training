package com.bridgelabz.junit;

public class DatabaseConnection {
	boolean connected=false;
	void connect() {
		connected=true;
		System.out.println("Database connected!");
	}
	void disconnect() {
		connected=false;
		System.out.println("Database disconnected!");
	}

}