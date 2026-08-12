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
		buildAbilityUI();
	}
	private void buildAbilityUI() {
		for(int i=0;i<4;i++) {
			ContentAbility content = new ContentAbility(120,30);
			list_content_ability.add(content);
			this.add(content.getLabel()).width(content.getWidthContent()).height(content.getHeightContent()).padRight(10);
		}
	}
	
	
}
