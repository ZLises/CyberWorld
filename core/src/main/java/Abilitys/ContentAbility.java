package Abilitys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class ContentAbility{

	private int width,height;
	private Label label;
	private Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));

	public ContentAbility(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		
		label = new Label("HABILIDAD",skin);
		label.setSize(width, height);
	}
	public Label getLabel() {
		return label;
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
	
}
