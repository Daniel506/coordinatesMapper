package mk.corel.coordinates.exceptions;



public class InvalidScaleException extends ScaleException {
  
  public InvalidScaleException() {
    super();
  }
  
  public InvalidScaleException(String message) {
    super(message);
  }
  
  public InvalidScaleException(String message, Throwable exception) {
    super(message, exception);
  }
}
