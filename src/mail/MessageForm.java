package mail;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public final class MessageForm {
    private static final String CHAMP_FROM  = "from";
    private static final String CHAMP_TO   = "to";
    private static final String CHAMP_SUBJECT   = "subject";
    private static final String CHAMP_MESSAGE    = "message";
    
    public Message getMessage( HttpServletRequest request ) {

        String from = getValeurChamp( request, CHAMP_FROM );
        String to = getValeurChamp( request, CHAMP_TO );
        String subject = getValeurChamp( request, CHAMP_SUBJECT );
        String msg = getValeurChamp( request, CHAMP_MESSAGE );

        Message message = new Message(from, to, subject, msg);

        return message;

    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }

}