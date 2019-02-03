
public class Propriete
{
	private String nom;
	private String valeur;
	private TypePropriete type;

	public Propriete(String nom, String valeur, TypePropriete type)
	{
		this.nom = nom;
		this.valeur = valeur;
		this.type = type;
	}

	public Propriete(String nom, TypePropriete type)
	{
		this.nom = nom;
		this.type = type;
	}

	public int setValeur(String valeur)
	{
		if(this.type.compatible(valeur))
		{
			this.valeur = valeur; 
			return 1;
		}
		else
		{
			return -1;
		}
	}

	public boolean compatible(String valeur)
	{
		return this.type.compatible(valeur);
	}

	public void afficher()
	{
		System.out.println("nom : " + this.nom + " Type" + this.type.getClass() + "Valeur " + this.valeur);
		if(this.type.getClass() == EnumType.class)
		{
			((EnumType)this.type).afficher();
		}
	}

}
