package testCom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import model.Projekt;
import model.User;

public class Server extends UnicastRemoteObject implements KommController{

	protected Server() throws RemoteException{};

	static ComProtocol protocol;
	public static int clientcounter = 0;

	private static void handleConnection(Socket client) throws IOException {
		InputStream in = client.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder builder = new StringBuilder();
		PrintWriter out = new PrintWriter(client.getOutputStream(), true);

		String string1 = reader.readLine();
		String output = "Fail";

		protocol = new ComProtocol();

		if (string1.contains("changeAttrByID")) {
			Request req = protocol.valChangeAttrByID(string1);
			output = "ID: " + req.id + "\tAttr: " + req.attr + "\tValue: " + req.value + "\tTimestamp: "
					+ req.timeStamp;
		}
		out.println(output);
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

	@Override
	public boolean projektCreate(User u, String bezeichnung){
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean projectFinalize(){
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean taskCreate(String name, String Kommentar, User u){
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean taskEdit(){
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean taskMoveFwd(int id){
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean taskMoveRwd(int id){
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUser(User u, Projekt p){
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addStatus(){
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeStatusName(){
		// TODO Auto-generated method stub
		return false;
	}
}
