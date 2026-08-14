package Abilitys.SetAbilitys;

import java.util.ArrayList;
import java.util.List;

import Abilitys.Ability;
import Board.Board;
import Board.Cell;
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
	public List<Cell> cellsAbilitySelected(Board board, Unit unit) {
		List<Cell> list = new ArrayList<>();
		int pos_y_unit = unit.getCell().getRow_board();
		for(int i=(pos_y_unit+1);i<board.getRows();i++) {
			list.add(board.getCell(i,unit.getCell().getCol_board()));
		}
		return list;
	}
}
