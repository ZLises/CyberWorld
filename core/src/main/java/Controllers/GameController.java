package Controllers;

import Board.Board;
import Board.Cell;
import Turns.TurnsManager;

public class GameController {

	private Board board;
	private TurnsManager turn_manager;
	private Cell cell_clicked;
	
	public GameController(Board board, TurnsManager turn_manager) {
		super();
		this.board = board;
		this.turn_manager = turn_manager;
	}
	
	public void onCellCliked(Cell cell_clicked) {
		//aca va la logica
		this.cell_clicked = cell_clicked;
	}
	
	public void update() {
		//aca solo iria pequeñas cosas o directamente la ia para tomar decisiones
	}
	
}
