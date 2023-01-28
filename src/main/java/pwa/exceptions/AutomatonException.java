package pwa.exceptions;

public class AutomatonException extends RuntimeException {

    public static final String ERREUR_DONNEES_INCORRECTES= "données incorrectes";
    public static final String ERREUR_FICHIER_INEXISTANT= "fichier inexistant";
    public static final String ORIENTATION_INCORRECTE = "orientation incorrecte";
    public static final String INSTRUCTION_INCORRECTE = "instruction incorrecte";
    public static final String POSITION_INCORRECTE = "position incorrecte";

    private static final long serialVersionUID = -4616154977829297246L;

    public AutomatonException(String message) {
        super(message);

    }
}
