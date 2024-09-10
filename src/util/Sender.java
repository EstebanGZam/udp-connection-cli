package util;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender {
	private final DatagramSocket socket;
	private final int destinationPort;

	public Sender(DatagramSocket socket, int destinationPort) {
		this.socket = socket;
		this.destinationPort = destinationPort;
	}

	public void sendMessage(String message) throws IOException {
		sendDatagram(message, this.destinationPort);
	}

	private void sendDatagram(String message, int destinationPort) throws IOException {
		InetAddress ipAddress = InetAddress.getByName("127.0.0.1");
		DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), ipAddress, destinationPort);

		socket.send(packet);
	}

}

