package Board;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

import Unit.Unit;

public class BoardInput extends InputAdapter{

	private Board board;
	private Unit unit_selected;
	private Cell cell_selected;
	
	private int pos_x, pos_y;
	
	public BoardInput(Board board) {
		this.board = board;
	}
	
	@Override
	public boolean touchDown(int screenX,
							int screenY,
							int pointer,
							int button) {
		
		pos_x = screenX;
		pos_y = (Gdx.graphics.getHeight() - screenY);

		
		//primero verificar que clikeo dentro del tablero
		if( !(board.getPos_x_board() < pos_x && (board.getWidth_board()+board.getPos_x_board()) > pos_x &&
				board.getPos_y_board() < pos_y && (board.getHeight_board()+board.getPos_y_board()) > pos_y) ) {
			return true;
		}
		
		cell_selected = board.getCellClicked(pos_x, pos_y);
		if(cell_selected!=null) cell_selected.setSelected(true);

		return true;
	}
	
	
}
