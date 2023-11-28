package hw3;

public class AvatarFactory {
	// Factory for Avatar creation
	public static Avatar newAvatar(String avaName, TerrainMap tm, GridPoint loc) throws BadAvatarException {
		// Check to see which avatar is being created and then make it
		if (avaName == "Duck") {
			return(new Duck(loc, tm));
		}
		else if (avaName == "Penguin") {
			return(new Penguin(loc, tm));
		}
		else if (avaName == "Elephant") {
			return(new Elephant(loc, tm));
		}
		else if (avaName == "Human") {
			return(new Human(loc, tm));
		}
		// If its an invalid avatar, throw an exception
		else {
			throw new BadAvatarException("Not a valid type of avatar");
		}
	}
}
