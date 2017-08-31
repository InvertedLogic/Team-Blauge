package testCom;

import java.rmi.Remote;
import java.rmi.RemoteException;

import model.*;

/**
 * 
 * @author Lars Raschke
 * 
 */

public interface KommController extends Remote {

	/* Ausbaustufe I */
	public boolean projektCreate(User u, String bezeichnung) throws RemoteException;
	public boolean projectFinalize() throws RemoteException;
	public boolean taskCreate(String name, String Kommentar, User u) throws RemoteException;
	public boolean taskEdit() throws RemoteException;
	public boolean taskMoveFwd(int id) throws RemoteException;
	public boolean taskMoveRwd(int id) throws RemoteException;

	/* Ausbaustufe II */
	public boolean addUser(User u, Projekt p) throws RemoteException;

	/* Ausbaustufe IV */
	public boolean addStatus() throws RemoteException;
	public boolean changeStatusName() throws RemoteException;
}
