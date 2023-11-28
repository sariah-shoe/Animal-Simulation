package hw3;

public class Human extends Avatar {
	// Create a human using default constructor
	public Human(GridPoint location, TerrainMap tm ) {
		super(location, "images/man.png", 1, 1, tm);
	}
	
	// The human has a special move constructor because it moves very differently
	public void humanMove(int location1, int location2) {
		PathFinder thePath = new PathFinder(tm);
		thePath.findPath(location, location);	
	}
	
	
}
