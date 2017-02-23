package mail;
public class Message implements java.io.Serializable {
    private String from;
    private String to;
    private String subject;
    private String message="";
    private boolean isNew;
    // ajouter ici les variables que vous jugez nécessaires
    
    public Message(String from, String to, String subject, String message){
	// initialisation des variables	
	// ajouter votre code ici
    	this.from=from;
    	this.to=to;
    	this.subject=subject;
    	this.message=message;
    	this.isNew=true;
    }
    
    public String getTo(){
	return to;
    }
    public String getFrom(){
	return from;
    }  
    public String getSubject(){
	return subject;
    }
    public String getMessage(){
	return message;
    }
    public void setTo(String top){
	to=top;
    }
    public void setFrom(String fromp){
	from=fromp;
    } 
    public void setSubject(String fromp){
	from=fromp;
    }
    public boolean getNew(){
	return isNew;
    }
    public void setNew(boolean isNewp){
	isNew=isNewp;
    }
    // ajouter ici les méthodes que vous jugez nécessaires

}