package hw3;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws BadAvatarException {
		// Load in the map
		TerrainMap tm = new TerrainMap("map1.txt");
		// Print line for debugging
		// System.out.println(tm);
		
		// Make a list for the animals
		List<Avatar> animals = new ArrayList();
		
		// Create variables for randomization of the animals
		int numAnimals = (int)Math.floor(Math.random() * (10 - 2 + 1) + 2);
		List<String> animalOptions = new ArrayList();
		animalOptions.add("Elephant");
		animalOptions.add("Duck");
		animalOptions.add("Penguin");
		
		// Create the random amount of animals
		for(int i = 0; i < numAnimals; i ++) {
			// Put the animal in a random starting position
			int randX = (int)Math.floor(Math.random() * ((tm.gridWidth - 1) - 0 + 1) + 0);
			int randY = (int)Math.floor(Math.random() * ((tm.gridHeight - 1) - 0 + 1) + 0);
			
			// Choose a random animal to put there
			String randAnimal = animalOptions.get((int)Math.floor(Math.random() * ((animalOptions.size() - 1) - 0 + 1) + 0));
			
			// Create the animal
			animals.add(AvatarFactory.newAvatar(randAnimal, tm, new GridPoint(randX, randY)));
		}
		
		// Create the human avatar
		Human human = (Human) AvatarFactory.newAvatar("Human", tm, new GridPoint(20, 20));
		
		// Make the display panel
		SimWindow window = new SimWindow(tm, animals, human);
		
		// Start the simulation
		window.runSimulation();
		
	}

}
