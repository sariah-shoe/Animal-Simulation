package hw3;

import edu.du.dudraw.Draw;

public class Grass extends TerrainTile{

	// Constructor
	public Grass(GridPoint location) {
		super(location);
		// Grass always starts with 100% vegetation. It can be 10-50% wet and 0-100% bumpy
		this.vegetation = 100;
		this.wet = (int)Math.floor(Math.random() * (50 - 10 + 1) + 10);
		this.bumpy = (int)Math.floor(Math.random() * (100 - 0 + 1) + 0);
	}
	
	// Draws the tile on the given Window
	public void draw(Draw duDwin) {
		super.draw(duDwin);
	}
	
	// Part of the draw template for concrete tiles to set the color
	public void setColor(Draw duDwin) {
		duDwin.setPenColor(0, (int)255 * (vegetation/100), 0);
	}
	
	// To string representation
	public String toString() {
		return("g");
	}

}
