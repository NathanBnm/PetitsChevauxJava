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
public abstract class Case {

	private ArrayList<Pion> chevaux;
	/**
	 * Default constructor
	 */
	public Case() {
		chevaux = new ArrayList<Pion>();
	}

	/**
	 * @return
	 */
	public ArrayList<Pion> getChevaux() {
		return chevaux;
	}

	/**
	 * @param Pion 
	 * @return
	 */
	public void ajouterCheval(Pion p) {
		chevaux.add(p);
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