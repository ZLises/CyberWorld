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

public class DamageLine extends Ability{

	private TextureAtlas atlas;
	private Array<TextureAtlas.AtlasRegion> frames = new Array<>();
	private Animation<TextureRegion> rayo_animation;
	private float duration=1f,elapsed;
	
	public DamageLine() {
		this.name = "DamageLine";
		atlas = Assets.manager_asset.get("ability/rayo.atlas", TextureAtlas.class);

		frames.add(atlas.findRegion("rayo001"));
		frames.add(atlas.findRegion("rayo002"));
		frames.add(atlas.findRegion("rayo003"));
		frames.add(atlas.findRegion("rayo004"));
		frames.add(atlas.findRegion("rayo005"));
		frames.add(atlas.findRegion("rayo006"));
		frames.add(atlas.findRegion("rayo007"));
		frames.add(atlas.findRegion("rayo008"));
		frames.add(atlas.findRegion("rayo009"));
		frames.add(atlas.findRegion("rayo010"));
		frames.add(atlas.findRegion("rayo011"));
		frames.add(atlas.findRegion("rayo012"));
		frames.add(atlas.findRegion("rayo013"));
		
		rayo_animation = new Animation<>(0.1f,frames,Animation.PlayMode.LOOP);
	}
	

	public void execute(Board board, Unit unit) {
		int pos_y_unit = unit.getCell().getRow_board();
		for(int i=(pos_y_unit+1);i<board.getRows();i++) {
			//System.out.println("DAMAGE IN: X:" + unit.getCell().getCol_board() + "Y: " + i);
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
	@Override
	public Animation<TextureRegion> getAnimation() {
		return rayo_animation;
	}

	public void setRayo_animation(Animation<TextureRegion> rayo_animation) {
		this.rayo_animation = rayo_animation;
	}
	
	public void render(SpriteBatch batch, Unit unit, Board board) {
		TextureRegion current_frame = rayo_animation.getKeyFrame(elapsed);
		
		batch.draw(current_frame,unit.getCell().getPos_x_cell() - 32,unit.getCell().getPos_y_cell()+32,120,board.getHeight_board()-32);
	}

	public void update(float delta) {
		elapsed += delta;
	}

	public boolean isFinished() {
		if(elapsed>duration) {
			elapsed = 0f;
			return true;
		}
		return false;
	}
	
}
