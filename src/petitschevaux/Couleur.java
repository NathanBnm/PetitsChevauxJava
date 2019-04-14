package petitschevaux;

/**
 * 
 */
public enum Couleur {
	JAUNE('J'),
	BLEU('B'),
	VERT('V'),
	ROUGE('R');
	
	public static final char symbole = 0;
	
	Couleur(char couleur) {
		
	}
	
	public char getSymbole() {
		return symbole;
	}
}