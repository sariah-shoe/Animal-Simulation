package hw3;

public class Elephant extends Avatar {
	// Create an elephant avatar that looks 2 layers out for neighbors and moves 2 steps instead of one
	public Elephant(GridPoint location, TerrainMap tm) {
		super(location, "images/elephant.png", 2, 2, tm);
	}
	
	// Elephants move less than birds so some adjustments were made to move
	public void move() {
		// Get a random number between 0-2
		int choice = (int)Math.floor(Math.random() * (2 - 0 + 1) + 0);
		
		// If the choice is 2, the animal grazes
		if (choice == 2) {
			this.graze();
		}
		// If the choice is 1, the animal moves
		else if (choice == 1) {
			super.move();
		}
		// Otherwise the elephant doesn't do anything at all
	}
	
	// Method that allows the elephant to graze
	public void graze() {
		this.tm.getTheTiles().get(location).getEaten(5);
	}
}


