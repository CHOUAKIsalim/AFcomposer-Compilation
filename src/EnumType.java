import java.util.ArrayList;

public class EnumType extends TypePropriete
{

	private ArrayList<String> valeursPossibles = new ArrayList<String>();

	public EnumType(ArrayList<String> valeursPossibles)
	{
		this.valeursPossibles = valeursPossibles;
	}
	
	
	@Override
	public boolean compatible(String valeur)
	{
		boolean trouv=false;
		int i=0;
		while(!trouv && i<this.valeursPossibles.size() )
		{
			if(this.valeursPossibles.get(i).toLowerCase().compareTo(valeur.toLowerCase())==0) 
			{
				trouv = true;
			}
			i++;
		}
		return trouv;
	}
}
