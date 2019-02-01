import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Composant
{
    private String nom ;
    private String type ;
    private HashMap <String, Property> proprietes ;
    private HashMap <String, String> evenements ;

    public Composant(String nom, String type)
    {
        this.nom = nom ;
        this.type = type ;
        this.proprietes = new HashMap<String, Property>() ;
        this.evenements = new HashMap<String, String>() ;
    }
    
    public void setNom(String nom) 
    {
        this.nom = nom;
    }

    public void setType(String type) 
    {
        this.type = type;
    }
    
    public void ajouterProprietes(ArrayList<String> names, ArrayList<String> types )
    {
    	
    	if(types.get(0).toLowerCase().compareTo("boolean")==0 || types.get(0).toLowerCase().compareTo("bool")==0)
    	{
    		for(int j=0; j<names.size();j++)
    		{
        		this.proprietes.put(names.get(j), new Property(names.get(j),BooleanType.getInstance()));    			
    		}
    	}
    	else if(types.get(0).toLowerCase().compareTo("int") == 0 )
    	{
    		for(int j=0; j<names.size();j++)
    		{
        		this.proprietes.put(names.get(j), new Property(names.get(j),IntType.getInstance()));    			
    		}    		
    	}
    	else 
    	{
    		PropertyType enumeration = new EnumType(types);
    		for(int j=0; j<names.size();j++)
    		{
        		this.proprietes.put(names.get(j), new Property(names.get(j),enumeration));    			
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
    	return 1;
    }

    public void afficherProprietes()
    {
        Iterator iterator = this.proprietes.entrySet().iterator();
        while (iterator.hasNext()) 
        {
        	  System.out.println("Propriété :");
	          Map.Entry mapentry = (Map.Entry) iterator.next();
	          Property propriete = (Property) mapentry.getValue();
	          propriete.afficher();
        } 
    }

}
