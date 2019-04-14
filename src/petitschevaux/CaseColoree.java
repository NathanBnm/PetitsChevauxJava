package petitschevaux;

/**
 * 
 */
public abstract class CaseColoree extends Case {

	/**
	 * @param Couleur
	 */
	public CaseColoree(Couleur couleur) {
		// TODO implement here
	}
	
	public Couleur getCouleur() {
		return null;
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