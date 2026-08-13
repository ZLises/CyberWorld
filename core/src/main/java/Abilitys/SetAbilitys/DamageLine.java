package Abilitys.SetAbilitys;

import Abilitys.Ability;
import Board.Board;
import Board.CellState;
import Unit.Unit;

public class DamageLine extends Ability{

	private int damage = 50;
	
	public DamageLine() {
		this.name = "DamageLine";
	}

	public void execute(Board board, Unit unit) {
		int pos_y_unit = unit.getCell().getRow_board();
		for(int i=(pos_y_unit+1);i<board.getRows();i++) {
			System.out.println("DAMAGE IN: X:" + unit.getCell().getCol_board() + "Y: " + i);
		}
	}
	public void cellsAbilitySelected(Board board, Unit unit) {
		int pos_y_unit = unit.getCell().getRow_board();
		for(int i=(pos_y_unit+1);i<board.getRows();i++) {
			board.getCell(i,unit.getCell().getCol_board()).setCell_state(CellState.ABILITY_SELECTED);
		}
	}
}
