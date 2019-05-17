/*
 *                                                            
 *   _____     _   _ _          _____ _                       
 *  |  _  |___| |_|_| |_ ___   |     | |_ ___ _ _ ___ _ _ _ _ 
 *  |   __| -_|  _| |  _|_ -|  |   --|   | -_| | | .'| | |_'_|
 *  |__|  |___|_| |_|_| |___|  |_____|_|_|___|\_/|__,|___|_,_|
 *                                                            
 *                                               Version 0.0.1
 *  
 *                 Nathan Bonnemains <21801526@etu.unicaen.fr>
 *                 Gérémy L'Ecuyer <21802888@etu.unicaen.fr>
 *  
 */

package petitschevaux;

/**
 * Classe Pion
 */
public class Pion {

	/**
	 * 
	 */
	private String id;
	private Couleur couleurPion;
	private Case position = null;

	/**
	 * Constructeur par défaut
	 * @param String 
	 * @param Couleur
	 */
	public Pion(String id, Couleur couleur) {
		this.couleurPion = couleur;
		this.id = id;
	}

	/**
	 * Renvoie la couleur du pion
	 * @return Couleur du pion
	 */
	public Couleur getCouleur() {
		return this.couleurPion;
	}
	
	/**
	 * Renvoie l'Id du pion
	 * @return Id du pion
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Défini l'Id du pion
	 * @return Id du pion
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Renvoie la position du pion
	 * @return position du pion
	 */
	public Case getPosition() {
		return this.position;
	}

	/**
	 * Défini la position du pion
	 * @return Couleur du pion
	 */
	public void setPosition(Case position) {
		this.position = position;
	}
	
	public String toString() {
		return this.id + " (" + this.getCouleur().getSymbole() + ")";
	}
}