package Abilitys;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

import Unit.Unit;

public class AbilityUI extends Table{

	//setear habilidades en contentability
	private List<ContentAbility> list_content_ability = new ArrayList<>();

	public AbilityUI() {
		super();
	}
	public void buildAbilityUI(List<Ability> list_ability) {
		Ability ability;
		ContentAbility content;
		this.clearChildren();
		
		for(int i=0;i<4;i++) {
			ability = null;
			
			if(list_ability != null && i < list_ability.size()) {
				ability =list_ability.get(i);
			}
			
			content = new ContentAbility( ability,120,30 );
			
			list_content_ability.add(content);
			this.add(content).width(content.getWidthContent()).height(content.getHeightContent()).padRight(10);
		}
	}
	
	
}
