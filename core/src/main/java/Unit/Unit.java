package Unit;

import Board.Cell;

public abstract class Unit {
	protected int health=100,atack,armor,velocity;
	protected String name;
	protected Cell cell;
	
	public boolean isAlive() {
		return (health>0);
	}
	
	public Cell getCell() {
		return cell;
	}
	public void setCell(Cell cell) {
		this.cell = cell;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getAtack() {
		return atack;
	}
	public void setAtack(int atack) {
		this.atack = atack;
	}
	public int getArmor() {
		return armor;
	}
	public void setArmor(int armor) {
		this.armor = armor;
	}
	public int getVelocity() {
		return velocity;
	}
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
