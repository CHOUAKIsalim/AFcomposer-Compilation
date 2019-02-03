
public class ConditionEvenementParametre extends ConditionEvenement
{

	private String nomParametre;
	public ConditionEvenementParametre(String nom, Propriete proprieteCondition, String valeurCondition, String typeCondition, String nomParametre)
	{
		super(nom, proprieteCondition, valeurCondition, typeCondition);
		this.nomParametre = nomParametre;
	}

	public String getNomParametre()
	{
		return this.nomParametre;
	}
}
