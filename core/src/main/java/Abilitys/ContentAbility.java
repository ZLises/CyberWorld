package Abilitys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class ContentAbility extends Group{

	private int width,height;
	private Label label;
	private Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
	private Ability ability, ability_manager;

	public ContentAbility(Ability ability,int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.ability = ability;
		
		label = new Label( ( (ability==null)? "HABILIDAD" : ability.getName() ),skin);
		label.setSize(width, height);
		this.addActor(label);
		
		this.addListener(new InputListener() {
			public boolean touchDown(InputEvent event,float x, float y,int pointer, int button) {
				if(ability == null) return false;
				
				ability_manager = AbilityManager.getAbilityInstance().getAbility_selected();
				
				if(ability_manager == null) {
					ability.setSelected(true);
					AbilityManager.getAbilityInstance().setAbility_selected(ability);
					System.out.println("habilidad seleccionada :" + ability.getName());
					return true;
				}
				if(ability_manager == ability) {
					ability.setSelected(false);
					AbilityManager.getAbilityInstance().setAbility_selected(null);
					System.out.println("habilidad deseleccionada :" + ability.getName());
					return true;
				}
				if(ability_manager != ability) {
					ability_manager.setSelected(false);
				    ability.setSelected(true);
				    AbilityManager.getAbilityInstance().setAbility_selected(ability);
				    System.out.println("habilidad seleccionada :" + ability.getName());
				    return true;
				}

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
