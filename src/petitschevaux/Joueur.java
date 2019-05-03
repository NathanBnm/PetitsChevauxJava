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

import java.util.ArrayList;

/**
 * 
 */
public abstract class Joueur {
	
	/**
	 * 
	 */
	private String nom;

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
		// TODO implement here
		return null;
	}

	/**
	 * @param Case 
	 * @return
	 */
	public void setCaseDepart(Case c) {
		// TODO implement here
		return;
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
		// TODO implement here
		return null;
	}

	/**
	 * @param int 
	 * @param Plateau 
	 * @return
	 */
	public abstract Pion choisirPion(int n, Plateau p);

}