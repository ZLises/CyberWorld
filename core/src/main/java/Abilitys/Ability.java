package Abilitys;

import Board.Board;
import Unit.Unit;

public abstract class Ability {
   protected String name;
   private boolean ability_selected;
   
   public void execute(Board board, Unit unit) {}
   
   public void cellsAbilitySelected(Board board, Unit unit) {}

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
   };
	   
   
}
