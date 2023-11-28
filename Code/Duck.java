package hw3;

public class Duck extends BirdAvatar {
	// Create a bird avatar that uses duck images
	public Duck(GridPoint location, TerrainMap tm) {
		super(location, "images/walkingDuck.png", "images/swimmingDuck.png", tm);
	}
}
