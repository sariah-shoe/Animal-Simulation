package hw3;

import java.util.List;

import edu.du.dudraw.Draw;

public abstract class Avatar implements Drawable {
	// Create my protected instance variables
	protected GridPoint location;
	protected String image;
	protected int steps;
	protected int layers;
	protected TerrainMap tm;
	
	
	// Constructor
	protected Avatar(GridPoint location, String image, int steps, int layers, TerrainMap tm) {
		this.location = location;
		this.location.setOccupied(true);
		this.image = image;
		this.steps = steps;
		this.layers = layers;
		this.tm = tm;
	}
	
	// Draw method
	public void draw(Draw duDwin) {
		duDwin.picture(this.location.get_x(), TerrainMap.gridHeight - this.location.get_y(), this.image);
	}
	
	// Move method
	public void move() {
		// Get the neighbors for however many layers out the animal is searching
		List<GridPoint> neighbors = this.location.getNeighbors(layers, tm);
		
		// Get a random X and Y value that is as many steps as the animal wants to move
		int xDirection = (int)Math.floor(Math.random() * (this.steps - ((-1)* this.steps) + 1) + ((-1) * this.steps));
		int yDirection = (int)Math.floor(Math.random() * (this.steps - ((-1)* this.steps) + 1) + ((-1) * this.steps));
		
		// Add the new x and y values to the current one
		int newXLocation = this.location.get_x() + xDirection;
		int newYLocation = this.location.get_y() + yDirection;
		
		// If this is a valid new coordinate go through with the moving
		if (newXLocation < tm.gridWidth && newXLocation > 0 && newYLocation < tm.gridHeight && newYLocation > 0) {
			
			// If I have a neighbor at my new location, randomize new coordinates to avoid overlap
			if (neighbors.contains(new GridPoint(newXLocation, newYLocation))) {
				move();
			}
			
			// To go to the location set my current tile as unoccupied, set my new location, and set that as occupied
			else {
				this.location.setOccupied(false);
				this.location = new GridPoint(newXLocation, newYLocation);
				this.location.setOccupied(true);
			}	
		} 
	}
}
