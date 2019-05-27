/*
 *                                                            
 *   _____     _   _ _          _____ _                       
 *  |  _  |___| |_|_| |_ ___   |     | |_ ___ _ _ ___ _ _ _ _ 
 *  |   __| -_|  _| |  _|_ -|  |   --|   | -_| | | .'| | |_'_|
 *  |__|  |___|_| |_|_| |___|  |_____|_|_|___|\_/|__,|___|_,_|
 *                                                            
 *                                               Version 1.0.0
 *  
 *                 Nathan Bonnemains <21801526@etu.unicaen.fr>
 *                 Gérémy L'Ecuyer <21802888@etu.unicaen.fr>
 *  
 */

package petitschevaux;

/**
 * Classe principale (PetitsChevaux)
 * @author Nathan Bonnemains & Gérémy L'Ecuyer
 * @version 1.0
 */
public class PetitsChevaux {

	/**
	 * Constructeur par défaut
	 */
	public PetitsChevaux() {
	}

	/**
	 * @param String[] 
	 * @throws CouleurInvalideException 
	 */
	public static void main(String[] args) {
		System.out.println("   _____     _   _ _          _____ _                       ");
		System.out.println("  |  _  |___| |_|_| |_ ___   |     | |_ ___ _ _ ___ _ _ _ _ ");
		System.out.println("  |   __| -_|  _| |  _|_ -|  |   --|   | -_| | | .'| | |_'_|");
		System.out.println("  |__|  |___|_| |_|_| |___|  |_____|_|_|___|\\_/|__,|___|_,_|");
		System.out.println("");                                                           
		System.out.println("                                               Version 1.0.0");
		System.out.println("");  
		System.out.println("                 Nathan Bonnemains <21801526@etu.unicaen.fr>");
		System.out.println("                 Gérémy L'Ecuyer <21802888@etu.unicaen.fr>");
		System.out.println("");
		System.out.println("Bienvenue dans le jeu des petits chevaux !");
		System.out.println("Commençons par ajouter des joueurs :");
		System.out.println("");

		int maxtour = 0;
		Partie partie = new Partie();
		
		partie.initialiserJoueurs(4);
		partie.initialiserPlateau();
		partie.getPlateau().afficher();
		do {
			partie.jouerUnTour(maxtour);
			partie.getPlateau().afficher();
			maxtour++;
		} while(!partie.estPartieTerminee());
	}

}