package Turns;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Unit.Unit;

public class TurnsManager {
	private List<Unit> units = new ArrayList<>();
	private List<Unit> turn_queue = new ArrayList<>();
	private int index_turn = 0;
	private Unit unit_turn;

	public TurnsManager(List<Unit> units) {
		this.units = units;
		buildQueue(); //construye la cola de turnos
	}
	
	public void nextTurn(){//obtiene el siguiente turno
		unit_turn = turn_queue.get(index_turn);
		
		index_turn++;
	}
	//tambien hay otro endqueue que es cuando los enemigos/aliados ya no estan en la lista end()
	//osea en cada nextTurn hay que verificar si hay almenos un aliado o un enemigo en la lista para continuar si no termina
	//la batalla
	public boolean endQueue() { 
		if(index_turn == turn_queue.size()) {
			index_turn = 0;
			return true;
		}
		return false;
	}
	
	public Unit getUnitTurn() {//obtiene la unidad de turno
		return unit_turn;
	}
	
	public void buildQueue() {//sirve para actualizar la lista de unidades vivas y ponerlas en cola turno

		turn_queue.clear();
		for(Unit unit: units) {
			if(unit.isAlive()) {
				turn_queue.add(unit);
			}
		}
		
		turn_queue.sort(Comparator.comparingDouble(Unit::getVelocity).reversed());
	}
	public List<Unit> getTurnQueue(){//devuelve la cola de turnos
		return turn_queue;
	}
	
	public boolean isEmpty() {
		return turn_queue.isEmpty();//retorna true cuando esta vacio
	}
}
