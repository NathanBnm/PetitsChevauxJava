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
import java.util.Random;
import java.util.Scanner;

/**
 * 
 */
public class Partie {
	/**
	 * 
	 */
	private ArrayList<Joueur> joueurs;
	private Joueur joueurCourant;
	private Random de;
	private Plateau plateau;

	/**
	 * Default constructor
	 */
	public Partie() {
		de = new Random();
	}

	/**
	 * @param int 
	 */
	public void initialiserJoueurs(int nbJoueurs) {

		Scanner sc = new Scanner(System.in);

		String nom = "";
		String coul = "";
		Couleur couleur = null;

		ArrayList<Joueur> joueurs = new ArrayList<Joueur> ();

		Boolean couleurUtilisee = false;

		Case depart = null;
		int n = 0;

		do {			
			//Saisie du nom des joueurs
			System.out.println();
			System.out.print("Nom du Joueur " + (n + 1) + " : ");
			nom = sc.next();

			//Choix de la couleur des joueurs
			System.out.print("Couleur (J, B, V, R) : ");
			coul = sc.next();
			coul = coul.toUpperCase();

			//On détecte la couleur en fonction de la saisie
			switch(coul) {
			case "J": couleur = Couleur.JAUNE; depart = plateau.getChemins().get(1); break;
			case "B": couleur = Couleur.BLEU; depart = plateau.getChemins().get(15); break;
			case "R": couleur = Couleur.ROUGE; depart = plateau.getChemins().get(29); break;
			case "V": couleur = Couleur.VERT; depart = plateau.getChemins().get(43); break;
			}

			//On vérifie pour chaque joueur si le nom ou la couleur ont déjà été utilisés
			for(Joueur j : joueurs) {
				couleurUtilisee = false;
				//Pour la couleur
				if(j.getCouleur() == couleur) {
					System.out.println("Couleur déjà utilisée ou non valide !");
					couleurUtilisee = true;
				}
			}

			if(!couleurUtilisee) {
				Joueur joueur = new JoueurHumain(nom, couleur);
				joueurs.add(joueur);

				joueur.setCaseDepart(depart);
				n++;
			}
		} while(n < nbJoueurs);
		
		Random j = new Random();
		Joueur premierJoueur = joueurs.get(j.nextInt(3));
		setJoueurCourant(premierJoueur);
	}

	/**
	 * @return
	 */
	public void initialiserPlateau() {
		plateau = new Plateau();
	}

	/**
	 * La méthode nextInt() de la classe Random permet de générer un entier aléatoire 
	 * compris entre 0 inclus et l'entier passé en paramètre exclus. 
	 * En ajoutant 1 et en enlevant le minimum dans l'entier en paramètre, 
	 * puis en ajoutant le nombre minimum au résultat, on arrive à obtenir un 
	 * nombre aléatoire compris entre les deux valeurs
	 * @return valeur du dé
	 */
	private int lancerDe() {
		return de.nextInt(6)+1;
	}

	/**
	 * @return
	 */
	public void jouerUnTour() {
		Scanner sc = new Scanner(System.in);
		String rep = "";
		String n;
		int de = lancerDe();
		System.out.println("Au tour de " + joueurCourant.getNom() + " (" + joueurCourant.getCouleur() + ")");
		if(de == 6) {
			System.out.print("Voulez vous sortir un pion ? (O/N)");
			rep = sc.next();
			rep.toUpperCase();
			if(rep.equals("O")) {
				System.out.println("Vous avez seléctionné Oui");
			} else {
				System.out.println("Vous avez seléctionné Non");
				System.out.print("Quel pion voulez-vous déplacer ? (1, 2, 3, 4)");
				n = sc.next();
				/*
				switch(n) {
					case "1": plateau.deplacerPion(joueurCourant.getChevaux().get(0), plateau.getChemins()  );
					break;
				}
				*/
			}
		} else {
			System.out.println("Vous passez votre tour");
		}	
	}

	/**
	 * @return
	 */
	public boolean estPartieTerminee() {
		// TODO implement here
		return false;
	}
	/**
	 * @return
	 */
	public Joueur getJoueurCourant() {
		return this.joueurCourant;
	}

	/**
	 * @param Joueur 
	 * @return
	 */
	public void setJoueurCourant(Joueur j) {
		this.joueurCourant = j;
	}

	/**
	 * @return
	 */
	public Plateau getPlateau() {
		return this.plateau;
	}

	/**
	 * @return
	 */
	public ArrayList<Joueur> getJoueurs() {
		return this.joueurs;
	}

	/**
	 * @param Case 
	 * @return
	 */
	private void mangerLesPions(Case c) {
		// TODO implement here
		return;
	}

}