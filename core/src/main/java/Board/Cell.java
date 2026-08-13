package Board;

import Unit.Unit;

public class Cell {
	private int row_board,col_board;
	private boolean occuiped = false;
	private Unit unit;
	private boolean selected = false;
	private CellState cell_state = CellState.NORMAL;
    
	private int pos_x_cell, pos_y_cell,size_cell;

	public Cell(int row_board, int col_board) {
		super();
		this.row_board = row_board;
		this.col_board = col_board;
	}
	
	public void setPosCell(int size,int n_row, int n_col, int pos_x, int pos_y) {
		pos_x_cell = (size*n_col) + pos_x;
		pos_y_cell = (size*n_row) + pos_y;

		setSize_cell(size);
	}
	
	public int getPos_x_cell() {
		return pos_x_cell;
	}

	public void setPos_x_cell(int pos_x_cell) {
		this.pos_x_cell = pos_x_cell;
	}

	public int getPos_y_cell() {
		return pos_y_cell;
	}

	public void setPos_y_cell(int pos_y_cell) {
		this.pos_y_cell = pos_y_cell;
	}

	public void setCyberBot(Unit unit) {
		this.unit = unit;
		occuiped = true;
	}
	
	public void deleteCyberBot() {
		this.unit = null;
		occuiped = false;
	}
	
	
	public boolean isOccupied() {
		return occuiped;
	}
	
	public Unit getUnit() {
		return unit;
	}

	public int getRow_board() {
		return row_board;
	}

	public void setRow_board(int row_board) {
		this.row_board = row_board;
	}

	public int getCol_board() {
		return col_board;
	}

	public void setCol_board(int col_board) {
		this.col_board = col_board;
	}

	public int getSize_cell() {
		return size_cell;
	}

	public void setSize_cell(int size_cell) {
		this.size_cell = size_cell;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public CellState getCell_state() {
		return cell_state;
	}

	public void setCell_state(CellState cell_state) {
		this.cell_state = cell_state;
	}
}
