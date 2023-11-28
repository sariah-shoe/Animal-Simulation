package hw3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import edu.du.dudraw.Draw;

// The TerrainMap represents a 2D grid of Tiles

public class TerrainMap implements Drawable {

	private Map<GridPoint, TerrainTile> theTiles;
	
	// public static constants set in the constructor.
	public static int gridWidth;
	public static int gridHeight;

	// Constructor to read from file
	public TerrainMap(String filename) {
		// TODO: Read the map specified by `filename` and add
		// TerrainTile objects (based on the terrain type specified by the map)
		// to theTiles.œ
		
		// Create the map for the tiles
		this.theTiles = new HashMap();
		
		// Read in the file with a try catch to handle exceptions gracefully
		try {
			// Bring in my file and create a scanner for it
			FileReader frMap = new FileReader(filename);
			Scanner scan = new Scanner(frMap);
			
			// Get the first int which is the width
			if(scan.hasNextInt()) {
				gridWidth = scan.nextInt();
			}
			// If there isn't a value throw a malformed terrain file exception
			else {
				throw(new MalformedTerrainFileException("No height value on the map."));
			}
			
			// Get the second int which is the height
			if(scan.hasNextInt()) {
				gridHeight = scan.nextInt();
			}
			
			// If there isn't a value throw a malformed terrain file exception
			else {
				throw(new MalformedTerrainFileException("No width value on the map."));
			}
			
			// Loop through the height and width of the file
			for(int i = 0; i < gridHeight; i++) {
				for(int j = 0; j < gridWidth; j ++) {
					// Get the char value we are currently on
					char currentScan = scan.next().charAt(0);
					
					// Create a grid point for current location
					GridPoint currentLocation = new GridPoint(j, i);
					this.theTiles.put(currentLocation, TerrainTileFactory.newTerrainTile(currentScan, currentLocation));
				}
			}
			
		}
		
		// catch file not found exceptions
		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}
		// catch malformed terrain file exceptions
		catch(MalformedTerrainFileException e){
			System.out.println(e.getMessage());
		}
		// catch terrain file exceptions
		catch(TerrainFileException e) {
			System.out.println(e.getMessage());
		}

		
		// TODO: make sure you set gridWidth and gridHeight static data members when you 
		// read the map.
	}
	
	public void draw(Draw duDwin) {
		// TODO: cause each of the TerrainTile objects to draw itself.
		// Loop through the entire grid
		for(int i = 0; i < gridHeight; i++) {
			for(int j = 0; j < gridWidth; j ++) {
				// Get current location and use that to draw current tile
				GridPoint currentLocation = new GridPoint(j, i);
				this.theTiles.get(currentLocation).draw(duDwin);
			}
		}
	}
	
	// Gets a string representation of the map which I used for debugging
	public String toString() {
		String return_string = "";
		
		// Loop through the grid
		for(int i = 0; i < gridHeight; i++) {
			// New line for every row
			return_string += "\n";
			for(int j = 0; j < gridWidth; j ++) {
				// Terrain tile for every location
				GridPoint currentLocation = new GridPoint(i, j);
				return_string += this.theTiles.get(currentLocation) + ", ";
			}
		}
		// Return the string
		return(return_string);
	}
	
	// These next three methods are just getters for the three instance variables at various points
	public int getVegAtPoint(GridPoint location) {
		return(this.theTiles.get(location).getVeg());
	}
	
	public int getWetAtPoint(GridPoint location) {
		return(this.theTiles.get(location).getWet());
	}
	
	public int getBumpAtPoint(GridPoint location) {
		return(this.theTiles.get(location).getBump());
	}
	
	// A getter for the map itself when needed
	public Map<GridPoint, TerrainTile> getTheTiles() {
		return(this.theTiles);
	}

}
