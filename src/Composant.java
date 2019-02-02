import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Composant
{
    private String nom ;
    private String type ;
    private Composant proprietaire;
    private HashMap <String, Propriete> proprietes ;
    private HashMap <String, String> evenements ;

    public Composant(String nom, String type)
    {
        this.nom = nom ;
        this.type = type ;
        this.proprietes = new HashMap<String, Propriete>() ;
        this.evenements = new HashMap<String, String>() ;
    }
    
    
    public void ajouterProprietes(ArrayList<String> noms, ArrayList<String> types )
    {
    	if(types.get(0).toLowerCase().compareTo("boolean")==0 || types.get(0).toLowerCase().compareTo("bool")==0)
    	{
    		for(int j=0; j<noms.size();j++)
    		{
        		this.proprietes.put(noms.get(j), new Propriete(noms.get(j),BooleanType.getInstance()));    			
    		}
    	}	
    	else if(types.get(0).toLowerCase().compareTo("int") == 0 )
    	{
    		for(int j=0; j<noms.size();j++)
    		{
        		this.proprietes.put(noms.get(j), new Propriete(noms.get(j),IntType.getInstance()));    			
    		}    		
    	}
    	else 
    	{
    		TypePropriete enumeration = new EnumType(types);
    		for(int j=0; j<noms.size();j++)
    		{
        		this.proprietes.put(noms.get(j), new Propriete(noms.get(j),enumeration));    			
    		}    		
    	}

    }

    public String getNom()
    {
    	return this.nom;
    }

    public String getType()
    {
    	return this.type;
    }
    
    public int initialiserPropriete(String nomPropriete, String valeurPropriete)
    {
    	if(this.proprietes.containsKey(nomPropriete))
    	{
    		return this.proprietes.get(nomPropriete).setValeur(valeurPropriete);
    	}
    	else
    	{
    		return 0;
    	}
    }

    
    public void setProprietaire(Composant proprietaire)
    {
    	this.proprietaire=proprietaire;
    }

    public void afficherProprietes()
    {
        Iterator iterator = this.proprietes.entrySet().iterator();
        while (iterator.hasNext()) 
        {
        	  System.out.println("Propriété :");
	          Map.Entry mapentry = (Map.Entry) iterator.next();
	          Propriete propriete = (Propriete) mapentry.getValue();
	          propriete.afficher();
        } 
    }

}
