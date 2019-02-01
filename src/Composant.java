import java.util.ArrayList;
import java.util.HashMap;
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
    

}
