package hw3;

import edu.du.dudraw.Draw;

public abstract class BirdAvatar extends Avatar {
	// Create instance variables unique to this class
	private String swimmingImage;
	private boolean isWalking;
	
	// Constructor
	protected BirdAvatar(GridPoint location, String walkImage, String swimImage, TerrainMap tm) {
		// Uses the super to set location, image, steps, layers to search, and the map
		super(location, walkImage, 1, 1, tm);
		
		// Sets an image for swimming and checks to see if the bird is currently swimming
		this.swimmingImage = swimImage;
		stateCheck();
	}
	
	// If my bird is walking, draw it with the default image, if its swimming draw it with the swimming image
	public void draw(Draw duDwin) {
		if(isWalking) {
			duDwin.picture(this.location.get_x(), TerrainMap.gridHeight - this.location.get_y(), this.image);
		}
		else {
			duDwin.picture(this.location.get_x(), TerrainMap.gridHeight - this.location.get_y(), this.swimmingImage);
		}
	}
	
	// Check to see if my bird is swimming or walking
	public void stateCheck() {
		// If my location is 100% wet the bird is swimming
		if (this.tm.getWetAtPoint(this.location) == 100) {
			this.isWalking = false;
		}
		// Otherwise the bird is walking
		else {
			this.isWalking = true;
		}
	}
	
	// Use the super class to move but then check to see if the new location is water or not
	public void move() {
		super.move();
		stateCheck();
	}
	
}
