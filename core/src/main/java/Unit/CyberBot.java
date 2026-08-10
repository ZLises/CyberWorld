package Unit;

import Board.Cell;

public class CyberBot extends Unit{
	private CyberBot(Builder builder) {
		this.velocity = builder.velocity;
		this.atack = builder.atack;
		this.armor = builder.armor;
		this.name = builder.name;
	}
	
	public static class Builder{
		private int velocity,atack,armor;
		private String name;
		
		
		public Builder velocity(int velocity) {
			this.velocity = velocity;
			return this;
		}
		public Builder atack(int atack) {
			this.atack = atack;
			return this;
		}
		public Builder armor(int armor) {
			this.armor = armor;
			return this;
		}
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public CyberBot build() {
			return new CyberBot(this);
		}
	}
	
	public Cell getCell() {
		return cell;
	}

	public void setCell(Cell cell) {
		this.cell = cell;
	}
}
