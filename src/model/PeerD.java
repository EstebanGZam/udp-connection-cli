package model;

import util.UDPConnection;

import java.io.IOException;

public class PeerD {

	public static void main(String[] args) throws IOException {
		UDPConnection connection = UDPConnection.getInstance();
		connection.setPorts(5001, 5000);
		connection.start();
	}

}
