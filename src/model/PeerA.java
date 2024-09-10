package model;

import util.UDPConnection;

import java.io.IOException;

public class PeerA {
	public static void main(String[] args) throws IOException {
		UDPConnection connection = UDPConnection.getInstance();
		connection.setPorts("127.0.0.1", 5000, 5001);
		connection.start();
	}
}
