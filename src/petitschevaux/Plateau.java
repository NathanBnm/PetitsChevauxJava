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
		ArrayList<Couleur> couleur = new ArrayList<Couleur>();
		couleur.add(Couleur.BLEU); 
		couleur.add(Couleur.JAUNE); 
		couleur.add(Couleur.ROUGE); 
		couleur.add(Couleur.VERT);
		for(int i=0 ; i<4 ; i++) {
			for(int j=0 ; j<6 ; j++) {
				//echelles.get(i).add(new CaseEchelle(couleur.get(i)));
			}
			ecuries.add(new CaseEcurie(couleur.get(i)));
		}
	}

	/**
	 * @return
	 */
	public ArrayList<CaseEcurie> getEcuries() {
		return ecuries;
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
		return chemin;
	}

	/**
	 * @return
	 */
	public void afficher() {
		System.out.println("Ecuries :");
		for(int i = 0; i < 4; i++) {
			System.out.println("Ecurie " + (i + 1) + " " + ecuries.get(i).getChevaux().toString());
		}
		System.out.println();
		System.out.println("Chemin : " + chemin.toString());
		System.out.println();
		System.out.println("Echelles : " + echelles.toString());
		System.out.println();
	}

	/**
	 * @param Pion 
	 * @param Case 
	 * @return
	 */
	public void deplacerPion(Pion p, Case c) {
		if(c.peutPasser(p)) {
			c.ajouterCheval(p);
		} else {
			System.out.println("Le cheval ne peut pas passer !");
		}
	}

}