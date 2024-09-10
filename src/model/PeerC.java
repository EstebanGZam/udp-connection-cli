package model;

import util.UDPConnection;

import java.io.IOException;

public class PeerC {
	public static void main(String[] args) throws IOException {
		UDPConnection connection = UDPConnection.getInstance();
		connection.setPorts(5000, 5001);
		connection.start();
	}
}
