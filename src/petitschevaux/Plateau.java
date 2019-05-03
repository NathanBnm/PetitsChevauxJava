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
public class Plateau {

	/**
	 * 
	 */
	private ArrayList<ArrayList<CaseEchelle>> echelles;

	/**
	 * Default constructor
	 */
	public Plateau() {
	}

	/**
	 * @return
	 */
	public ArrayList<CaseEcurie> getEcuries() {
		// TODO implement here
		return null;
	}

	/**
	 * @return
	 */
	public ArrayList<ArrayList<CaseEchelle>> getEchelles() {
		return echelles;
	}

	/**
	 * @return
	 */
	public ArrayList<CaseChemin> getChemins() {
		// TODO implement here
		return null;
	}

	/**
	 * @return
	 */
	public void afficher() {
		// TODO implement here
		return;
	}

	/**
	 * @param Pion 
	 * @param Case 
	 * @return
	 */
	public void deplacerPion(Pion p, Case c) {
		// TODO implement here
		return;
	}

}