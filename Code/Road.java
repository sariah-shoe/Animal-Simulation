package hw3;

import edu.du.dudraw.Draw;

public class Road extends TerrainTile{

	// Road constructor
	public Road(GridPoint location) {
		super(location);
		// Roads will always have 0 vegetation, wetness, and bumpiness
		this.vegetation = 0;
		this.wet = 0;
		this.bumpy = 0;
	}
	
	// Draws the tile on the given Window
	public void draw(Draw duDwin) {
		super.draw(duDwin);
	}
	
	// Part of the draw template for concrete tiles to set the color
	public void setColor(Draw duDwin) {
		duDwin.setPenColor(255, 255, 0);
	}
	
	// String representation of road
	public String toString() {
		return("r");
	}


}
