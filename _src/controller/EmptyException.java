package controller;

/**
 * 
 * @author Elena Stefancova
 * Vlastna vynimka - vyuzivana v pripade, ze pouzivatel pri vkladani textovych udajov do GUI nevyplni potrebne polia.
 *
 */
@SuppressWarnings("serial")
public class EmptyException extends Exception {
	
	public EmptyException(String message) {
        super(message);
    }
}
