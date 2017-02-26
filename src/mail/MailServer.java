package mail;
import java.util.Vector;

public class MailServer{
    public Vector<Message> messages;
    private static MailServer  instance=null;
    // ajouter ici les variables que vous jugez nécessaires

    public MailServer(){
	messages=new Vector<Message>();
    }

    public static MailServer   newInstance(){
	if (instance==null)
	    instance=new  MailServer();
	return instance;       
    }
    
   public String sendMessage(String fromp, String top, String subject, String messagep){
    // créer un  nouveau message 
	// ajouter votre code ici
	   Message msg= new Message(fromp,top,subject,messagep);

	// ajouter le message dans la listes des messages du serveur
	   messages.addElement(msg);

       return ("Message sent successfully : "+(messages.size())+"messages on the server");
    }

    public Vector<Message> readMessages(String to){
    	Vector<Message> messagesRecus=new Vector<Message>();
	// récupérer, dans messagesRecus, les messages dont le destinataire est "to", il faut les marquer comme étant "lu"
	// ajouter votre code ici

	int nbelts=messages.size();
	if(nbelts>0){
	for(int i=0;i<nbelts;i++){
		String top=(((Message)messages.elementAt(i))).getTo();
		if((top!=null)&&(((Message)messages.elementAt(i)).getNew())){
			
			if(top.equalsIgnoreCase(to)){
			((Message)messages.elementAt(i)).setNew(false);
			messagesRecus.addElement(messages.elementAt(i));
			}
			else{
				
				if(to==""){
					((Message)messages.elementAt(i)).setNew(false);
					messagesRecus.addElement(messages.elementAt(i));
				}
				
			}
		}
		}
	}
	

	// envoyer les messages reçus 
	// ajouter votre code ici

	return messagesRecus;

    }

    public String removeMessages (String to){
	
	int oldMessageNumber=0;

 
	// déclaration des autres variables 
	// ajouter votre code ici
		
	int nbelt=messages.size();

	// supprimer tous les messages marqués comme étant "lu" et dont le destinataire est "to"
	// ajouter votre code

	
	
	for(int i=0;i<nbelt;i++){
		String top=(((Message)messages.elementAt(i))).getTo();
		if((top!=null)&&(!((Message)messages.elementAt(i)).getNew())){
			
			if(top.equalsIgnoreCase(to)){
			
			messages.removeElementAt(i);
			oldMessageNumber++;
			}
			else{
				
				if(to==""){
					
					messages.removeElementAt(i);
					oldMessageNumber++;
				}
				
			}
		}
		}
	

	if(oldMessageNumber==0)
	    return ("No old messages\n");
	else		  
	    return (oldMessageNumber+" Old messages removed successfully\n");
    }

    // ajouter ici les méthodes que vous jugez nécessaires
    
    public Vector<Message> readAllMessages(String to){
    	Vector<Message> messagesRecus=new Vector<Message>();
    	// récupérer, dans messagesRecus, les messages dont le destinataire est "to", il faut les marquer comme étant "lu"
    	// ajouter votre code ici

    	int nbelts=messages.size();	
    	for(int i=0;i<nbelts;i++)
    	{
    		if(((Message)messages.elementAt(i)).getTo().equalsIgnoreCase(to)||(to==null)){
    			((Message)messages.elementAt(i)).setNew(false);
    			messagesRecus.addElement(messages.elementAt(i));
    		}
    	}

    	// envoyer les messages reçus 
    	// ajouter votre code ici

    	return messagesRecus;

        }

}