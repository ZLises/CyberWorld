package Abilitys;

public class AbilityManager {
	private final static AbilityManager ability_instance = new AbilityManager();
	
	private Ability ability_selected = null;
	
	private AbilityManager() {}

	public static AbilityManager getAbilityInstance() {
		return ability_instance;
	}
	
	public void setAbility_selected(Ability ability) {
		ability_selected = ability;
	}
	
	public Ability getAbility_selected() {
		return ability_selected;
	}
}
