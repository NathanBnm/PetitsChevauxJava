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

		joueurs = new ArrayList<Joueur> ();

		Boolean couleurInvalide = false;
		
		int n = 0;

		do {
			couleurInvalide = false;
			couleur = null;
			coul = "";
			
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
				case "J": couleur = Couleur.JAUNE; break;
				case "B": couleur = Couleur.BLEU; break;
				case "R": couleur = Couleur.ROUGE; break;
				case "V": couleur = Couleur.VERT; break;
				default: 
					couleurInvalide = true;
					System.out.println("Couleur non valide !");
			}

			//On vérifie pour chaque joueur si le nom ou la couleur ont déjà été utilisés
			for(Joueur j : joueurs) {
				if(j.getCouleur() == couleur) {
					couleurInvalide = true;
					System.out.println("Couleur déjà utilisée !");
				}
			}

			if(!couleurInvalide) {
				Joueur joueur = new JoueurHumain(nom, couleur);
				joueurs.add(joueur);
				n++;
			}
		} while(n < nbJoueurs);
		
		//On définit le premier joueur aléatoirement
		Random j = new Random();
		Joueur premierJoueur = joueurs.get(j.nextInt(3));
		setJoueurCourant(premierJoueur);
	}

	/**
	 * @return
	 */
	public void initialiserPlateau() {
		plateau = new Plateau();
		for(CaseEcurie e : plateau.getEcuries()) {
			for(Joueur j : joueurs) {
				if(e.getCouleur() == j.getCouleur()) {
					e.getChevaux().addAll(j.getCaseDepart().getChevaux());
				}
			}
		}
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
		System.out.println("La valeur du dé est " + de);
		//Si le dé est = a 6 on demande au joueur si il veut sortir un pion
		if(de == 6) {
			System.out.print("Voulez vous sortir un pion ? (O/N)");
			rep = sc.next();
			rep = rep.toUpperCase();
			//Si oui alors lequel veut-il déplacer, si non on lui demande quel pion veut-il déplacer.
			if(rep.equals("O")) {
				System.out.println("Vous avez seléctionné Oui");
				System.out.println("Lequel voulez vous sortir de l'écurie ? " + joueurCourant.getChevaux().toString());
			} else {
				System.out.println("Vous avez seléctionné Non");
				System.out.print("Quel pion voulez-vous déplacer ?" + joueurCourant.getChevaux().toString());
				n = sc.next();
				
				Pion pion = null;
				Case courant = null;
				Case suivant = null;
				
				switch(n) {
					case "1":
						for(int d = 0; d < de; d++) {
							pion = joueurCourant.getChevaux().get(0);
							courant = joueurCourant.getChevaux().get(0).getPosition();
							suivant = plateau.getChemins().get(plateau.getChemins().indexOf(courant) + 1);
							if(suivant.peutPasser(pion)) {
								plateau.deplacerPion(pion, suivant);
								pion.setPosition(suivant);
							} else {
								System.out.println("Impossible de passer connard");
							}
						}
					case "2":
						pion = joueurCourant.getChevaux().get(1);
						courant = joueurCourant.getChevaux().get(1).getPosition();
						suivant = plateau.getChemins().get(plateau.getChemins().indexOf(courant) + 1);
						plateau.deplacerPion(pion, suivant);
					case "3":
						pion = joueurCourant.getChevaux().get(2);
						courant = joueurCourant.getChevaux().get(2).getPosition();
						suivant = plateau.getChemins().get(plateau.getChemins().indexOf(courant) + 1);
						plateau.deplacerPion(pion, suivant);
					case "4":
						pion = joueurCourant.getChevaux().get(3);
						courant = joueurCourant.getChevaux().get(3).getPosition();
						suivant = plateau.getChemins().get(plateau.getChemins().indexOf(courant) + 1);
						plateau.deplacerPion(pion, suivant);
					break;
				}
			}
		} else {
			System.out.println("Vous passez votre tour");
		}
		
		System.out.println("Appuyer pour continuer");
		sc.nextLine();
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