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
 * Classe Plateau
 */
public class Plateau {

	/**
	 * 
	 */
	private ArrayList<CaseEcurie> ecuries;
	private ArrayList<CaseChemin> chemin;
	private ArrayList<ArrayList<CaseEchelle>> echelles;

	/**
	 * Default constructor
	 */
	public Plateau() {
		ecuries = new ArrayList<CaseEcurie>();
		chemin = new ArrayList<CaseChemin>();
		echelles = new ArrayList<ArrayList<CaseEchelle>>();
		for(int i=0 ; i<56 ; i++) {
			chemin.add(new CaseChemin());
		}
		for(int i=0 ; i<4 ; i++) {
			echelles.add(new ArrayList<CaseEchelle>());
			for(int j=0 ; j<6 ; j++) {
				echelles.get(i).add(new CaseEchelle(Couleur.values()[i]));
			}
			ecuries.add(new CaseEcurie(Couleur.values()[i]));
		}
	}

	/**
	 * @return ecuries
	 */
	public ArrayList<CaseEcurie> getEcuries() {
		return ecuries;
	}

	/**
	 * @return echelles
	 */
	public ArrayList<ArrayList<CaseEchelle>> getEchelles() {
		return echelles;
	}

	/**
	 * @return chemin
	 */
	public ArrayList<CaseChemin> getChemins() {
		return chemin;
	}

	/**
	 * Afficher permet d'afficher le contenue des ecuries, du chemin et des echelles
	 */
	public void afficher() {
		System.out.println("Ecuries :");
		for(int i = 0; i < 4; i++) {
			System.out.println("Ecurie (" + Couleur.values()[i] + ") " + ecuries.get(i).toString());
		}
		System.out.println();
		System.out.println("Chemin : " + chemin.toString());
		System.out.println();

		for(int i = 0; i < 4; i++) {
			System.out.println("Echelle (" + Couleur.values()[i] + ") " + echelles.get(i).toString());
		}
		System.out.println();
	}

	/**
	 * deplacerPion permet de déplacer un pion sur sa nouvelle position et de l'enlever de son ancienne,
	 * elle utilise aussi la fonction peutPasser
	 * @param Pion 
	 * @param Case
	 */
	public void deplacerPion(Pion p, Case c, int de) {
		for(int i = 0; i < de-1; i++) {
			if(c.peutPasser(p)) {
				p.getPosition().getChevaux().remove(p);
				c.ajouterCheval(p);
				p.setPosition(c);
			} else {
				System.out.println("Le cheval ne peut pas passer !");
			}
		}
		if(c.peutSArreter(p)) {
			p.getPosition().getChevaux().remove(p);
			c.ajouterCheval(p);
			p.setPosition(c);
		} else {
			System.out.println("Le cheval ne peut pas s'arrêter !");
		}
	}

}