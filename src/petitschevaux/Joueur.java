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
	
	private String nom;
	private Case CaseDepart;
	private Couleur couleur;
	
	/**
	 * Constructeur de joueur par défaut
	 * @param String Nom du joueur
	 * @param Couleur Couleur du joueur
	 */
	public Joueur(String nom, Couleur couleur) {
		this.nom = nom;
		this.couleur = couleur;
	}

	/**
	 * Renvoie la case de départ
	 * @return Case de départ
	 */
	public Case getCaseDepart() {
		return this.CaseDepart;
	}

	/**
	 * Définit la case de départ du joueur passée en paramètre
	 * @param Case Une case
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
	 * Renvoie le nom du joueur
	 * @return Nom du joueur
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Définit le nom du joueur passé en paramètre
	 * @param String Nom du joueur
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Renvoie la couleur du joueur
	 * @return Couleur du joueur
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