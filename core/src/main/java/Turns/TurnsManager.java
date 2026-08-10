package Turns;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import Unit.Unit;

public class TurnsManager {
	private PriorityQueue<Unit> turn_queue = new PriorityQueue<>(Comparator.comparingDouble(Unit::getVelocity).reversed());

	public TurnsManager(List<Unit> units) {
		buildQueue(units);
	}
	
	public Unit getTurn() {
		return turn_queue.poll();
	}
	
	public Unit getFirstUnit() {
		return turn_queue.peek();
	}

	public void buildQueue(List<Unit> all_units) {
		turn_queue.clear();
		for(Unit unit: all_units) {
			if(unit.isAlive()) {
				turn_queue.add(unit);
			}
		}
	}
	
	public boolean isEmpty() {
		return turn_queue.isEmpty();//retorna true cuando esta vacio
	}
}
