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
	boolean projektCreate(User u, String bezeichnung) throws RemoteException;
	boolean projectFinalize() throws RemoteException;
	boolean taskCreate(String name, String kommentar) throws RemoteException;
	boolean taskEdit() throws RemoteException;
	boolean taskMoveFwd(int id) throws RemoteException;
	boolean taskMoveRwd(int id) throws RemoteException;

	/* Ausbaustufe II */
	boolean addUser(User u, Projekt p) throws RemoteException;

	/* Ausbaustufe IV */
	boolean addStatus(String name) throws RemoteException;
	boolean changeStatusName(String name, int id) throws RemoteException;
}
