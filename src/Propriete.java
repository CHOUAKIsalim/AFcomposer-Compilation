import java.util.Iterator;
import java.util.Map;

public class Propriete implements Cloneable
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

	public String getValeur()
	{
		return this.valeur;
	}

	public String getNom()
	{
		return this.nom;
	}

	public int setValeur(String valeur)
	{
		if (this.type.compatible(valeur))
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

	public Object clone()
	{
		Propriete res = null;
		try
		{
			res = (Propriete) super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}

		Propriete other = (Propriete) obj;

		if ((this.getValeur() == null && other.getValeur() == null) || this.getValeur().compareTo(other.getValeur()) == 0)
		{
			System.out.println("good ! " +this.nom+"  "+ other.getValeur() + "  "+this.getValeur());

			return true;
		}
		else
		{
			System.out.println("walou ! ");
			return false;
		}
	}

	public void gotoEtat(Propriete p)
	{
		this.valeur = p.getValeur();
	}
	
	public void afficher()
	{
		System.out.println("Propriete");

		System.out.println("nom : " + this.nom  +"&&   valeur :  "+this.valeur);
	}
}
