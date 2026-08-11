package Board;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

import Controllers.GameController;
import Unit.Unit;

public class BoardInput extends InputAdapter{

	private Board board;
	
	private int pos_x, pos_y;
	private GameController game_controller;
	
	public BoardInput(Board board, GameController game_controller) {
		this.board = board;
		this.game_controller = game_controller;
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

		
		game_controller.onCellCliked(board.getCellClicked(pos_x, pos_y));
		return true; 
	}
	
	
}
