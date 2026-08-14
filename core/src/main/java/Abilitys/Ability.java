package Abilitys;

import java.util.ArrayList;
import java.util.List;

import Board.Board;
import Board.Cell;
import Unit.Unit;

public abstract class Ability {
   protected String name;
   private boolean ability_selected;
   
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
   };
	   
   
}
