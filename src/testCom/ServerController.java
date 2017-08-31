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

public class ServerController extends UnicastRemoteObject implements KommController{

	protected ServerController() throws RemoteException{};
	
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
