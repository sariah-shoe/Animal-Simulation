package hw3;

import edu.du.dudraw.Draw;

public class Water extends TerrainTile{
	
	// Constructor for water class
	public Water(GridPoint location) {
		super(location);
		// Water never has vegetation and is always 100% wet. Water can be choppy so it can have a bumpiness from 0-100%
		this.vegetation = 0;
		this.wet = 100;
		this.bumpy = (int)Math.floor(Math.random() * (100 - 0 + 1) + 0);
	}
	
	// Draws the tile on the given Window
	public void draw(Draw duDwin) {
		super.draw(duDwin);
	}
	
	// Part of the draw template for concrete tiles to set the color
	public void setColor(Draw duDwin) {
		duDwin.setPenColor(0, 100, 255);
	}
	
	// String representation
	public String toString() {
		return("w");
	}


}
