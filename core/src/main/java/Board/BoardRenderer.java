package Board;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Controllers.BattleController;
import Unit.Unit;
import Utils.Assets;

public class BoardRenderer {

	private Board board;
	private Texture img_cell,img_unit,img_cell_ability;

	private Cell cell_draw;
	private Unit unit;
	private BitmapFont bit_font = new BitmapFont();
	private BattleController battle_controller;
	
	public BoardRenderer(Board board, BattleController battle_controller) {
		this.board = board;
		this.battle_controller = battle_controller;
		
		img_cell = Assets.manager_asset.get("images/img_cell.png",Texture.class);
		img_cell_ability = Assets.manager_asset.get("images/img_cell_ability.png",Texture.class);
		img_unit = Assets.manager_asset.get("images/img_unit.png",Texture.class);
	}
	private void mapBoard(SpriteBatch batch) {
		
		for(int i=0;i<board.getRows();i++) {
			for(int j=0;j<board.getCols();j++) {
				cell_draw = board.getCell(i, j);
				if(cell_draw.getCell_state() == CellState.ABILITY_SELECTED) {
					batch.draw(img_cell_ability, cell_draw.getPos_x_cell(), cell_draw.getPos_y_cell(),cell_draw.getSize_cell(),cell_draw.getSize_cell());
				}else {
					batch.draw(img_cell, cell_draw.getPos_x_cell(), cell_draw.getPos_y_cell(),cell_draw.getSize_cell(),cell_draw.getSize_cell());
				}

			    if(cell_draw.isOccupied()) {
			    	//unit draw
			    	//batch.draw(img_unit, cell_draw.getPos_x_cell() + 16, cell_draw.getPos_y_cell() + 16,32,32);
			    	unit = cell_draw.getUnit();
			    	bit_font.draw(batch, unit.getName(),cell_draw.getPos_x_cell()+16,cell_draw.getPos_y_cell()+32);
			    }
			    if(cell_draw.isSelected()) {
			    	batch.draw(img_unit, cell_draw.getPos_x_cell() + 16, cell_draw.getPos_y_cell() + 16,32,32);
			    }
			}
		}
		
	}
	
	public void render(SpriteBatch batch,float delta) {
		//boardInput.update();
		mapBoard(batch);
	}
}
