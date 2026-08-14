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
import Controllers.UnitSelectedListener;
import Unit.Unit;

public class AbilityUI extends Table implements UnitSelectedListener{

	private List<ContentAbility> list_content_ability = new ArrayList<>();
	private Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
	private TextButton button_execute_ability = new TextButton("Execute",skin);
	private BattleController battle_controller;
	
	public AbilityUI(BattleController battle_controller) {
		super();
		this.battle_controller = battle_controller;
		battle_controller.addUnitSelectedListener(this);
		initButtonExecute();
		buildAbilityUI();
		setDebug(true);
	}
	
	private void buildAbilityUI() {
		ContentAbility content;
		this.clearChildren();
		
		for(int i=0;i<4;i++) {
			
			content = new ContentAbility( null ,120,30,battle_controller);
			
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
	
	private void setAbilityContent(List<Ability> list_ability) {
		Ability ability;
		
		for(ContentAbility content: list_content_ability) {
			content.setAbility(null);
		}
		
		for(int i=0;i<4;i++) {
			ability = null;
			
			if(list_ability != null && i < list_ability.size()) {
				ability =list_ability.get(i);
				list_content_ability.get(i).setLabel(list_ability.get(i).getName());
			}else {
				list_content_ability.get(i).setLabel("HABILIDAD");
			}
			list_content_ability.get(i).setAbility(ability);
			
		}
	}

	@Override
	public void onUnitSelected(Unit unit) {
		// TODO Auto-generated method stub
		setAbilityContent(battle_controller.getUnit_selected().getList_ability());
	}
	
	
}
