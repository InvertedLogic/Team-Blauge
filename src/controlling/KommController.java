package controlling;

/**
 * 
 * @author Lars Raschke
 * 
 */

public interface KommController {
	
	/* Ausbaustufe I */
	public void projektCreate();
	public void projectFinalize();
	public void taskCreate();
	public void taskEdit();
	public void taskMoveFwd();
	public void taskMoveRwd();
	
	/* Ausbaustufe II */
	public void addUser();	
	
	/* Ausbaustufe IV */
	public void addStatus();
	public void changeStatusName();
}
