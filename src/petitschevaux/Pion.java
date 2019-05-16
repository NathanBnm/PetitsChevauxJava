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
 * 
 */
public class Pion {

	/**
	 * 
	 */
	private String id;
	private Couleur couleurPion;

	/**
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
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String toString() {
		return "Id : " + this.id + ", Couleur : " + this.getCouleur().getSymbole();
	}
}