package model;

import util.UDPConnection;

import java.io.IOException;

public class PeerB {

	public static void main(String[] args) throws IOException {
		UDPConnection connection = UDPConnection.getInstance();
		connection.setPorts("127.0.0.1", 5001, 5000);
		connection.start();
	}

}
