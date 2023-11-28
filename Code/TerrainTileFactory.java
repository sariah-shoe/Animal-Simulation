package hw3;

public class TerrainTileFactory {
	// Factory for creating terrain tiles
	public static TerrainTile newTerrainTile(char tileChar, GridPoint location) throws InvalidTerrainTypeException{
		// See if the current char matches one of our known types and create the tile
		if(tileChar == 'g'){
			return(new Grass(location));
		}
		else if(tileChar == 'w'){
			return(new Water(location));
		}
		else if(tileChar == 'r'){
			return(new Road(location));
		}
		else if(tileChar == 'm'){
			return(new Mountain(location));
		}
		// If it doesn't match throw TerrainFileException
		else {
			throw new InvalidTerrainTypeException("Invalid terrain type");
		}
	}
}
