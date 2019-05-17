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
 * Classe ConflitDeCouleurException (hérite d'Exception)
 */
public class ConflitDeCouleurException extends java.lang.Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3235048995601583349L;

	/**
	 * Default constructor
	 */
	public ConflitDeCouleurException() {
		super();
	}

	/**
	 * @param String
	 */
	public ConflitDeCouleurException(String msg) {
		super(msg);
	}

	/**
	 * @param Throwable
	 */
	public ConflitDeCouleurException(Throwable thr) {
		super(thr);
	}

	/**
	 * @param String 
	 * @param Throwable
	 */
	public ConflitDeCouleurException(String msg, Throwable thr) {
		super(msg, thr);
	}

	/**
	 * @param String 
	 * @param Throwable 
	 * @param Boolean 
	 * @param Boolean
	 */
	public ConflitDeCouleurException(String msg, Throwable thr, Boolean b1, Boolean b2) {
		super(msg, thr);
	}

}