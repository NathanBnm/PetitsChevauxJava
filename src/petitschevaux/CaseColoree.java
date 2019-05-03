package petitschevaux;

/**
 * 
 */
public abstract class CaseColoree extends Case {

	private Couleur couleur;

	/**
	 * @param Couleur
	 */
	public CaseColoree(Couleur couleur) {
		this.couleur = couleur;
	}
	
	public Couleur getCouleur() {
		return this.couleur;
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