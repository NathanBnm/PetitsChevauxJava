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

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Classe Partie
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
	 * Constructeur par défaut
	 */
	public Partie() {
		de = new Random();
	}

	/**
	 * initialiserJoueurs permet d'enregistrer 4 joueurs, ils entrent leurs prénoms et choissisent leurs couleurs
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
	 * Inititaliser plateau permet de construire sa forme à partir des classe de cases : ses 4 écuries,
	 * le chemin (56 cases) et les 4 échelles de 6 cases
	 */
	public void initialiserPlateau() {
		plateau = new Plateau();
		for(CaseEcurie e : plateau.getEcuries()) {
			for(Joueur j : joueurs) {
				if(e.getCouleur() == j.getCouleur()) {
					e.getChevaux().addAll(j.getCaseDepart().getChevaux());
					for(int i = 0; i < 4; i++) {
						e.getChevaux().get(i).setPosition(e);
					}
				}
			}
		}
	}

	/**
	 * La fonction lancerDe permet de retourner un entier entre 1 et 6 a partir du random De
	 * @return valeur du dé
	 */
	private int lancerDe() {
		return de.nextInt(6)+1;
	}

	/**
	 * La fonction jouerUnTour est la fonction permettant de faire intéragire les joueurs avec
	 * le jeu
	 */
	public void jouerUnTour(int maxtour) {

		Scanner sc = new Scanner(System.in);
		String rep = "";
		String n = "";

		Pion pion = null;
		Case courant = null;
		Case suivant = null;
		Case initial = null;

		Boolean idValide = false;

		int de = lancerDe();
		//pour limiter le nombre de fois ou faire 6 fais rejouer le joueur courant (2 fois)

		System.out.println("############");
		System.out.println("");
		System.out.println("Au tour de " + joueurCourant.getNom() + " (" + joueurCourant.getCouleur() + ")");
		System.out.println("La valeur du dé est " + de);
		System.out.println("");

		//Si le dé est = a 6 on demande au joueur si il veut sortir un pion
		if(de == 6) {
			for (int i = 0; i < plateau.getEcuries().size(); i++) {
				//tester si l'écurie qu'on regarde est bien celle du joueur courant
				if (plateau.getEcuries().get(i).getCouleur().equals(joueurCourant.getCouleur())) {
					//tester si l'écurie n'est pas vide, si elle est vide on ne propose pas de sortir un pion
					if (!(plateau.getEcuries().get(i).getChevaux().isEmpty())) {
						do {
							System.out.print("Voulez vous sortir un pion ? (O/N) ");
							rep = sc.next();
							rep = rep.toUpperCase(); 
							//Si oui alors lequel veut-il déplacer
							if(!rep.equals("O") && !rep.equals("N")) {
								System.out.println("Veuillez répondre par oui ou par non !");
							}
						}while(!rep.equals("O") && !rep.equals("N"));
						if(rep.equals("O")) {
							System.out.println("Vous avez seléctionné Oui");

							do  {
								idValide = false;
								int numPion;
								//tant que le joueur donne un pion qui n'est pas dans l'écurie on lui demande de reséléctionner un pion valide
								do {
									System.out.println("Lequel voulez vous sortir de l'écurie " + plateau.getEcuries().get(i).getChevaux().toString() + " ? ");
									do {
									n = sc.next();
									if(!n.equals("1") && !n.equals("2") && !n.equals("3") && !n.equals("4")) {
										System.out.println("Veuillez entrer un nombre entre 1 et 4");
									}
									}while(!n.equals("1") && !n.equals("2") && !n.equals("3") && !n.equals("4"));
									numPion = Integer.parseInt(n);
									numPion--;
									if(!(plateau.getEcuries().get(i).getChevaux().contains(joueurCourant.getChevaux().get(numPion)))) {
										System.out.println("Ce pion n'est pas dans l'écurie !\n");
									}
								} while(!(plateau.getEcuries().get(i).getChevaux().contains(joueurCourant.getChevaux().get(numPion))));

								if(numPion >= 0 && numPion < 4) {
									idValide = true;

									initial = joueurCourant.getChevaux().get(numPion).getPosition();

									pion = joueurCourant.getChevaux().get(numPion);

									switch(joueurCourant.getCouleur()) {
									case JAUNE:
										suivant = plateau.getChemins().get(0);
										break;
									case BLEU:
										suivant = plateau.getChemins().get(14);
										break;
									case ROUGE:
										suivant = plateau.getChemins().get(28);
										break;
									case VERT: 
										suivant = plateau.getChemins().get(42); 
										break;
									}
									mangerLesPions(suivant);
									plateau.deplacerPion(pion, suivant, de, initial);

								} else {
									System.out.println("Id de cheval invalide !");
								}
							} while(!idValide);
							//si non on lui demande quel pion veut-il déplacer.
						} else if(rep.equals("N")) {
							System.out.println("Vous avez seléctionné Non");
							//permet de vérifier si un pion est sortie de l'écurie avant de proposer des déplacements
							if(plateau.getEcuries().get(i).getChevaux().size() < 4) {
								do  {
									idValide = false;
									int numPion;
									//tant que le joueur donne un pion qui est dans l'écurie on lui demande de reséléctionner un pion valide
									do {
										System.out.println("Quel pion voulez-vous déplacer " + joueurCourant.getChevaux().toString()+ " ? ");
										n = sc.next();

										numPion = Integer.parseInt(n);
										numPion--;
										if(plateau.getEcuries().get(i).getChevaux().contains(joueurCourant.getChevaux().get(numPion))) {
											System.out.println("Ce pion est dans l'écurie !\n");
										}
									} while(plateau.getEcuries().get(i).getChevaux().contains(joueurCourant.getChevaux().get(numPion)));

									if(numPion >= 0 && numPion < 4) {
										idValide = true;

										initial = joueurCourant.getChevaux().get(numPion).getPosition();

										for(int d = 0; d < de; d++) {
											pion = joueurCourant.getChevaux().get(numPion);
											courant = joueurCourant.getChevaux().get(numPion).getPosition();
											if(courant == plateau.getChemins().get(55)) {
												suivant = plateau.getChemins().get(0);
											} else{
												suivant = plateau.getChemins().get(plateau.getChemins().indexOf(courant) + 1);
											}
											switch(joueurCourant.getCouleur()) {
											case JAUNE:
												if(suivant == plateau.getChemins().get(0)) {
													if(de == 1) {
														suivant = plateau.getEchelles().get(0).get(0);
													}
													else {
														System.out.println("Vous êtes devant l'échelle !");
														suivant = courant;
													}
												}
												else if(courant == plateau.getEchelles().get(0).get(0)) {
													if(de == 2) {
														suivant = plateau.getEchelles().get(0).get(1);
													}
													else {
														System.out.println("Vous ne pouvez pas avancer !");
														suivant = courant;
													}
												}
												else if(courant == plateau.getEchelles().get(0).get(1)) {
													if(de == 3) {
														suivant = plateau.getEchelles().get(0).get(2);
													}
													else {
														System.out.println("Vous ne pouvez pas avancer !");
														suivant = courant;
													}
												}
												else if(courant == plateau.getEchelles().get(0).get(2)) {
													if(de == 4) {
														suivant = plateau.getEchelles().get(0).get(3);
													}
													else {
														System.out.println("Vous ne pouvez pas avancer !");
														suivant = courant;
													}
												}
												else if(courant == plateau.getEchelles().get(0).get(3)) {
													if(de == 5) {
														suivant = plateau.getEchelles().get(0).get(4);
													}
													else {
														System.out.println("Vous ne pouvez pas avancer !");
														suivant = courant;
													}
												}
												else if(courant == plateau.getEchelles().get(0).get(4)) {
													if(de == 6) {
														suivant = plateau.getEchelles().get(0).get(5);
													}
													else {
														System.out.println("Vous ne pouvez pas avancer !");
														suivant = courant;
													}
												};
												break;
											case BLEU:
												if(suivant == plateau.getChemins().get(14)) {
													if(de == 1) {
														suivant = plateau.getEchelles().get(1).get(0);
													}
													else {
														System.out.println("Vous êtes devant l'échelle !");
														suivant = courant;
													}
												}
												else if(courant == plateau.getEchelles().get(1).get(0)) {
													if(de == 2) {
														suivant = plateau.getEchelles().get(1).get(1);
													}
													else {
														System.out.println("Vous ne pouvez pas avancer !");
														suivant = courant;
													}
												}
												else if(courant == plateau.getEchelles().get(1).get(1)) {
													if(de == 3) {
														suivant = plateau.getEchelles().get(1).get(2);
													}
													else {
														System.out.println("Vous ne pouvez pas avancer !");
														suivant = courant;
													}
												}
												else if(courant == plateau.getEchelles().get(1).get(2)) {
													if(de == 4) {
														suivant = plateau.getEchelles().get(1).get(3);
													}
													else {
														System.out.println("Vous ne pouvez pas avancer !");
														suivant = courant;
													}
												}
												else if(courant == plateau.getEchelles().get(1).get(3)) {
													if(de == 5) {
														suivant = plateau.getEchelles().get(1).get(4);
													}
													else {
														System.out.println("Vous ne pouvez pas avancer !");
														suivant = courant;
													}
												}
												else if(courant == plateau.getEchelles().get(1).get(4)) {
													if(de == 6) {
														suivant = plateau.getEchelles().get(1).get(5);
													}
													else {
														System.out.println("Vous ne pouvez pas avancer !");
														suivant = courant;
													}
												};
												break;
											case ROUGE:
												if(suivant == plateau.getChemins().get(28)){
													if(de == 1) {
														suivant = plateau.getEchelles().get(2).get(0);
													}
													else {
														System.out.println("Vous êtes devant l'échelle !");
														suivant = courant;
													}
												}
												else if(courant == plateau.getEchelles().get(2).get(0)) {
													if(de == 2) {
														suivant = plateau.getEchelles().get(2).get(1);
													}
													else {
														System.out.println("Vous ne pouvez pas avancer !");
														suivant = courant;
													}
												}
												else if(courant == plateau.getEchelles().get(2).get(1)) {
													if(de == 3) {
														suivant = plateau.getEchelles().get(2).get(2);
													}
													else {
														System.out.println("Vous ne pouvez pas avancer !");
														suivant = courant;
													}
												}
												else if(courant == plateau.getEchelles().get(2).get(2)) {
													if(de == 4) {
														suivant = plateau.getEchelles().get(2).get(3);
													}
													else {
														System.out.println("Vous ne pouvez pas avancer !");
														suivant = courant;
													}
												}
												else if(courant == plateau.getEchelles().get(2).get(3)) {
													if(de == 5) {
														suivant = plateau.getEchelles().get(2).get(4);
													}
													else {
														System.out.println("Vous ne pouvez pas avancer !");
														suivant = courant;
													}
												}
												else if(courant == plateau.getEchelles().get(2).get(4)) {
													if(de == 6) {
														suivant = plateau.getEchelles().get(2).get(5);
													}
													else {
														System.out.println("Vous ne pouvez pas avancer !");
														suivant = courant;
													}
												};
												break;
											case VERT: 
												if(suivant == plateau.getChemins().get(42)) {
													if(de == 1) {
														suivant = plateau.getEchelles().get(3).get(0);
													}
													else {
														System.out.println("Vous êtes devant l'échelle !");
														suivant = courant;
													}
												}
												else if(courant == plateau.getEchelles().get(3).get(0)) {
													if(de == 2) {
														suivant = plateau.getEchelles().get(3).get(1);
													}
													else {
														System.out.println("Vous ne pouvez pas avancer !");
														suivant = courant;
													}
												}
												else if(courant == plateau.getEchelles().get(3).get(1)) {
													if(de == 3) {
														suivant = plateau.getEchelles().get(3).get(2);
													}
													else {
														System.out.println("Vous ne pouvez pas avancer !");
														suivant = courant;
													}
												}
												else if(courant == plateau.getEchelles().get(3).get(2)) {
													if(de == 4) {
														suivant = plateau.getEchelles().get(3).get(3);
													}
													else {
														System.out.println("Vous ne pouvez pas avancer !");
														suivant = courant;
													}
												}
												else if(courant == plateau.getEchelles().get(3).get(3)) {
													if(de == 5) {
														suivant = plateau.getEchelles().get(3).get(4);
													}
													else {
														System.out.println("Vous ne pouvez pas avancer !");
														suivant = courant;
													}
												}
												else if(courant == plateau.getEchelles().get(3).get(4)) {
													if(de == 6) {
														suivant = plateau.getEchelles().get(3).get(5);
													}
													else {
														System.out.println("Vous ne pouvez pas avancer !");
														suivant = courant;
													}
												};
												break;
											}
											if(suivant == plateau.getChemins().get((plateau.getChemins().indexOf(initial) + de)%56)) {
												mangerLesPions(suivant);
											}
											plateau.deplacerPion(pion, suivant, de, initial);
										}
									} else {
										System.out.println("Id de cheval invalide !");
									}

								} while(!idValide);
							} 
							//sinon on passe le tour
							else {
								System.out.println("Vous passez votre tour");
							}
							System.out.println("Appuyer pour continuer");
							sc.nextLine();
						}
					}
				}
			}
			//Si c'est la deuxième fois que le joueur fais 6 on passe quand même au joueur suivant
			if(maxtour%2 == 0) {
				//permet de passer au joueur suivant
				setJoueurCourant(joueurs.get((joueurs.indexOf(joueurCourant) + 1) % 4));
			}
		} else if(de > 0 && de < 6) {
			for (int i = 0; i < plateau.getEcuries().size(); i++) {
				//tester si l'écurie qu'on regarde est bien celle du joueur courant
				if (plateau.getEcuries().get(i).getCouleur().equals(joueurCourant.getCouleur())) {
					//permet de vérifier si un pion est sortie de l'écurie avant de proposer des déplacements
					if (plateau.getEcuries().get(i).getChevaux().size() < 4) {
						do  {
							idValide = false;
							int numPion;
							//tant que le joueur donne un pion qui est dans l'écurie on lui demande de reséléctionner un pion valide
							do {
								System.out.println("Quel pion voulez-vous déplacer " + joueurCourant.getChevaux().toString()+ " ? ");
								n = sc.next();

								numPion = Integer.parseInt(n);
								numPion--;
								if(plateau.getEcuries().get(i).getChevaux().contains(joueurCourant.getChevaux().get(numPion))) {
									System.out.println("Ce pion est dans l'écurie !\n");
								}
							} while(plateau.getEcuries().get(i).getChevaux().contains(joueurCourant.getChevaux().get(numPion)));

							if(numPion >= 0 && numPion < 4) {
								idValide = true;

								initial = joueurCourant.getChevaux().get(numPion).getPosition();

								for(int d = 0; d < de; d++) {
									pion = joueurCourant.getChevaux().get(numPion);
									courant = joueurCourant.getChevaux().get(numPion).getPosition();
									if(courant == plateau.getChemins().get(55)) {
										suivant = plateau.getChemins().get(0);
									}
									else {
										suivant = plateau.getChemins().get(plateau.getChemins().indexOf(courant) + 1);
									}
									switch(joueurCourant.getCouleur()) {
									case JAUNE:
										if(suivant == plateau.getChemins().get(0)) {
											if(de == 1) {
												suivant = plateau.getEchelles().get(0).get(0);
											}
											else {
												System.out.println("Vous êtes devant l'échelle !");
												suivant = courant;
											}
										}
										else if(courant == plateau.getEchelles().get(0).get(0)) {
											if(de == 2) {
												suivant = plateau.getEchelles().get(0).get(1);
											}
											else {
												System.out.println("Vous ne pouvez pas avancer !");
												suivant = courant;
											}
										}
										else if(courant == plateau.getEchelles().get(0).get(1)) {
											if(de == 3) {
												suivant = plateau.getEchelles().get(0).get(2);
											}
											else {
												System.out.println("Vous ne pouvez pas avancer !");
												suivant = courant;
											}
										}
										else if(courant == plateau.getEchelles().get(0).get(2)) {
											if(de == 4) {
												suivant = plateau.getEchelles().get(0).get(3);
											}
											else {
												System.out.println("Vous ne pouvez pas avancer !");
												suivant = courant;
											}
										}
										else if(courant == plateau.getEchelles().get(0).get(3)) {
											if(de == 5) {
												suivant = plateau.getEchelles().get(0).get(4);
											}
											else {
												System.out.println("Vous ne pouvez pas avancer !");
												suivant = courant;
											}
										}
										else if(courant == plateau.getEchelles().get(0).get(4)) {
											if(de == 6) {
												suivant = plateau.getEchelles().get(0).get(5);
											}
											else {
												System.out.println("Vous ne pouvez pas avancer !");
												suivant = courant;
											}
										};
										break;
									case BLEU:
										if(suivant == plateau.getChemins().get(14)) {
											if(de == 1) {
												suivant = plateau.getEchelles().get(1).get(0);
											}
											else {
												System.out.println("Vous êtes devant l'échelle !");
												suivant = courant;
											}
										}
										else if(courant == plateau.getEchelles().get(1).get(0)) {
											if(de == 2) {
												suivant = plateau.getEchelles().get(1).get(1);
											}
											else {
												System.out.println("Vous ne pouvez pas avancer !");
												suivant = courant;
											}
										}
										else if(courant == plateau.getEchelles().get(1).get(1)) {
											if(de == 3) {
												suivant = plateau.getEchelles().get(1).get(2);
											}
											else {
												System.out.println("Vous ne pouvez pas avancer !");
												suivant = courant;
											}
										}
										else if(courant == plateau.getEchelles().get(1).get(2)) {
											if(de == 4) {
												suivant = plateau.getEchelles().get(1).get(3);
											}
											else {
												System.out.println("Vous ne pouvez pas avancer !");
												suivant = courant;
											}
										}
										else if(courant == plateau.getEchelles().get(1).get(3)) {
											if(de == 5) {
												suivant = plateau.getEchelles().get(1).get(4);
											}
											else {
												System.out.println("Vous ne pouvez pas avancer !");
												suivant = courant;
											}
										}
										else if(courant == plateau.getEchelles().get(1).get(4)) {
											if(de == 6) {
												suivant = plateau.getEchelles().get(1).get(5);
											}
											else {
												System.out.println("Vous ne pouvez pas avancer !");
												suivant = courant;
											}
										};
										break;
									case ROUGE:
										if(suivant == plateau.getChemins().get(28)){
											if(de == 1) {
												suivant = plateau.getEchelles().get(2).get(0);
											}
											else {
												System.out.println("Vous êtes devant l'échelle !");
												suivant = courant;
											}
										}
										else if(courant == plateau.getEchelles().get(2).get(0)) {
											if(de == 2) {
												suivant = plateau.getEchelles().get(2).get(1);
											}
											else {
												System.out.println("Vous ne pouvez pas avancer !");
												suivant = courant;
											}
										}
										else if(courant == plateau.getEchelles().get(2).get(1)) {
											if(de == 3) {
												suivant = plateau.getEchelles().get(2).get(2);
											}
											else {
												System.out.println("Vous ne pouvez pas avancer !");
												suivant = courant;
											}
										}
										else if(courant == plateau.getEchelles().get(2).get(2)) {
											if(de == 4) {
												suivant = plateau.getEchelles().get(2).get(3);
											}
											else {
												System.out.println("Vous ne pouvez pas avancer !");
												suivant = courant;
											}
										}
										else if(courant == plateau.getEchelles().get(2).get(3)) {
											if(de == 5) {
												suivant = plateau.getEchelles().get(2).get(4);
											}
											else {
												System.out.println("Vous ne pouvez pas avancer !");
												suivant = courant;
											}
										}
										else if(courant == plateau.getEchelles().get(2).get(4)) {
											if(de == 6) {
												suivant = plateau.getEchelles().get(2).get(5);
											}
											else {
												System.out.println("Vous ne pouvez pas avancer !");
												suivant = courant;
											}
										};
										break;
									case VERT: 
										if(suivant == plateau.getChemins().get(42)) {
											if(de == 1) {
												suivant = plateau.getEchelles().get(3).get(0);
											}
											else {
												System.out.println("Vous êtes devant l'échelle !");
												suivant = courant;
											}
										}
										else if(courant == plateau.getEchelles().get(3).get(0)) {
											if(de == 2) {
												suivant = plateau.getEchelles().get(3).get(1);
											}
											else {
												System.out.println("Vous ne pouvez pas avancer !");
												suivant = courant;
											}
										}
										else if(courant == plateau.getEchelles().get(3).get(1)) {
											if(de == 3) {
												suivant = plateau.getEchelles().get(3).get(2);
											}
											else {
												System.out.println("Vous ne pouvez pas avancer !");
												suivant = courant;
											}
										}
										else if(courant == plateau.getEchelles().get(3).get(2)) {
											if(de == 4) {
												suivant = plateau.getEchelles().get(3).get(3);
											}
											else {
												System.out.println("Vous ne pouvez pas avancer !");
												suivant = courant;
											}
										}
										else if(courant == plateau.getEchelles().get(3).get(3)) {
											if(de == 5) {
												suivant = plateau.getEchelles().get(3).get(4);
											}
											else {
												System.out.println("Vous ne pouvez pas avancer !");
												suivant = courant;
											}
										}
										else if(courant == plateau.getEchelles().get(3).get(4)) {
											if(de == 6) {
												suivant = plateau.getEchelles().get(3).get(5);
											}
											else {
												System.out.println("Vous ne pouvez pas avancer !");
												suivant = courant;
											}
										};
										break;
									}
									if(suivant == plateau.getChemins().get((plateau.getChemins().indexOf(initial) + de)%56)) {
										mangerLesPions(suivant);
									}
									plateau.deplacerPion(pion, suivant, de, initial);
								}
							} else {
								System.out.println("Id de cheval invalide !");
							}

						} while(!idValide);
					}
					//sinon on passe le tour
					else {
						System.out.println("Vous passez votre tour");
					}

					System.out.println("Appuyer pour continuer");
					sc.nextLine();
				}
			}
			//permet de passer au joueur suivant
			setJoueurCourant(joueurs.get((joueurs.indexOf(joueurCourant) + 1) % 4));
		}
	}

	/**
	 * estPartieTerminee permet de tester si la partie est fini ou non
	 * @return true ou false
	 */
	public boolean estPartieTerminee() {
		boolean res = false;
		for(int i = 0; i < 4; i++) {
			for(int j = 3; j < 6; j++) {
				if(plateau.getEchelles().get(i).get(j).getChevaux().size() == 1) {
					res = true;
				}
			}
		}
		return res;
	}
	/**
	 * getJoueurCourant permet d'obtenir le joueur en train de jouer
	 * @return this.joueurCourant
	 */
	public Joueur getJoueurCourant() {
		return this.joueurCourant;
	}

	/**
	 * setJoueurCourant permet de définir le joueur en train de jouer
	 * @param Joueur 
	 */
	public void setJoueurCourant(Joueur j) {
		this.joueurCourant = j;
	}

	/**
	 * getPlateau permet d'obtenir le plateau
	 * @return this.plateau
	 */
	public Plateau getPlateau() {
		return this.plateau;
	}

	/**
	 * getJoueurs permet de récupérer la listes des joueurs
	 * @return this.joueurs
	 */
	public ArrayList<Joueur> getJoueurs() {
		return this.joueurs;
	}

	/**
	 * mangerLesPions permet de faire retourner les pions manger à leur écurie
	 * @param Case 
	 */
	private void mangerLesPions(Case c) {
		if(!(c.getChevaux().isEmpty())) {
			if(c.getChevaux().get(0).getCouleur() != joueurCourant.getCouleur()) {
				for(int j = 0; j < 4; j++) {
					if (plateau.getEcuries().get(j).getCouleur().equals(c.getChevaux().get(0).getCouleur())) {
						CaseEcurie ecurie = plateau.getEcuries().get(j);
						/*
							for(Pion p : c.getChevaux()) {
								c.getChevaux().get(c.getChevaux().indexOf(p)).setPosition(ecurie);
								c.getChevaux().remove(p);
							}
						 */
						if(c.getChevaux().get(0) != null) {
							c.getChevaux().get(0).setPosition(ecurie);
							c.getChevaux().get(0).getPosition().getChevaux().remove(0);
						}
						if(c.getChevaux().get(1) != null) {
							c.getChevaux().get(1).setPosition(ecurie);
							c.getChevaux().get(1).getPosition().getChevaux().remove(1);
						}
						if(c.getChevaux().get(2) != null) {
							c.getChevaux().get(2).setPosition(ecurie);
							c.getChevaux().get(2).getPosition().getChevaux().remove(2);
						}
						if(c.getChevaux().get(3) != null) {
							c.getChevaux().get(3).setPosition(ecurie);
							c.getChevaux().get(3).getPosition().getChevaux().remove(3);
						}
					}
				}
			}
		}
	}
}