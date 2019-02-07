import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Composant implements Cloneable
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
    
    public void setProprietes(HashMap <String, Propriete> proprietes)
    {
    	this.proprietes = proprietes;
    }

    public void setProprietaire(Composant proprietaire)
    {
    	this.proprietaire=proprietaire;
    }

    public HashMap <String, Propriete> getProprietes()
    {
    	return this.proprietes;
    }

    public String getNom()
    {
    	return this.nom;
    }

    public String getType()
    {
    	return this.type;
    }

    public int getNb()
    {
    	return this.evenements.size();
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
    
    public int ajouterConditionEvenementParametre(String nomEvenement, String variableCondition, String valeurCondition, String type, String parametre)
    {
    	if(this.proprietes.containsKey(variableCondition))
    	{
    		if(this.proprietes.get(variableCondition).compatible(valeurCondition))
    		{
        		this.evenements.put(nomEvenement, new ConditionEvenementParametre(nomEvenement,this.proprietes.get(variableCondition), valeurCondition, type,parametre));
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
    
    public int ajouterAffectation(String nomEvent,String variable,String valeur)
    {
    	if(this.proprietes.containsKey(variable) || (this.evenements.get(nomEvent).getClass().toString().compareTo(ConditionEvenementParametre.class.toString())==0 && ((ConditionEvenementParametre)this.evenements.get(nomEvent)).getNomParametre().compareTo(variable)==0) )
    	{
    		if((this.proprietes.containsKey(variable) && this.proprietes.get(variable).compatible(valeur) )|| (this.evenements.get(nomEvent).getClass().toString().compareTo(ConditionEvenementParametre.class.toString())==0 && ((ConditionEvenementParametre)this.evenements.get(nomEvent)).getNomParametre().compareTo(valeur)==0))
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

    public int executerAction(String action) 
    {
    	if(this.evenements.containsKey(action))
    	{
    		this.evenements.get(action).executer(this);
    		return 1;
    	}
    	else
    	{
    		return 0;
    	}
    }
        
    public Object clone() 
    {
    	Composant res;
		try
		{
			res = (Composant) super.clone();
	    	HashMap <String, Propriete> resproprietes  = new HashMap<String, Propriete>();
	    	Iterator iterator = this.proprietes.entrySet().iterator();
	    	while (iterator.hasNext()) 
	    	{   	
	    		Map.Entry mapentry = (Map.Entry) iterator.next();
				Propriete propriete = (Propriete) mapentry.getValue();
				Propriete x = (Propriete)propriete.clone();
				resproprietes.put((String)mapentry.getKey(), x);
	    	} 
	    	res.setProprietes(resproprietes);
	    	return res;

		}
		catch (CloneNotSupportedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}		

		Composant other = (Composant) obj;

		Iterator iterator = this.proprietes.entrySet().iterator();
		Iterator iterator2 = other.getProprietes().entrySet().iterator();

		while (iterator.hasNext()) 
    	{  
    		Map.Entry mapentry = (Map.Entry) iterator.next();
    		Map.Entry mapentry2 = (Map.Entry) iterator2.next();
			
    		Propriete propriete = (Propriete) mapentry.getValue();
    		Propriete propriete2 = (Propriete) mapentry2.getValue();
    
    		if(!propriete.equals(propriete2))
    			{
    				return false;
    			}
    
    	} 
		
		return true;
	}

	public void gotoEtat(Composant c)
	{

		Iterator iterator = this.proprietes.entrySet().iterator();
		Iterator iterator2 = c.getProprietes().entrySet().iterator();

		while (iterator.hasNext()) 
    	{  
    		Map.Entry mapentry = (Map.Entry) iterator.next();
    		Map.Entry mapentry2 = (Map.Entry) iterator2.next();
			
    		Propriete propriete = (Propriete) mapentry.getValue();
    		Propriete propriete2 = (Propriete) mapentry2.getValue();
    		propriete.gotoEtat(propriete2);
    	} 
		
	}
	public void affichier()
	{
		System.out.println("--------------------------------------------"+nom+type);
		Set cles = proprietes.keySet();
		Iterator it = cles.iterator();
		while (it.hasNext()){
		   Object cle = it.next(); // tu peux typer plus finement ici
		   proprietes.get(cle).afficher();
		
		}
	
	}

}
