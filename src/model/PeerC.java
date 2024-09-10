package model;

import util.UDPConnection;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class PeerC {
	private static final Scanner scanner = new Scanner(System.in);  // Create a Scanner object

	public static void main(String[] args) throws IOException {
		UDPConnection connection = UDPConnection.getInstance();
		connection.setPort(5000);
		connection.start();
		while (true) {
			connection.sendDatagram(scanner.nextLine(), "127.0.0.1", 5001);
		}
	}
}
