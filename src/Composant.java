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
    private HashMap <String, Evenement> evenements ;

    public Composant(String nom, String type)
    {
        this.nom = nom ;
        this.type = type ;
        this.proprietes = new HashMap<String, Propriete>() ;
        this.evenements = new HashMap<String, Evenement>() ;
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

    public int ajouterConditionEvenement(String nomEvenement, String variableCondition, String valeurCondition, String type)
    {
    	if(this.proprietes.containsKey(variableCondition))
    	{
    		if(this.proprietes.get(variableCondition).compatible(valeurCondition))
    		{
        		this.evenements.put(nomEvenement, new ConditionEvenement(nomEvenement,this.proprietes.get(variableCondition), valeurCondition, type));
        		return 1;
    		}
    		else
    		{
    			return -1;
    		}
    	}
    	else
    	{
    		return 0;
    	}
    }
    
    public void ajouterAffectationEvenement(String nom)
    {
    	this.evenements.put(nom, new AffectationEvenement(nom));
    }
    
    public int ajouterAffectation(String nomEvent,String variable,String valeur)
    {
    	if(this.proprietes.containsKey(variable))
    	{
    		if(this.proprietes.get(variable).compatible(valeur))
    		{
    			this.evenements.get(nomEvent).ajouterAffectation(this.proprietes.get(variable),valeur);
    	    	return 1;
    		}
    		else
    		{
    			return -1;
    		}
    	}
    	else
    	{
    		return 0;
    	}
    }

    public int ajouterIncrementationNombre(String nomEvent,String variable, String nombre)
    {
    	if(this.proprietes.containsKey(variable))
    	{
    		if(this.proprietes.get(variable).compatible(nombre))
    		{
    			this.evenements.get(nomEvent).ajouterIncrementationNombre(this.proprietes.get(variable),nombre);
    	    	return 1;
    		}
    		else
    		{
    			return -1;
    		}
    	}
    	else
    	{
    		return 0;
    	}
    	
    }

    public int ajouterIncrementationString(String nomEvent,String variable, String valeur)
    {
    	if(this.proprietes.containsKey(variable))
    	{
    		if(this.proprietes.get(variable).compatible(valeur))
    		{
    			this.evenements.get(nomEvent).ajouterIncrementationString(this.proprietes.get(variable),valeur);
    	    	return 1;
    		}
    		else
    		{
    			return -1;
    		}
    	}
    	else
    	{
    		return 0;
    	}
    	
    }

    
    public void afficherProprietes()
    {
    	System.out.println(this.evenements.size());
    	Iterator iterator = this.evenements.entrySet().iterator();
    	
    	while (iterator.hasNext()) 
    	{
    			System.out.println("Propriété :");
    			Map.Entry mapentry = (Map.Entry) iterator.next();
    		//	Propriete propriete = (Propriete) mapentry.getValue();
    			Evenement evenement = (Evenement) mapentry.getValue();
    		//	System.out.println(evenement.getClass());
//    			propriete.afficher();
    			evenement.afficherActions();
    	} 
    }


}
