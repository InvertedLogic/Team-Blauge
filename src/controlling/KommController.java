package controlling;

import java.rmi.Remote;
import java.rmi.RemoteException;

import model.*;

/**
 * 
 * @author Lars Raschke
 * 
 */

public interface KommController extends Remote {
	
	String DEFAULT_RMI_OBJECT_NAME = "Blauge";

	/* Ausbaustufe I */
	public boolean projektCreate(User u, String bezeichnung) throws RemoteException;
	public boolean projectFinalize() throws RemoteException;
	public boolean taskCreate(String name, String kommentar) throws RemoteException;
	public boolean taskEdit() throws RemoteException;
	public boolean taskMoveFwd(int id) throws RemoteException;
	public boolean taskMoveRwd(int id) throws RemoteException;

	/* Ausbaustufe II */
	public boolean addUser(User u, Projekt p) throws RemoteException;

	/* Ausbaustufe IV */
	public boolean addStatus(String name) throws RemoteException;
	public boolean changeStatusName(String name, int id) throws RemoteException;
}
