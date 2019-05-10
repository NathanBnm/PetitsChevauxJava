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

/**
 * 
 */
public class JoueurHumain extends Joueur {

	/**
	 * Constructeur par défaut d'un joueur humain
	 * @param String Nom du joueur
	 * @param Couleur Couleur du joueur
	 */
	public JoueurHumain(String nom, Couleur couleur) {
		super(nom, couleur);
	}

	/**
	 * Cette méthode permet de choisir le pion à déplacer sur le plateau
	 * @param int Numéro du pion
	 * @param Plateau Plateau de jeu
	 * @return
	 */
	public Pion choisirPion(int n, Plateau p) {
		Pion pion =  new Pion(this.getNom(), this.getCouleur());
		return pion;
	}
	
}