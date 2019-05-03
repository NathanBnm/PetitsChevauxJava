package petitschevaux;

import java.util.ArrayList;

/**
 * 
 */
public abstract class Joueur {
	
	private String nom;
	private Case CaseDepart;
	private Couleur couleur;
	
	/**
	 * @param String 
	 * @param Couleur
	 */
	public Joueur(String nom, Couleur couleur) {
		this.nom = nom;
	}

	/**
	 * @return
	 */
	public Case getCaseDepart() {
		return this.CaseDepart;
	}

	/**
	 * @param Case 
	 * @return
	 */
	public void setCaseDepart(Case c) {
		c = this.CaseDepart;
	}

	/**
	 * @return
	 */
	public ArrayList<Pion> getChevaux() {
		// TODO implement here
		return null;
	}

	/**
	 * @return
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * @param String 
	 * @return
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return
	 */
	public Couleur getCouleur() {
		return this.couleur;
	}

	/**
	 * @param int 
	 * @param Plateau 
	 * @return
	 */
	public abstract Pion choisirPion(int n, Plateau p);

}