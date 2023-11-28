package hw3;

public class Penguin extends BirdAvatar{
	// Creates a bird avatar with penguin images
	public Penguin(GridPoint location, TerrainMap tm) {
		super(location, "images/walkingPenguin.png", "images/swimmingPenguin.png", tm);
	}
}
