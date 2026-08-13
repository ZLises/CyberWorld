package Abilitys.SetAbilitys;

import Abilitys.Ability;
import Board.Board;
import Unit.Unit;

public class HealthHeart extends Ability{
private int damage = 50;
	
	public HealthHeart() {
		this.name = "HelthHeart";
	}

	public void execute(Board board, Unit unit) {
		int pos_y_unit = unit.getCell().getRow_board();
		System.out.println(pos_y_unit);
		for(int i=(pos_y_unit+1);i<board.getRows();i++) {
			System.out.println("HEAL IN: X:" + unit.getCell().getCol_board() + "Y: " + i);
		}
	}
}
