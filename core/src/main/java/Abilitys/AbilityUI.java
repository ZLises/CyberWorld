package Abilitys;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import Controllers.BattleController;

public class AbilityUI extends Table{

	private List<ContentAbility> list_content_ability = new ArrayList<>();
	private Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
	private TextButton button_execute_ability = new TextButton("Execute",skin);
	private BattleController battle_controller;
	
	public AbilityUI(BattleController battle_controller) {
		super();
		this.battle_controller = battle_controller;
		initButtonExecute();
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
			
			content = new ContentAbility( ability,120,30,battle_controller);
			
			list_content_ability.add(content);
			this.add(content).width(content.getWidthContent()).height(content.getHeightContent()).padRight(10);
		}
		this.row();
		this.add(button_execute_ability).width(120).height(40).padLeft(20);
	}
	private void initButtonExecute() {

		button_execute_ability.addListener(new ClickListener() {
			public void clicked(InputEvent e,float x,float y) {
				battle_controller.executeAbility();
			}
		});
		
	}
	
	
}
