package Turns;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

import Unit.Unit;

public class TurnsRenderer extends Table{

	private TurnsManager turns_manager;
	private TurnContentBlock content_block;
	
	
	public TurnsRenderer(TurnsManager turns_manager) {
		this.turns_manager = turns_manager;
		
		turns_manager.buildQueue();
		this.setDebug(false);
	}
	
	public void buildTurns() {
		this.clearChildren();
		for(Unit unit : turns_manager.getTurnQueue()) {
		   content_block = new TurnContentBlock(unit,120,40, ( unit==turns_manager.getCurrentTurn() ? true:false) );
		   this.add(content_block.getLabel()).width(content_block.getWidthContent()).height(content_block.getHeightContent()).pad(5).row();
		}
	}
}
