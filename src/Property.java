
public class Property
{
	private String nom;
	private String valeur;
	private PropertyType type;

	public Property(String nom, String valeur, PropertyType type)
	{
		this.nom = nom;
		this.valeur = valeur;
		this.type = type;
	}

	public Property(String nom, PropertyType type)
	{
		this.nom = nom;
		this.type = type;
	}

	public void afficher()
	{
		System.out.println("nom : " + this.nom + " Type" + this.type.getClass());
		if(this.type.getClass() == EnumType.class)
		{
			((EnumType)this.type).afficher();
		}
	}
}
