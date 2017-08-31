package testCom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static int clientcounter = 0;

	private static void handleConnection(Socket client) throws IOException {
		InputStream in = client.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder builder = new StringBuilder();
		PrintWriter out = new PrintWriter(client.getOutputStream(), true);
	}


	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(3141);
		while (true) {
			Socket client = null;

			try {
				client = server.accept();
				handleConnection(client);
				clientcounter++;
				System.out.println(clientcounter);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (client != null)
					try {
						client.close();
					} catch (IOException e) {
					}
			}
		}
	}


}
