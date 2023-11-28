package hw3;

public class InvalidTerrainTypeException extends TerrainFileException{
	// Exception for invalid terrain types
	public InvalidTerrainTypeException(String msg) {
		super(msg);
	}

}
