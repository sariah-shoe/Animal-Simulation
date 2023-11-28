package hw3;

public class BadAvatarException extends Exception {
	// Exception for invalid avatar types
	public BadAvatarException(String msg){
		super(msg);
	}
}
