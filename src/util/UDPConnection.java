package util;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPConnection {
	private DatagramSocket socket;
	private static UDPConnection instance;
	private int destinationPort;

	Scanner scanner = new Scanner(System.in);

	public static UDPConnection getInstance() {
		if (instance == null) {
			instance = new UDPConnection();
		}
		return instance;
	}

	public void setPorts(int connectionPort, int destinationPort) throws SocketException {
		this.socket = new DatagramSocket(connectionPort);
		this.destinationPort = destinationPort;
	}

	public synchronized void start() {
		try {
			boolean exit = false;
			Receiver receiver = Receiver.getInstance();
			receiver.setPort(this.socket);

			receiver.start();

			while (!exit) {
				Sender sender = new Sender(this.socket, this.destinationPort);
				String message = scanner.nextLine();
				exit = message.equalsIgnoreCase("exit");
				if (exit) {
					receiver.setStop(true);
					receiver.getSocket().close();
				} else {
					sender.sendMessage(message);
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
