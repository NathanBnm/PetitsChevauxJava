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
		/*
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
		*/
		
		System.out.println("");

		
		//Affichage des écuries
		for(int i = 0; i < 4; i++) {
			System.out.println("Ecurie (" + Couleur.values()[i] + ") " + ecuries.get(i).toString());
		}
				
		//Affichage des écuries jaune et bleue et des cases intermédiaires
		System.out.println(" __________        __________");
		System.out.print("|          |" + chemin.get(12).getChevaux().toString() + chemin.get(13).getChevaux().toString() + chemin.get(14).getChevaux().toString() + "|          |");
		System.out.println("");
		System.out.print("|          |" + chemin.get(11).getChevaux().toString() + echelles.get(1).get(0).getChevaux().toString() + chemin.get(15).getChevaux().toString() + "|          |");
		System.out.println("");
		System.out.print("|   JAUNE  |" + chemin.get(10).getChevaux().toString() + echelles.get(1).get(1).getChevaux().toString() + chemin.get(16).getChevaux().toString() + "|   BLEU   |");
		System.out.println("");
		System.out.print("|          |" + chemin.get(9).getChevaux().toString() + echelles.get(1).get(2).getChevaux().toString() + chemin.get(17).getChevaux().toString() + "|          |");
		System.out.println("");
		System.out.print("|__________|" + chemin.get(8).getChevaux().toString() + echelles.get(1).get(3).getChevaux().toString() + chemin.get(18).getChevaux().toString() + "|__________|");
		System.out.println("");
		System.out.print("            " + chemin.get(7).getChevaux().toString() + echelles.get(1).get(4).getChevaux().toString() + chemin.get(19).getChevaux().toString() + "            ");
		System.out.println("");
		
		//Affichage des cases 1 à 7;
		for(int i = 0; i <= 6; i++) { 
			System.out.print(chemin.get(i).getChevaux().toString());
		}
		
		System.out.print(echelles.get(1).get(5).getChevaux().toString());
		
		System.out.print(chemin.get(20).getChevaux().toString());
		
		for(int i = 21; i <= 26; i++) { 
			System.out.print(chemin.get(i).getChevaux().toString());
		}
		
		System.out.println("");
		
		//Affichage de la case 56
		System.out.print(chemin.get(55).getChevaux().toString());
		
		//Affichage de l'échelle jaune
		for(int i = 0; i <= 5; i++) { 
			System.out.print(echelles.get(0).get(i).getChevaux().toString());
		}
		
		System.out.print("()");
		
		//Affichage de l'échelle rouge
		for(int i = 5; i >= 0; i--) { 
			System.out.print(echelles.get(2).get(i).getChevaux().toString());
		}
		
		System.out.print(chemin.get(27).getChevaux().toString());
		
		System.out.println("");
		
		//Affichage des cases 49 à 55
		for(int i = 54; i >= 48; i--) {
			System.out.print(chemin.get(i).getChevaux().toString());
		}
		
		System.out.print(echelles.get(3).get(5).getChevaux().toString());
		
		//Affichage des cases 49 à 55
		for(int i = 34; i >= 28; i--) {
			System.out.print(chemin.get(i).getChevaux().toString());
		}
		
		System.out.println("");
		
		//Affichage des écuries verte et rouge et des cases intermédiaires
		System.out.print(" __________ " + chemin.get(47).getChevaux().toString() + echelles.get(3).get(4).getChevaux().toString() + chemin.get(35).getChevaux().toString() + " __________");
		System.out.println("");
		System.out.print("|          |" + chemin.get(46).getChevaux().toString() + echelles.get(3).get(3).getChevaux().toString() + chemin.get(36).getChevaux().toString() + "|          |");
		System.out.println("");
		System.out.print("|          |" + chemin.get(45).getChevaux().toString() + echelles.get(3).get(2).getChevaux().toString() + chemin.get(37).getChevaux().toString() + "|          |");
		System.out.println("");
		System.out.print("|   VERT   |" + chemin.get(44).getChevaux().toString() + echelles.get(3).get(1).getChevaux().toString() + chemin.get(38).getChevaux().toString() + "|   ROUGE  |");
		System.out.println("");
		System.out.print("|          |" + chemin.get(43).getChevaux().toString() + echelles.get(3).get(0).getChevaux().toString() + chemin.get(39).getChevaux().toString() + "|          |");
		System.out.println("");
		System.out.print("|__________|" + chemin.get(42).getChevaux().toString() + chemin.get(41).getChevaux().toString() + chemin.get(40).getChevaux().toString() + "|__________|");
		System.out.println("");
		
		System.out.println("");
	}

	/**
	 * deplacerPion permet de déplacer un pion sur sa nouvelle position et de l'enlever de son ancienne,
	 * elle utilise aussi la fonction peutPasser
	 * @param Pion 
	 * @param Case
	 */
	public void deplacerPion(Pion p, Case c, int de) {
		Case initial = p.getPosition();
		boolean verif = false;
		for(int i = 0; i < de-1; i++) {
			if(c.peutPasser(p)) {
				p.getPosition().getChevaux().remove(p);
				c.ajouterCheval(p);
				p.setPosition(c);
			} else if (verif == false){
				System.out.println("Le cheval ne peut pas passer !");
				verif = true;
			}
		}
			if(c.peutSArreter(p) && verif == false) {
				p.getPosition().getChevaux().remove(p);
				c.ajouterCheval(p);
				p.setPosition(c);
			} else {
				System.out.println("Le cheval ne peut pas s'arrêter !");
				p.getPosition().getChevaux().remove(p);
				initial.ajouterCheval(p);
				p.setPosition(initial);
			}
	}

}