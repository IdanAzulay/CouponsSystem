package zoolpon.project.exceptions;

@SuppressWarnings("serial")
public class InvalidLoginException extends Exception {
public InvalidLoginException() {
super("Invalid username  , password or login type");
}
}
