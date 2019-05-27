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
 * Enumération Couleur
 */
public enum Couleur {
	JAUNE('J'),
	BLEU('B'),
	ROUGE('R'),
	VERT('V');
	
	public final char symbole;
	
	Couleur(char couleur) {
		this.symbole = couleur;
	}
	
	public char getSymbole() {
		return symbole;
	}
}