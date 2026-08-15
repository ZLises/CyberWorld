package Abilitys;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import Board.Board;
import Board.Cell;
import Unit.Unit;

public abstract class Ability {
   protected String name;
   private boolean ability_selected;
   private float duration,elapsed;
   private Animation<TextureRegion> animation;
   
   public void execute(Board board, Unit unit) {}
   
   public List<Cell> cellsAbilitySelected(Board board, Unit unit) {
	   List<Cell> lista = new ArrayList<>();
		return lista;
   }

   public boolean isAbility_selected() {
	return ability_selected;
   }

   public void setSelected(boolean ability_selected) {
	this.ability_selected = ability_selected;
   }

   public String getName() {
	return name;
   }

   public void setName(String name) {
	this.name = name;
   }

   public float getDuration() {
	return duration;
   }

   public void setDuration(float duration) {
	this.duration = duration;
   }

   public Animation<TextureRegion> getAnimation() {
	return animation;
   }

   public void setAnimation(Animation<TextureRegion> animation) {
	this.animation = animation;
   }

   public abstract void update(float delta);

   public abstract boolean isFinished();

   public abstract void render(SpriteBatch batch, Unit unit_selected, Board board);

   public float getElapsed() {
	 return elapsed;
   }

   public void setElapsed(float elapsed) {
     this.elapsed = elapsed;
   }
	   
}
