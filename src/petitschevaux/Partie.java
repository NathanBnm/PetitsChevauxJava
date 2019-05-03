package petitschevaux;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 */
public class Partie {

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
	 * @return
	 */
	public void initialiserJoueurs(int nbJoueurs) {
		// TODO implement here
		return;
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