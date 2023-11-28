package hw3;

import edu.du.dudraw.Draw;

public class Mountain extends TerrainTile{
	
	// Mountain constructor
	public Mountain(GridPoint location) {
		super(location);
		// In the mountains vegetation can be 0-50%, wetness 10-50%, and bumpiness 50-100%
		this.vegetation = (int)Math.floor(Math.random() * (50 - 0 + 1) + 0);
		this.wet = (int)Math.floor(Math.random() * (50 - 10 + 1) + 10);
		this.bumpy = (int)Math.floor(Math.random() * (100 - 50 + 1) + 50);
	}
	
	// Draws the tile on the given Window
	public void draw(Draw duDwin) {
		
		super.draw(duDwin);
		// TODO: Get the derived class to set whatever color it wants by calling 
		// the abstract method.
		
		// TODO: draw the tile in a standard way
	}
	
	// Part of the draw template for concrete tiles to set the color
	public void setColor(Draw duDwin) {
		duDwin.setPenColor(100, (int)255 * (vegetation/100), 100);
	}
	
	// String representation of mountain
	public String toString() {
		return("m");
	}

}
