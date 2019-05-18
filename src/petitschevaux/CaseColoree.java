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
 * Classe CaseColoree (hérite de Case)
 */
public abstract class CaseColoree extends Case {

	private Couleur couleur;

	/**
	 * Constructeur par défaut
	 * @param Couleur
	 */
	public CaseColoree(Couleur couleur) {
		this.couleur = couleur;
	}
	
	public Couleur getCouleur() {
		return this.couleur;
	}

	/**
	 * peutPasser permet de vérifier si un obstacle ce trouve sur la route
	 * , ici peutPasser est abstrait, cela permet de l'utiliser sur CaseColoree qui est
	 * une classe abstraite qui étant CaseEchelle et CaseEcurie
	 */
	public abstract Boolean peutPasser(Pion p);

	/**
	 * peutSArreter permet de vérifier si un obstacle ce trouve sur la case d'arriver
	 * , ici peutSArreter est abstrait, cela permet de l'utiliser sur CaseColoree qui est
	 * une classe abstraite qui étant CaseEchelle et CaseEcurie
	 */
	public abstract Boolean peutSArreter(Pion p);

}