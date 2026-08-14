package Turns;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import Unit.Unit;

public class TurnContentBlock extends Group{

	private Unit unit;
	private int width,height;
	private boolean turn = false;
	private Label label;
	private Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
	
	public TurnContentBlock(Unit unit, int width, int height,boolean turn) {
		super();
		this.setUnit(unit);
		this.width = width;
		this.height = height;
		this.turn = turn;
		
		label = new Label("UNIT: " + unit.getName() + ( (turn == true) ? " TURNO" : "" ),skin);
		label.setSize(width, height);
		this.addActor(label);
	}
	
	public void changeLabel(boolean new_state) {
		turn = new_state;
		label.setText( "UNIT: " + unit.getName() + ( (turn) ? " TURNO" : "" ) );
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
	
	public Unit getUnit() {
		return unit;
	}
	
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
	
	
}
