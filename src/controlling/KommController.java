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

	/* Ausbaustufe I */
	public boolean projektCreate(User u, String bezeichnung) throws RemoteException;
	public boolean projectFinalize() throws RemoteException;
	public boolean taskCreate() throws RemoteException;
	public boolean taskEdit() throws RemoteException;
	public boolean taskMoveFwd() throws RemoteException;
	public boolean taskMoveRwd() throws RemoteException;

	/* Ausbaustufe II */
	public boolean addUser() throws RemoteException;

	/* Ausbaustufe IV */
	public boolean addStatus() throws RemoteException;
	public boolean changeStatusName() throws RemoteException;
}
