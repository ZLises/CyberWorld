package Turns;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

import Controllers.BattleController;
import Controllers.NextTurnListener;
import Unit.Unit;

public class TurnsUI extends Table implements NextTurnListener{

	private TurnsManager turns_manager;
	private TurnContentBlock content_block;
	private List<TurnContentBlock> all_content = new ArrayList<>();
	
	public TurnsUI(TurnsManager turns_manager, BattleController battle_controller) {
		this.turns_manager = turns_manager;

		battle_controller.addNextTurnListener(this);
		
		this.setDebug(true);
	}
	
	public void rendererTurns() {
		this.clearChildren();
		for(Unit unit : turns_manager.getTurnQueue()) {
		   content_block = new TurnContentBlock(unit,120,40, ( unit==turns_manager.getUnitTurn()) );
		   all_content.add(content_block);
		   this.add(content_block).width(content_block.getWidthContent()).height(content_block.getHeightContent()).pad(5).row();
		}
	}
	private void updateTurnsLabel() {//por ahora label porque es una etiqueta mas adelante se va a llamar distinto
		for(TurnContentBlock content: all_content) {
			if(content.getUnit() == turns_manager.getUnitTurn()) {
				content.changeLabel(true);
			}else {
				content.changeLabel(false);
			}
		}
	}

	@Override
	public void onUnitNextTurn(Unit unit) {
		// TODO Auto-generated method stub
		updateTurnsLabel();
	}
}
