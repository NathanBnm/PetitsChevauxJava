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
 * Classe Case (abstraite)
 */
public abstract class Case {

	private ArrayList<Pion> chevaux;
	/**
	 * Constructeur par défaut
	 */
	public Case() {
		chevaux = new ArrayList<Pion>();
	}

	/**
	 * getChevaux permet d'avoir la liste de chevaux sur la case
	 * @return ArrayList de pion
	 */
	public ArrayList<Pion> getChevaux() {
		return chevaux;
	}

	/**
	 * ajouterCheval permet d'ajouter un cheval à la liste chevaux
	 * @param Pion 
	 */
	public void ajouterCheval(Pion p) {
		chevaux.add(p);
	}
	
	public String toString() {
		return chevaux.toString();
	}

	/**
	 * peutPasser permet de vérifier si un obstacle ce trouve sur la route
	 * , ici peutPasser est abstrait, cela permet de l'utiliser sur Case qui est
	 * une classe abstraite qui étend CaseChemins et CaseColoree
	 */
	public abstract Boolean peutPasser(Pion p);

	/**
	 * peutSArreter permet de vérifier si un obstacle ce trouve sur la case d'arriver
	 * , ici peutSArreter est abstrait, cela permet de l'utiliser sur Case qui est
	 * une classe abstraite qui étend CaseChemins et CaseColoree
	 */
	public abstract Boolean peutSArreter(Pion p);

}