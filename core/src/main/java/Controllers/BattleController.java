package Controllers;

import Abilitys.AbilityManager;
import Board.Board;
import Board.Cell;
import Turns.TurnsManager;
import Unit.Unit;

public class BattleController {

	private Board board;
	private TurnsManager turn_manager;
	private BattleState battle_state = BattleState.INIT_TURN;

	private Cell cell_selected;//celda seleccionada que puede contener unidades o es para mover unidades
	private Unit unit_selected;//unidad seleccionada que puede mostrar estadisticas
	private Unit unit_turn;//unidad que puede mover y es el tope del turn manager
	
	public BattleController(Board board, TurnsManager turn_manager) {
		super();
		this.board = board;
		this.turn_manager = turn_manager;
	}
	public void initNextTurn() {
		clearUnitTurn();
		
		if(turn_manager.endQueue()) {
			turn_manager.buildQueue();
		}
		
		turn_manager.nextTurn();
		
		unit_turn = turn_manager.getUnitTurn();
		
		unit_selected = unit_turn;
		cell_selected = unit_turn.getCell();
		cell_selected.setSelected(true);
	}
	
	public void onCellCliked(Cell cell_clicked) {
		switch(battle_state){
			case INIT_TURN:
				
				if(canMove(cell_clicked)) {moveUnit(cell_clicked);return;}
					
				if(!cell_clicked.isOccupied()) return;
				
				if(cell_clicked.getUnit() != unit_selected) {
						unit_selected.setUnitSelected(false);
						unit_selected = cell_clicked.getUnit();
						unit_selected.setUnitSelected(true);
				}
				cell_selected.setSelected(false);
				cell_selected = cell_clicked;
				cell_clicked.setSelected(true);
				unit_selected = cell_clicked.getUnit();
				unit_selected.setUnitSelected(true);

				break;
			default:
		}
	}
	private void clearUnitTurn() {
		if(unit_turn != null) unit_turn.setUnitSelected(false);
		if(cell_selected != null) cell_selected.setSelected(false);
		
	}
	
	public void update() {
		//aca solo iria pequeñas cosas o directamente la ia para tomar decisiones
		if(AbilityManager.getAbilityInstance().getAbility_selected() != null) {
			battle_state = BattleState.HABILITY_SELECTED;
		}else {
			battle_state = BattleState.INIT_TURN;
			board.clearCellState();
		}
		
		if(battle_state == BattleState.HABILITY_SELECTED) {
			AbilityManager.getAbilityInstance().getAbility_selected().cellsAbilitySelected(board,turn_manager.getUnitTurn());
		}
	}
	
	private boolean canMove(Cell cell_clicked) {
		if(unit_turn == unit_selected && cell_selected == unit_turn.getCell() && cell_selected != cell_clicked && !cell_clicked.isOccupied()) {
			return true;
		}
		return false;
	}
	
	private void moveUnit(Cell cell_clicked) {
		board.moveUnit(unit_turn, cell_clicked.getRow_board(), cell_clicked.getCol_board());
		cell_selected.setSelected(false);
		cell_selected = cell_clicked;
		cell_selected.setSelected(true);
	}
	
	public Unit getUnit_selected() {
		return unit_selected;
	}

	public Unit getUnit_turn() {
		return unit_turn;
	}
	
	public BattleState getBattle_state() {
		return battle_state;
	}
	public void setBattle_state(BattleState battle_state) {
		this.battle_state = battle_state;
	}
}
