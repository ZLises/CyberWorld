package Turns;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

import Unit.Unit;

public class TurnsUI extends Table{

	private TurnsManager turns_manager;
	private TurnContentBlock content_block;
	private List<TurnContentBlock> all_content = new ArrayList<>();
	
	public TurnsUI(TurnsManager turns_manager) {
		this.turns_manager = turns_manager;

		this.setDebug(true);
	}
	
	public void rendererTurns() {
		this.clearChildren();
		for(Unit unit : turns_manager.getTurnQueue()) {
		   content_block = new TurnContentBlock(unit,120,40, ( unit==turns_manager.getUnitTurn()) );
		   all_content.add(content_block);
		   this.add(content_block.getLabel()).width(content_block.getWidthContent()).height(content_block.getHeightContent()).pad(5).row();
		}
	}
	public void updateTurnsLabel() {//por ahora label porque es una etiqueta mas adelante se va a llamar distinto
		for(TurnContentBlock content: all_content) {
			if(content.getUnit() == turns_manager.getUnitTurn()) {
				content.changeLabel(true);
			}else {
				content.changeLabel(false);
			}
		}
	}
}
