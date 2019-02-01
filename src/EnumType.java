import java.util.ArrayList;

public class EnumType extends PropertyType
{

	private ArrayList<String> valeursPossibles = new ArrayList<String>();

	public EnumType(ArrayList<String> valeursPossibles)
	{
		this.valeursPossibles = valeursPossibles;
	}
	
	
	@Override
	public boolean isCompatible(String valeur)
	{
		boolean trouv=false;
		int i=0;
		while(!trouv && i<this.valeursPossibles.size() )
		{
			if(this.valeursPossibles.get(i).toLowerCase() == valeur.toLowerCase()) 
			{
				trouv = true;
			}
			i++;
		}
		return trouv;
	}

	public void afficher()
	{
		System.out.println("Affichage de la liste des valeurs possibles :");
		for (int i=0; i<valeursPossibles.size(); i++)
		{
			System.out.println(valeursPossibles.get(i));
		}
			
	}
}
