package petitschevaux;

import java.util.ArrayList;

/**
 * 
 */
public abstract class Case {

	/**
	 * Default constructor
	 */
	public Case() {
	}

	/**
	 * @return
	 */
	public ArrayList<Pion> getChevaux() {
		// TODO implement here
		return null;
	}

	/**
	 * @param Pion 
	 * @return
	 */
	public void ajouterCheval(Pion p) {
		// TODO implement here
		return;
	}

	/**
	 * @return
	 */
	public abstract Boolean peutPasser(Pion p);

	/**
	 * @return
	 */
	public abstract Boolean peutSArreter(Pion p);

}