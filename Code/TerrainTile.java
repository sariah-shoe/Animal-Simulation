package hw3;

import edu.du.dudraw.Draw;

// This is an abstract class
public abstract class TerrainTile implements Drawable {
	
	// Every tile has a location, vegetation, wetness, and bumpiness
	private GridPoint location;
	protected int vegetation;
	protected int wet;
	protected int bumpy;
	
	// Terrain tile constructor
	protected TerrainTile (GridPoint location) {
		this.location = location;
	}

	// Draws the tile on the given Window
	public void draw(Draw duDwin) {

		// TODO: Get the derived class to set whatever color it wants by calling 
		// the abstract method.
		setColor(duDwin);
		
		// Create variables that get the width and height of a rectangle on the canvas
		double sizeX = 0.5;
		double sizeY = 0.5;
		
		// TODO: draw the tile in a standard way
		duDwin.filledRectangle(this.location.get_x() + 0.5, TerrainMap.gridHeight - this.location.get_y() - 0.5, sizeX, sizeY);
		
//		duDwin.filledRectangle(location.get_x() + 0.5, (TerrainMap.gridHeight - location.get_y() -1)+0.5, 0.5, 0.5);
//		duDwin.setPenColor();
//		duDwin.rectangle(location.get_x() + 0.5, (TerrainMap.gridHeight - location.get_y() -1) + 0.5, 0.5, 0.5);
	}
	
	// Make each child have a string representation
	public abstract String toString();
	
	// Part of the draw template for concrete tiles to set the color
	public abstract void setColor(Draw duDwin);
	
	// Return vegetation level
	public int getVeg() {
		return(this.vegetation);
	}
	
	// Return wetness level
	public int getWet() {
		return(this.wet);
	}
	
	// Return bumpiness level
	public int getBump() {
		return(this.bumpy);
	}
	
	// Changes the vegetation
	public void getEaten(int hunger) {
		// Only remove vegetation if there is vegetation to remove
		if(this.vegetation != 0) {
			this.vegetation = this.vegetation - hunger;
			// If my vegetation is less than 0, set it to 0
			if (this.vegetation < 0){
				this.vegetation = 0;
			}
		}
	}
	
}
