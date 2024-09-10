package util;

import java.io.IOException;
import java.net.*;

public class UDPConnection extends Thread {
	private DatagramSocket socket;
	private static UDPConnection instance;

	private UDPConnection() {
	}

	public static UDPConnection getInstance() {
		if (instance == null) {
			instance = new UDPConnection();
		}
		return instance;
	}

	public void setPort(int port) throws SocketException {
		this.socket = new DatagramSocket(port);
	}

	@Override
	public void run() {
		while (true) {
			try {
				DatagramPacket packet = new DatagramPacket(new byte[24], 24);
				System.out.println("Waiting ....");

				this.socket.receive(packet);

				String msj = new String(packet.getData()).trim();
				System.out.println(msj);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void sendDatagram(String msj, String destinationIp, int destinationPort) throws IOException {
		InetAddress ipAddress = InetAddress.getByName(destinationIp);
		DatagramPacket packet = new DatagramPacket(msj.getBytes(), msj.length(), ipAddress, destinationPort);

		socket.send(packet);
	}

}
