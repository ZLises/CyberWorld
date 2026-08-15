package Abilitys.SetAbilitys;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import Abilitys.Ability;
import Board.Board;
import Board.Cell;
import Unit.Unit;
import Utils.Assets;

public class HealthHeart extends Ability{
	
	private TextureAtlas atlas;
	private Array<TextureAtlas.AtlasRegion> frames = new Array<>();
	private Animation<TextureRegion> health_animation;
	private float duration=3f,elapsed;
	
	public HealthHeart() {
		this.name = "HelthHeart";
		
		atlas = Assets.manager_asset.get("ability/health.atlas", TextureAtlas.class);
		
		frames.add(atlas.findRegion("tile33"));
		frames.add(atlas.findRegion("tile34"));
		frames.add(atlas.findRegion("tile35"));
		frames.add(atlas.findRegion("tile36"));
		frames.add(atlas.findRegion("tile37"));
		frames.add(atlas.findRegion("tile38"));
		frames.add(atlas.findRegion("tile39"));
		frames.add(atlas.findRegion("tile40"));
		frames.add(atlas.findRegion("tile41"));
		frames.add(atlas.findRegion("tile42"));
		frames.add(atlas.findRegion("tile43"));
		
		health_animation = new Animation<>(0.1f,frames,Animation.PlayMode.LOOP);
	}

	public void execute(Board board, Unit unit) {//hace el daño, cura etc
		
	}
	
	public List<Cell> cellsAbilitySelected(Board board, Unit unit) {
		List<Cell> list = new ArrayList<>();
		
		
		int pos_y_unit = unit.getCell().getCol_board();
		int pos_x_unit = unit.getCell().getRow_board();
		
		Cell cell = board.getCell(pos_x_unit, (pos_y_unit + 1));
		if(cell != null){
			list.add(cell);
		}
		
		Cell cell1 = board.getCell(pos_x_unit, (pos_y_unit - 1));
		if(cell1!=null) {
			list.add(cell1);
		}
		
		Cell cell2 = board.getCell( (pos_x_unit + 1),  (pos_y_unit));
		if(cell2!=null) {
			list.add(cell2);
		}
		Cell cell3 = board.getCell( (pos_x_unit - 1), (pos_y_unit));
		if(cell3!=null) {
			list.add(cell3);
		}
		
		return list;
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		elapsed += delta;
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		if(elapsed>duration) {
			elapsed = 0f;
			return true;
		}
		return false;
	}

	@Override
	public void render(SpriteBatch batch, Unit unit_selected, Board board) {
		// TODO Auto-generated method stub
		TextureRegion current_frame = health_animation.getKeyFrame(elapsed);
		for(Cell cell : cellsAbilitySelected( board, unit_selected)) {
			batch.draw(current_frame,cell.getPos_x_cell(),cell.getPos_y_cell(),64,64);
		}
	}
}
