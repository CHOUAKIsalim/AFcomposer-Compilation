import java.util.ArrayList;

public abstract class Evenement
{
	private String 	nom;
	private ArrayList<Operation> operations= new ArrayList<Operation>();
	
	public Evenement(String nom)
	{
		this.nom = nom;
	}
	
	public void ajouterAffectation(Propriete variable,String valeur)
	{
		this.operations.add(new Affectation(variable, valeur));
	}

	public void ajouterIncrementationNombre(Propriete variable,String valeur)
	{
		this.operations.add(new IncrementationNombre(variable, valeur));
	}
	
	public void ajouterIncrementationString(Propriete variable, String valeur)
	{
		this.operations.add(new IncrementationString(variable, valeur));		
	}

	protected void executerOperations(Composant c)
	{
		for(int i=0; i<operations.size(); i++)
		{
			this.operations.get(i).executer(c);
		}
	}
	
	public abstract void executer(Composant c);
		
	
}
