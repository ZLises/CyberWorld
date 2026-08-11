package Turns;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import Unit.Unit;

public class TurnsManager {
	private List<Unit> units = new ArrayList<>();
	private List<Unit> turn_queue = new ArrayList<>();

	public TurnsManager(List<Unit> units) {
		this.units = units;
		//buildQueue(units);
	}
	
	public Unit getTurn() {
		return turn_queue.remove(0);
	}
	public Unit getCurrentTurn() {
		return turn_queue.get(0);
	}
	
	public void buildQueue() {

		turn_queue.clear();
		for(Unit unit: units) {
			if(unit.isAlive()) {
				turn_queue.add(unit);
			}
		}
		turn_queue.sort(Comparator.comparingDouble(Unit::getVelocity).reversed());
	}
	public List<Unit> getTurnQueue(){
		return turn_queue;
	}
	
	public boolean isEmpty() {
		return turn_queue.isEmpty();//retorna true cuando esta vacio
	}
}
