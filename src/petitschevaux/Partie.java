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
	
	private ArrayList<Joueur> joueurs;
	private Joueur joueurCourant;
	/**
	 * 
	 */
	private Random de;

	/**
	 * Default constructor
	 */
	public Partie() {
	}

	/**
	 * @param int 
	 */
	public void initialiserJoueurs(int nbJoueurs) {
		
		Scanner sc = new Scanner(System.in);
		
		String nom = "";
		String coul = "";
		Couleur couleur = null;
		
		ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur> ();
		
		Boolean nomUtilise = false;
		Boolean couleurUtilisee = false;
		
		for(int i = 0; i < nbJoueurs; i++) {
			//Saisie du nom des joueurs
			System.out.println();
			System.out.print("Nom du Joueur " + (i + 1) + " : ");
			nom = sc.next();
			//Choix de la couleur des joueurs
			System.out.print("Couleur (J, B, V, R) : ");
			coul = sc.next();
			
			//On détecte la couleur en fonction de la saisie
			switch(coul) {
				case "J": couleur = Couleur.JAUNE; break;
				case "B": couleur = Couleur.BLEU; break;
				case "V": couleur = Couleur.VERT; break;
				case "R": couleur = Couleur.ROUGE; break;
			}

			//On vérifie pour chaque joueur si le nom ou la couleur ont déjà été utilisés
			for(Joueur j : listeJoueurs) {
				nomUtilise = false;
				couleurUtilisee = false;
				//Pour le nom
				if(j.getNom().equals(nom)) {
					System.out.println("Nom déjà utilisé !");
					nomUtilise = true;
				}
				//Pour la couleur
				if(j.getCouleur() == couleur) {
					System.out.println("Couleur déjà utilisée ou non valide !");
					couleurUtilisee = true;
				}
			}
			
			if(nomUtilise == true || couleurUtilisee == true) {
				//Si un nom ou une couleur a déjà été utilisée on relance le tour de boucle
				i = i - 1;
			} else {
				//Sinon on créée un nouveau joueur puis on l'ajoute à la liste
				Joueur joueur = new JoueurHumain(nom, couleur);
				listeJoueurs.add(joueur);
			}
		}
	}

	/**
	 * @return
	 */
	public void initialiserPlateau() {
		// TODO implement here
		return;
	}

	/**
	 * @return
	 */
	private int lancerDe() {
		int num = (int) ((Math.random()*5)+1);
		return num;
	}

	/**
	 * @return
	 */
	public void jouerUnTour() {
		// TODO implement here
		return;
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
		// TODO implement here
		return null;
	}

	/**
	 * @param Joueur 
	 * @return
	 */
	public void setJoueurCourant(Joueur j) {
		// TODO implement here
		return;
	}

	/**
	 * @return
	 */
	public Plateau getPlateau() {
		// TODO implement here
		return null;
	}

	/**
	 * @return
	 */
	public ArrayList<Joueur> getJoueurs() {
		// TODO implement here
		return null;
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