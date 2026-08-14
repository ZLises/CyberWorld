package Abilitys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import Controllers.BattleController;

public class ContentAbility extends Group{

	private int width,height;
	private Label label;
	private Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
	
	public ContentAbility(Ability ability,int width, int height, BattleController battle_controller) {
		super();
		this.width = width;
		this.height = height;
		
		label = new Label( ( (ability==null)? "HABILIDAD" : ability.getName() ),skin);
		label.setSize(width, height);
		this.addActor(label);
		
		this.addListener(new InputListener() {
			public boolean touchDown(InputEvent event,float x, float y,int pointer, int button) {
				battle_controller.onAbilityClicked(ability);
			 return true;
			}
		});
	}
	
	public int getWidthContent() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeightContent() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setLabel(String new_text) {
		label.setText(new_text);
	}

}
