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
 * Classe CasePleineException (hérite d'Exception)
 */
public class CasePleineException extends java.lang.Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4674141337433287480L;

	/**
	 * Default constructor
	 */
	public CasePleineException() {
		super();
	}


	/**
	 * @param String
	 */
	public CasePleineException(String msg) {
		super(msg);
	}

	/**
	 * @param Throwable
	 */
	public CasePleineException(Throwable thr) {
		super(thr);
	}

	/**
	 * @param String 
	 * @param Throwable
	 */
	public CasePleineException(String msg, Throwable thr) {
		super(msg, thr);
	}

	/**
	 * @param String 
	 * @param Throwable 
	 * @param Boolean 
	 * @param Boolean
	 */
	public CasePleineException(String msg, Throwable thr, Boolean b1, Boolean b2) {
		super(msg, thr, b1, b2);
	}

}