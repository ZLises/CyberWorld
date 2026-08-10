package Board;

import java.util.ArrayList;
import java.util.List;

import Unit.Unit;

public class Board {
	private int rows,cols,size_cell;
	private Cell[][] board;
	private List<Unit> units = new ArrayList<>();
	private int pos_x_board, pos_y_board,width_board,height_board;

	public Board(int rows, int cols, int size_cell, int pos_x_board, int pos_y_board) {
		super();
		this.rows = rows;
		this.cols = cols;
		this.size_cell = size_cell;
		this.pos_x_board = pos_x_board;
		this.pos_y_board = pos_y_board;
		
		initBoard( pos_x_board,  pos_y_board, rows, cols, size_cell);
	}

	private void initBoard(int pos_x, int pos_y,int rows,int cols,int size_cell) {
		board = new Cell[rows][cols];
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				board[i][j] = new Cell(i,j);
				board[i][j].setPosCell(size_cell,i,j,pos_x,pos_y);//el 5 es el padding
			}
		}
		width_board = size_cell*cols;
		height_board = size_cell*rows;
	}
	
	public void moveUnit(Unit unit,int new_row, int new_col) {
		
		Cell new_celd = board[new_row][new_col];
		Cell old_cell = unit.getCell();
		
		if(new_celd.isOccupied()) {
			swapUnits(new_celd.getUnit(), old_cell.getUnit());
			return;
		}
		
		unit.setCell(board[new_row][new_col]);
		new_celd.setCyberBot(unit);
		
		old_cell.deleteCyberBot();
	}
	
	public void swapUnits(Unit unit, Unit unit2) {
		
		if(unit.getCell() == null  || unit2.getCell() == null) return;
		
		Cell cell_1 = unit.getCell();
		Cell cell_2 = unit2.getCell();
		
		unit.setCell(cell_2);
		cell_2.setCyberBot(unit);
		
		unit2.setCell(cell_1);
		cell_1.setCyberBot(unit2);
	}

	public void addUnit(Unit unit, int row, int col) {
		
		Cell cell = board[row][col];
		
		if(cell.isOccupied()) return;
		
		cell.setCyberBot(unit);
		
		unit.setCell(cell);
		
		units.add(unit);
	}
	public Cell getCellClicked(int pos_x, int pos_y) {
		int col = (pos_x - this.pos_x_board) / size_cell;
		int row = (pos_y - this.pos_y_board) / size_cell;
		
		if(col>=cols || row >=rows || col<0 || row < 0) return null;
		
		return board[row][col];
	}
	
	public Cell getCell(int pos_x, int pos_y) {
		return board[pos_x][pos_y];
	}
	
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public int getSize_cell() {
		return size_cell;
	}

	public void setSize_cell(int size_cell) {
		this.size_cell = size_cell;
	}

	public int getPos_x_board() {
		return pos_x_board;
	}

	public void setPos_x_board(int pos_x_board) {
		this.pos_x_board = pos_x_board;
	}

	public int getPos_y_board() {
		return pos_y_board;
	}

	public void setPos_y_board(int pos_y_board) {
		this.pos_y_board = pos_y_board;
	}

	public int getWidth_board() {
		return width_board;
	}

	public void setWidth_board(int width_board) {
		this.width_board = width_board;
	}

	public int getHeight_board() {
		return height_board;
	}

	public void setHeight_board(int height_board) {
		this.height_board = height_board;
	}
	
}
